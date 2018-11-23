package com.qht.rest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.qht.RequestObject;
import com.qht.ResultBuilder;
import com.qht.ResultObject;
import com.qht.biz.ClassroomBiz;
import com.qht.biz.ClassroomMembersBiz;
import com.qht.biz.PeriodBiz;
import com.qht.biz.StudentBiz;
import com.qht.biz.TeacherBiz;
import com.qht.biz.TencentCloud;
import com.qht.common.util.IdGenUtil;
import com.qht.dto.ClassroomDto;
import com.qht.dto.ClassroomParameter;
import com.qht.dto.ClassroomStatusDto;
import com.qht.dto.GroupBodyDto;
import com.qht.entity.Classroom;
import com.qht.entity.ClassroomMembers;
import com.qht.entity.Period;
import com.qht.entity.Teacher;

import tk.mybatis.mapper.util.StringUtil;

@Controller
@RequestMapping("classroom")
public class ClassroomController extends APIBaseController<ClassroomBiz,Classroom> {
	private static final Logger log = LoggerFactory.getLogger(ClassroomController.class);
	@Autowired
	private ClassroomBiz biz;
	
	@Autowired
	private TeacherBiz teacherBiz;
	
	@Autowired
	private StudentBiz studentBiz;
	
	@Autowired
	private ClassroomMembersBiz classroomMembersBiz;
	
	@Autowired
	private TencentCloud tencentCloud;
	
	@Autowired
	private PeriodBiz periodBiz;
	
