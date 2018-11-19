package com.qht.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultBuilder;
import com.qht.ResultObject;
import com.qht.biz.ClassroomMembersBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.ClassroomMembersDto;
import com.qht.dto.ClassroomMembersParameter;
import com.qht.dto.ClassroomParameter;
import com.qht.entity.ClassroomMembers;

@Controller
@RequestMapping("classroomMembers")
public class ClassroomMembersController extends BaseController<ClassroomMembersBiz,ClassroomMembers> {
	
	@Autowired
	private ClassroomMembersBiz biz;
	
	/**
	 * 获取课堂内的成员列表
	 * 购买该直播课程的所有学生
	 * @param requestObject
	 * @return
	 */
	@PostMapping("listMembers")
	@ResponseBody
	public ResultObject<List<ClassroomMembersDto>> listMembers(@RequestBody RequestObject<ClassroomParameter> requestObject){
		if(requestObject == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		ClassroomParameter param = requestObject.getData();
		if(param == null) {
			return ResultBuilder.error(requestObject, "-2", "请求参数为空");
		}		
		String class_id = param.getClass_id();
		ClassroomMembers entity = new ClassroomMembers();
		entity.setClassroomId(class_id);
		List<ClassroomMembers> sourceList = biz.selectList(entity);
		List<ClassroomMembersDto> targetList = BeanUtil.copyList(ClassroomMembersDto.class, sourceList);
		return ResultBuilder.success(requestObject, targetList);
	}
	
	//修改课堂内的成员信息
	@PostMapping("updateMembers")
	@ResponseBody
	public ResultObject<Void> updateMembers(@RequestBody RequestObject<ClassroomMembersParameter> requestObject){
		if(requestObject == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		ClassroomMembersParameter param = requestObject.getData();
		if(param == null) {
			return ResultBuilder.error(requestObject, "-2", "请求参数为空");
		}	
		
		Integer mic = param.getMic();
		String class_id = param.getClassroom_id();
		String studentId = param.getStudent_id();
		ClassroomMembers entity = new ClassroomMembers();
		entity.setClassroomId(class_id);
		entity.setStudentId(studentId);		
		List<ClassroomMembers> sourceList = biz.selectList(entity);
		if(sourceList == null || sourceList.size() == 0) {
			return ResultBuilder.error(requestObject, "-3", "该学生不在目标课堂中");
		}
		if(sourceList.size() > 0) {
			return ResultBuilder.error(requestObject, "-4", "该学生在目标课堂中重复");
		}
		ClassroomMembers members = sourceList.get(0);
		members.setMic(mic);
		biz.updateById(members);		
		return ResultBuilder.success(requestObject.getRequestId());
	}
}