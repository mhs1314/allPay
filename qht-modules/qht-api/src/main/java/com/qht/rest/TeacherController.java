package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.*;
import com.qht.common.util.BeanUtil;
import com.qht.common.util.IdGenUtil;
import com.qht.dto.*;
import com.qht.dto.CourseChapterDto;
import com.qht.entity.Teacher;
import com.qht.model.*;
import com.qht.services.TeacherService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("teacher")
public class TeacherController extends APIBaseController<TeacherBiz, Teacher> implements TeacherService {
	@Autowired
	private TeacherBiz teacherBiz;
	@Autowired
	private CoursePkgBiz coursePkgBiz;
	@Autowired
	private PeriodBiz periodBiz;
	@Autowired
	private ChapterBiz chapterBiz;
	@Autowired
	private MessageBiz messageBiz;
	@Autowired
	private PkgLevelBiz pkgLevelBiz;

	@Autowired
	private AnswerBiz answerBiz;

	@Override
	public ResultObject<String> login(RequestObject<LoginInfoDto> rquest) {
		return null;
	}

	@Override
	@PostMapping("indexMyCourse")
	@ResponseBody

	public ResultObject<List<IndexMyCourseDto>> indexMyCourse(
			@RequestBody RequestObject<IndexMyCourseParameter> requestObject) {

		IndexMyCourseParam param = new IndexMyCourseParam();

		BeanUtil.copyFields(param, requestObject.getData());

		PageHelper.startPage(Integer.parseInt(param.getPage()), Integer.parseInt(requestObject.getData().getLimit()));
		List<IndexMyCourseModel> models = coursePkgBiz.selectIndexMyCourseDto(param);
		List<IndexMyCourseDto> list = BeanUtil.copyList(IndexMyCourseDto.class, models);

		PageInfo<IndexMyCourseDto> count = new PageInfo<>(list);
		ResultObject<List<IndexMyCourseDto>> resultObject = new ResultObject<>();
		resultObject.setData(list);
		resultObject.setMsg("成功");
		resultObject.setCode("0");
		resultObject.setCount(count.getTotal());
		return resultObject;
	}

	@Override
	@PostMapping("indexMyCourseList")
	@ResponseBody