	/**
	 *  获取当前课程是否已创建好直播课堂
	 *  param 
	 *  retrurn conf_id
	 */
	@PostMapping("getClassroomByPeriodId")
	@ResponseBody
	public ResultObject<ClassroomDto> getClassroomByPeriodId(@RequestBody RequestObject<ClassroomParameter> requestObject) {
		if(requestObject == null || requestObject.getData() == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		
		String periodId = requestObject.getData().getClass_id();		
		List<Classroom> list = biz.getClassroomByPeriodId(periodId);
		ClassroomDto dto = new ClassroomDto(); 
		if(list != null && list.size() > 0) {
			String conf_id = list.get(0).getUid();
			dto.setConf_id(conf_id);
		}else {
			dto.setConf_id(null);
		}		
		return ResultBuilder.success(requestObject, dto);
	}
	/**
	 * 创建直播课堂
	 * 检查当前ID是否教师ID
	 * 创建课堂
	 * 返回课堂ID
	 * @param requestObject
	 * @return
	 */
	@PostMapping("create")
	@ResponseBody
	public ResultObject<ClassroomDto> create(@RequestBody RequestObject<ClassroomParameter> requestObject){
		if(requestObject == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		ClassroomParameter param = requestObject.getData();
		if(param == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		//根据课程判断是否已经创建过课堂
		String periodId = param.getClass_id();
		String teacherId = param.getTeacher_id();
		//Classroom cr = new Classroom();	
		//cr.setPeriodId(periodId);
		String groupId = null;
		List<Classroom> list = biz.getClassroomByPeriodId(periodId);
		if(list != null && list.size() > 0) {
			Classroom entity = list.get(0);
			if(StringUtil.isEmpty(entity.getImGroupId()) || StringUtil.isEmpty(entity.getWhiteboardId())) {
				groupId = getGroupId(teacherId);
				entity.setImGroupId(groupId);
				entity.setWhiteboardId(groupId);
				biz.updateById(entity);
			}			
			ClassroomDto dto = entityToDto(entity);
			return ResultBuilder.success(requestObject, dto);
		}
		
		
		Teacher teacher = teacherBiz.selectById(teacherId);
		if(teacher == null) {
			return ResultBuilder.error(requestObject, "-2", "需要教师才可以创建课堂");
		}
		//获取课堂ID
		String uid = IdGenUtil.getUid("CR");
		//屏幕状态  camera / board
		String screen = param.getHome_screen();
		if(!"camera".equals(screen) && !"board".equals(screen)) {
			return ResultBuilder.error(requestObject, "-3", "home_screen只能为camera或board");
		}
		//TDOO 需要接受教师的uid,还需要接受课堂名称
		//String json = tencentCloud.createGroup(teacherId);
		//GroupBodyDto body = JSON.parseObject(json, GroupBodyDto.class);		
		Classroom entity = new Classroom();	
		if(StringUtil.isEmpty(groupId)) {
			groupId = getGroupId(teacherId);
		}
		entity.setImGroupId(groupId);
		entity.setWhiteboardId(groupId);
		entity.setHomeScreen(screen);
		//需要一个固定的groupId				
		entity.setPeriodId(param.getClass_id());
		//TODO需要问海燕roomId-自定义的
		entity.setRoomId(123456);
		entity.setTeacherId(teacherId);
		entity.setUid(uid);
		entity.setCreateTime(new Date());
		biz.insert(entity);
		ClassroomDto dto = entityToDto(entity);		
		return ResultBuilder.success(requestObject, dto);
	}
	
	private String getGroupId(String teacherId) {
		String json = tencentCloud.createGroup(teacherId);
		GroupBodyDto body = JSON.parseObject(json, GroupBodyDto.class);			
		return body.getGroupId();
		
	}
	private ClassroomDto entityToDto(Classroom entity) {
		ClassroomDto dto = new ClassroomDto(); 
		dto.setConf_id(entity.getUid());		
		dto.setRoom_id(entity.getRoomId());
		dto.setGroup_id(entity.getImGroupId());
		dto.setBoard_group_id(entity.getImGroupId());
		return dto;
	}
	
	//加入直播课堂
	@PostMapping("join")
	@ResponseBody
	public ResultObject<ClassroomDto> join(@RequestBody RequestObject<ClassroomParameter> requestObject) {		
		if(requestObject == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		ClassroomParameter param = requestObject.getData();
		if(param == null) {
			return ResultBuilder.error(requestObject, "-2", "请求参数为空");
		}
		String studentId = param.getStudent_id();	
		String classroomId = param.getClass_id();
		Classroom classroom = biz.selectById(classroomId);
		if(classroom == null) {
			//TODO 需要确保教师与学生的身份	
			ClassroomMembers entity = new ClassroomMembers();		
			entity.setUid(UUID.randomUUID().toString());
			entity.setStudentId(studentId);
			entity.setClassroomId(classroomId);				
			classroomMembersBiz.insert(entity);	
			classroom = biz.selectById(classroomId);
		}
		
		ClassroomDto dto = new ClassroomDto(); 
		dto.setRoom_id(classroom.getRoomId());
		dto.setOwner(classroom.getTeacherId());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(classroom.getCreateTime() != null) {
			String create_time = sdf.format(classroom.getCreateTime());	    
			dto.setCreate_time(create_time);
		}else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDateTime date = LocalDateTime.now();
			String create_time = date.format(formatter);
			dto.setCreate_time(create_time);
		}		
		dto.setGroup_id(classroom.getImGroupId());
		Period period = periodBiz.selectById(classroom.getPeriodId());
		if(period == null) {
			return ResultBuilder.error(requestObject, "-3", "该课时ID不存在"+classroom.getPeriodId());
		}else {
			dto.setConf_name(period.getName());
		}		
		dto.setBoard_group_id(classroom.getWhiteboardId());
		dto.setConf_id(classroomId);		
		dto.setHome_screen(classroom.getHomeScreen());		
		return ResultBuilder.success(requestObject, dto);
	}
	//获取课堂状态
	@PostMapping("getStatus")
	@ResponseBody
	public ResultObject<ClassroomStatusDto> getStatus(@RequestBody RequestObject<ClassroomParameter> requestObject){
		if(requestObject == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		ClassroomParameter param = requestObject.getData();
		if(param == null) {
			return ResultBuilder.error(requestObject, "-2", "请求参数为空");
		}
		//课堂ID
		String class_id = param.getClass_id();
		if(StringUtil.isEmpty(class_id)) {
			return ResultBuilder.error(requestObject, "-2", "课堂ID为空");
		}
		Classroom croom = biz.selectById(class_id);
		ClassroomStatusDto dto = new ClassroomStatusDto();
		String teacherId = param.getTeacher_id();
		Teacher teacher = teacherBiz.selectById(teacherId);
		dto.setAdmin_id(croom.getTeacherId());
		dto.setAdmin_nick(teacher.getNickname());
		dto.setHome_screen(croom.getHomeScreen());
		
		return ResultBuilder.success(requestObject, dto);
	}
	
	//改变当前课堂信息
	@PostMapping("updateStatus")
	@ResponseBody
	public ResultObject<Void> updateStatus(@RequestBody RequestObject<ClassroomParameter> requestObject){
		if(requestObject == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		ClassroomParameter param = requestObject.getData();
		if(param == null) {
			return ResultBuilder.error(requestObject, "-2", "请求参数为空");
		}
		String class_id = param.getClass_id();
		if(StringUtil.isEmpty(class_id)) {
			return ResultBuilder.error(requestObject, "-3", "课堂ID为空");
		}
		Classroom croom = biz.selectById(class_id);
		if(croom == null) {
			return ResultBuilder.error(requestObject, "-4", "课堂不存在");
		}
		
		String screen = param.getHome_screen();
		if(!"camera".equals(screen) && !"board".equals(screen)) {
			return ResultBuilder.error(requestObject, "-3", "home_screen只能为camera或board");
		}
		croom.setHomeScreen(screen);
		biz.updateById(croom);
		return ResultBuilder.success(requestObject.getRequestId());
	}
	
	
	
}