	public ResultObject<List<IndexMyCourseListDto>> indexMyCourseList(
			@RequestBody RequestObject<IndexMyCourseListParameter> requestObject) {
		IndexMyCourseListParam param = new IndexMyCourseListParam();
		BeanUtil.copyFields(param, requestObject.getData());

		PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),
				Integer.parseInt(requestObject.getData().getLimit()));
		List<IndexMyCourseListModel> indexMyCourseListDtos = coursePkgBiz.selectIndexMyCourseList(param);

		List<IndexMyCourseListDto> list = BeanUtil.copyList(IndexMyCourseListDto.class, indexMyCourseListDtos);
		PageInfo<IndexMyCourseListDto> count = new PageInfo<>(list);
		ResultObject<List<IndexMyCourseListDto>> resultObject = new ResultObject<>();
		resultObject.setData(list);
		resultObject.setMsg("成功");
		resultObject.setCode("0");
		resultObject.setCount(count.getTotal());
		return resultObject;
	}

	@Override
	@PostMapping("indexCourseAnswer")
	@ResponseBody

	public ResultObject<List<IndexCourseAnswerDto>> indexCourseAnswer(
			@RequestBody RequestObject<IndexCourseAnswerParameter> requestObject) {
		IndexCourseAnswerParam param = new IndexCourseAnswerParam();
		ResultObject<List<IndexCourseAnswerDto>> resultObject = new ResultObject<>();
		if (requestObject.getData() == null) {
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		BeanUtil.copyFields(param, requestObject.getData());
		PageHelper.startPage(Integer.parseInt(param.getPage()), Integer.parseInt(param.getLimit()));
		List<IndexCourseAnswerModel> indexCourseAnswerModels = answerBiz.selectIndexCourseAnswer(param);
		if (indexCourseAnswerModels == null) {
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<IndexCourseAnswerDto> list = BeanUtil.copyList(IndexCourseAnswerDto.class, indexCourseAnswerModels);
		resultObject.setData(list);
		resultObject.setMsg("成功");

		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("indexMessage")
	@ResponseBody
	public ResultObject<List<IndexMessageDto>> indexMessage(
			@RequestBody RequestObject<IndexMessageParameter> requestObject) {
		ResultObject<List<IndexMessageDto>> resultObject = new ResultObject<>();
		if (requestObject.getData() == null) {
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		IndexMessageParam param = new IndexMessageParam();
		BeanUtil.copyFields(param, requestObject.getData());
		PageHelper.startPage(Integer.parseInt(param.getPage()), Integer.parseInt(param.getLimit()));
		List<IndexMessageModel> indexMessageModels = messageBiz.selectIndexMessage(param);
		if (indexMessageModels == null) {
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<IndexMessageDto> list = BeanUtil.copyList(IndexMessageDto.class, indexMessageModels);
		resultObject.setData(list);
		resultObject.setMsg("成功");
		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("indexDelMessage")
	@ResponseBody
	public ResultObject<Void> indexDelMessage(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<Void> resultObject = new ResultObject<>();
		if (requestObject.getData() == null) {
			return resultObject.setMsg("失败");
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		Integer delLine = messageBiz.deleteMessaget(param);
		System.out.println("删除影响行数:" + delLine);
		resultObject.setMsg("成功");
		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("indexDelMessageDetails")
	@ResponseBody
	public ResultObject<IndexMessageDto> indexDelMessageDetails(
			@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<IndexMessageDto> resultObject = new ResultObject<>();
		if (requestObject.getData() == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new IndexMessageDto());
			return resultObject;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		IndexMessageModel indexMessageModel = messageBiz.selectIndexDelMessageDetails(param);
		if (indexMessageModel == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new IndexMessageDto());
			return resultObject;
		}
		IndexMessageDto data = new IndexMessageDto();
		BeanUtil.copyFields(data, indexMessageModel);
		resultObject.setMsg("成功");
		resultObject.setData(data);
		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("indexMyCourseDetails")
	@ResponseBody
	public ResultObject<IndexMyCourseDetailsDto> indexMyCourseDetails(
			@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<IndexMyCourseDetailsDto> resultObject = new ResultObject<>();
		if (requestObject.getData() == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new IndexMyCourseDetailsDto());
			return resultObject;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		IndexMyCourseDetailsModel indexMyCourseDetails = coursePkgBiz.selectIndexMyCourseDetails(param);
		if (indexMyCourseDetails == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new IndexMyCourseDetailsDto());
			return resultObject;
		}
		IndexMyCourseDetailsDto data = new IndexMyCourseDetailsDto();
		BeanUtil.copyFields(data, indexMyCourseDetails);
		resultObject.setMsg("成功");
		resultObject.setData(data);
		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("courseChapter")
	@ResponseBody
	public ResultObject<List<CourseChapterDto>> courseChapter(
			@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<List<CourseChapterDto>> resultObject = new ResultObject<>();
		if (requestObject.getData() == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		List<CourseChapterModel> courseChapterDtos = coursePkgBiz.selectCourseChapter(param);
		if (courseChapterDtos == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<CourseChapterDto> list = BeanUtil.copyList(CourseChapterDto.class, courseChapterDtos);
		resultObject.setMsg("成功");
		resultObject.setData(list);
		resultObject.setCode("0");
		return resultObject;
	}

	/**
	 * app添加课程包
	 */
	@Override
	@PostMapping("common/appIndexAddLCourse")
	@ResponseBody
	public ResultObject<UidAndTenantID> appIndexAddLCourse(
			@RequestBody RequestObject<InsertCoursePkgParameter> requestObject) {
		if (requestObject.getData() == null) {
			ResultObject<UidAndTenantID> robj = new ResultObject<>();
			robj.setMsg("没有参数");
			robj.setCode("1");
		}

		InsertCoursePkgParam param = new InsertCoursePkgParam();
		Integer easy = pkgLevelBiz.selectValue(param.getPkg_level_id());
		BeanUtil.copyFields(param, requestObject.getData());
		param.setUid(IdGenUtil.getUid("KP"));
		param.setEasy(easy);
		param.setStatus("1");
		param.setCreate_time(new Date());
		Integer result = coursePkgBiz.indexAddLCourse(param);
		if (result == null || result <= 0) {
			ResultObject<Void> robj = new ResultObject<>();
			robj.setMsg("添加失败");
			robj.setCode("1");
		}
		ResultObject<UidAndTenantID> robj = new ResultObject<>();
		UidAndTenantID uid = new UidAndTenantID();
		uid.setUid(param.getUid());
		robj.setMsg("添加成功");
		robj.setData(uid);
		robj.setCode("0");
		return robj;
	}

	/**
	 * app添加章节
	 */
	@Override
	@PostMapping("common/indexAddLCourseChapter")
	@ResponseBody
	public ResultObject<Void> appInsertChapter(@RequestBody RequestObject<AppInsertChapterParameter> requestObject) {
		if (requestObject.getData() == null) {
			ResultObject<Void> robj = new ResultObject<>();
			robj.setMsg("没有参数");
			robj.setCode("1");
		}
		AppInsertChapterParam param = new AppInsertChapterParam();
		BeanUtil.copyFields(param, requestObject.getData());
		param.setUid(IdGenUtil.getUid("ZJ"));
		Integer result = chapterBiz.appInsertChapter(param);
		if (result == null || result <= 0) {
			ResultObject<Void> robj = new ResultObject<>();
			robj.setMsg("添加失败");
			robj.setCode("1");
		}
		ResultObject<Void> robj = new ResultObject<>();
		robj.setMsg("添加成功");
		robj.setCode("0");
		return robj;
	}

	/**
	 * app修改课程包
	 */
	@Override
	@PostMapping("common/indexEditLCourse")
	@ResponseBody
	public ResultObject<Void> appUpdateCoursePkgByid(
			@RequestBody RequestObject<InsertCoursePkgParameter> requestObject) {
		if (requestObject.getData() == null) {
			ResultObject<Void> robj = new ResultObject<>();
			robj.setMsg("没有参数");
			robj.setCode("1");
		}
		InsertCoursePkgParam param = new InsertCoursePkgParam();
		Integer easy = pkgLevelBiz.selectValue(param.getPkg_level_id());
		BeanUtil.copyFields(param, requestObject.getData());
		param.setEasy(easy);
		param.setStatus("1");
		param.setCreate_time(new Date());
		Integer result = coursePkgBiz.appUpdateCoursePkgByid(param);
		if (result == null || result <= 0) {
			ResultObject<Void> robj = new ResultObject<>();
			robj.setMsg("修改失败");
			robj.setCode("1");
		}
		ResultObject<Void> robj = new ResultObject<>();
		robj.setMsg("修改成功");
		robj.setCode("0");
		return robj;
	}

	/**
	 * 课程包章节课时信息
	 */
	@Override
	@PostMapping("common/indexAddLCourseChapterperiod")
	@ResponseBody
	public ResultObject<List<SelectPkgDto>> selectPkgDto(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		if (requestObject.getData() == null) {
			ResultObject<List<SelectPkgDto>> resultObj = new ResultObject<>();
			resultObj.setCode("1");
			resultObj.setMsg("传入参数为空");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();

		BeanUtil.copyFields(param, requestObject.getData());

		List<SelectPkgModel> models = coursePkgBiz.selectPkgModel(param);
		if (models.size() == 0) {
			ResultObject<List<SelectPkgDto>> resultObj = new ResultObject<>();
			resultObj.setCode("0");
			resultObj.setMsg("没有数据哦");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		List<SelectPkgDto> list = new ArrayList<SelectPkgDto>();
		for (SelectPkgModel model : models) {
			list.add(model.toDto());
		}
		ResultObject<List<SelectPkgDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}
	/**
	 * 教师首页章节
	 */
	@Override
	@PostMapping("common/indexCourseChapterInfo")
	@ResponseBody
	public ResultObject<List<CourseChapterDto>> selectChapterByid(
			@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<List<CourseChapterDto>> resultObject = new ResultObject<>();
		if (requestObject.getData() == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		List<CourseChapterModel> courseChapterDtos = chapterBiz.selectChapterByid(param);
		if (courseChapterDtos == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<CourseChapterDto> list = BeanUtil.copyList(CourseChapterDto.class, courseChapterDtos);
		resultObject.setMsg("成功");
		resultObject.setData(list);
		resultObject.setCode("0");
		return resultObject;
	}
	/**
	 * 查询课时
	 */
	@Override
	@PostMapping("common/indexCoursePeriodInfo")
	@ResponseBody
	public ResultObject<List<CourseChapterDto>> selectPeriodByid(
			@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<List<CourseChapterDto>> resultObject = new ResultObject<>();
		if (requestObject.getData() == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		List<CourseChapterModel> courseChapterDtos = periodBiz.selectPeriodByid(param);
		if (courseChapterDtos == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<CourseChapterDto> list = BeanUtil.copyList(CourseChapterDto.class, courseChapterDtos);
		resultObject.setMsg("成功");
		resultObject.setData(list);
		resultObject.setCode("0");
		return resultObject;
	}
	/**
	 * 添加课时
	 */
	@Override
	@PostMapping("common/indexAddLCoursePeriod")
	@ResponseBody
	public ResultObject<Void> insertPerIod(@RequestBody RequestObject<AppInsertPerIodParameter> requestObject) {
		if (requestObject.getData() == null) {
			ResultObject<Void> result = new ResultObject<>();
			result.setMsg("没有参数");
			result.setCode("1");
		}
		AppInsertPerIodParam param = new AppInsertPerIodParam();
		BeanUtil.copyFields(param, requestObject.getData());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date beginDate=null;
		if(requestObject.getData().getBegin()!=null) {
			//转换开始时间戳为正常时间
		 beginDate=new Date(requestObject.getData().getBegin()); 
		 param.setBegin(beginDate);
		 //开始时间加播放时长加10分钟
		 Date overDate=new Date((beginDate.getTime()+param.getTime_length()+10*60*1000));
		 param.setOver(overDate);
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(param.getOver());//设置起时间
		 cal.add(Calendar.YEAR, 1);//增加一年	
		 param.setEffective_time(cal.getTime());
		}
		if(requestObject.getData().getEffective_time()==null) {
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(new Date());//设置起时间
			 cal.add(Calendar.YEAR, 1);//增加一年	
			param.setEffective_time(cal.getTime());
		}
    	param.setUid(IdGenUtil.getUid("KS"));
		
		Integer result = periodBiz.insertPerIod(param);
		if (result == null || result <= 0) {
			ResultObject<Void> robj = new ResultObject<>();
			robj.setMsg("添加课时失败");
			robj.setCode("1");
		}
		ResultObject<Void> robj = new ResultObject<>();
		robj.setMsg("添加课时成功");
		robj.setCode("0");
		return robj;
	}
	/**
	 * 经过老师id查询所有课时
	 */
	@Override
	@PostMapping("app/myCollectTable")
	@ResponseBody
	public ResultObject<List<SelectPeriodByTeacherIdDto>> selectPeriodByTeachId(
			@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<List<SelectPeriodByTeacherIdDto>> resultObject = new ResultObject<>();
		if (requestObject.getData() == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		List<SelectPeriodByTeacherIdModel> courseChapterDtos =periodBiz.selectPeriodByTeachId(param);
		if (courseChapterDtos == null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<SelectPeriodByTeacherIdDto> list = BeanUtil.copyList(SelectPeriodByTeacherIdDto.class, courseChapterDtos);
		resultObject.setMsg("成功");
		resultObject.setData(list);
		resultObject.setCode("0");
		return resultObject;
	}
	/**
	 * 课时详情
	 */
	@Override
	@PostMapping("app/myPeriodDetail")
	@ResponseBody
	public ResultObject<PeriodDetailsDto> selectPeriodDetails(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
    	if( requestObject.getData()==null) {
    		ResultObject<PeriodDetailsDto> resultObject=new ResultObject<>();
            resultObject.setCode("1");
            resultObject.setMsg("参数不对");
            resultObject.setData(new PeriodDetailsDto());
            return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
    	PeriodDetailsModel model=periodBiz.selectPeriodDetails(param);
        if(model==null) {
        	 ResultObject<PeriodDetailsDto> resultObject=new ResultObject<>();
             resultObject.setCode("0");
             resultObject.setMsg("成功");
             resultObject.setData(new PeriodDetailsDto());
             return resultObject;
        }
       
        PeriodDetailsDto dto=new PeriodDetailsDto();
        BeanUtil.copyFields(dto, model);
        ResultObject<PeriodDetailsDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
	}
	/**
	 * App教师个人中心详细
	 */
	@Override
	@PostMapping("app/myTeacherInfo")
	@ResponseBody
	public ResultObject<AppSelectTeacherByidDto> selectTeacherByid(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
    	if( requestObject.getData()==null) {
    		ResultObject<AppSelectTeacherByidDto> resultObject=new ResultObject<>();
            resultObject.setCode("1");
            resultObject.setMsg("参数不对");
            resultObject.setData(new AppSelectTeacherByidDto());
            return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());

    	AppSelectTeacherByidModel model=teacherBiz.selectTeacherByid(param);
        if(model==null) {
        	 ResultObject<AppSelectTeacherByidDto> resultObject=new ResultObject<>();
             resultObject.setCode("0");
             resultObject.setMsg("成功");
             resultObject.setData(new AppSelectTeacherByidDto());
             return resultObject;
        }
       
        AppSelectTeacherByidDto dto=new AppSelectTeacherByidDto();
        BeanUtil.copyFields(dto, model);
        ResultObject<AppSelectTeacherByidDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
	}

	@Override
	@PostMapping("indexMyCourseEditChapterAndPeriod")
	@ResponseBody
	public ResultObject<IndexMyCourseEditChapterAndPeriodDto> indexMyCourseEditChapterAndPeriodDto(@RequestBody RequestObject<UidAndTenantID> requestObject) {

		ResultObject<IndexMyCourseEditChapterAndPeriodDto> resultObject=new ResultObject<>();
		if(requestObject.getData()==null){
			return resultObject.setMsg("参数为空");
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param,requestObject.getData());
		IndexMyCourseEditChapterAndPeriodModel model=coursePkgBiz.selectIndexMyCourseEditChapterAndPeriodModel(param);
		if(model==null){
			return resultObject.setMsg("查询结果为空");
		}
		IndexMyCourseEditChapterAndPeriodDto dto=new IndexMyCourseEditChapterAndPeriodDto();
		BeanUtil.copyFields(dto,model);
		List<ChapterModel> chapterModels=model.getChapter();

		List<ChapterDto> chapterDtos=new ArrayList<>();
		for(int i=0;i<model.getChapter().size();i++){
			ChapterDto chapterDto=new ChapterDto();
			BeanUtil.copyFields(chapterDto,model.getChapter().get(i));
			List<PeriodDto> periodDtos=new ArrayList<>();
			ListIterator it = chapterModels.listIterator();
			while(it.hasNext()){
				PeriodDto periodDto=new PeriodDto();
				BeanUtil.copyFields(periodDto,it.next());
				periodDtos.add(periodDto);
			}
			chapterDto.setPeriods(periodDtos);
			chapterDtos.add(chapterDto);
		}
		dto.setChapters(chapterDtos);
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(dto);
		return resultObject;
	}

	@Override
	@PostMapping("teacherInfo")
	@ResponseBody
	public ResultObject<PCTeacherInfoDto> teacherInfo(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<PCTeacherInfoDto> resultObject=new ResultObject<>();
		if(requestObject.getData()==null){
			return resultObject.setMsg("参数为空");
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param,requestObject.getData());
		PCTeacherInfoModel model=teacherBiz.selectTeacherInfo(param);
		if(model==null){
			return resultObject.setMsg("查询无结果");
		}
		PCTeacherInfoDto dto=new PCTeacherInfoDto();
		BeanUtil.copyFields(dto,model);
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(dto);
		return resultObject;
	}


}
