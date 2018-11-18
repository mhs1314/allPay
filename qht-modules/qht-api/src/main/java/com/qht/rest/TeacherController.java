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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("teacher")
public class TeacherController extends APIBaseController<TeacherBiz,Teacher> implements TeacherService {
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

    @Override
    public ResultObject<String> login(RequestObject<LoginInfoDto> rquest) {
        return null;
    }

    @Override
    @PostMapping("indexMyCourse")
    @ResponseBody

    public ResultObject<List<IndexMyCourseDto>> indexMyCourse(@RequestBody RequestObject<IndexMyCourseParameter> requestObject) {
    	
        IndexMyCourseParam param=new IndexMyCourseParam();
        
        BeanUtil.copyFields(param, requestObject.getData());
        
    	PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(requestObject.getData().getLimit()));
        List<IndexMyCourseModel> models=teacherBiz.selectIndexMyCourseDto(param);
       List<IndexMyCourseDto> list = BeanUtil.copyList(IndexMyCourseDto.class, models);
        
        PageInfo<IndexMyCourseDto> count=new PageInfo<>(list);
        ResultObject<List<IndexMyCourseDto>> resultObject=new ResultObject<>();
        resultObject.setData(list);
        resultObject.setMsg("成功");
        resultObject.setCode("0");
        resultObject.setCount(count.getTotal());
        return resultObject;
    }

    @Override
    @PostMapping("indexMyCourseList")
    @ResponseBody

    public ResultObject<List<IndexMyCourseListDto>> indexMyCourseList(@RequestBody RequestObject<IndexMyCourseListParameter> requestObject) {
    	IndexMyCourseListParam param=new IndexMyCourseListParam();
    	BeanUtil.copyFields(param, requestObject.getData());
    	
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
        List<IndexMyCourseListModel> indexMyCourseListDtos=teacherBiz.selectIndexMyCourseList(param);
       
        List<IndexMyCourseListDto> list = BeanUtil.copyList(IndexMyCourseListDto.class, indexMyCourseListDtos);
        PageInfo<IndexMyCourseListDto> count=new PageInfo<>(list);
        ResultObject<List<IndexMyCourseListDto>> resultObject=new ResultObject<>();
        resultObject.setData(list);
        resultObject.setMsg("成功");
        resultObject.setCode("0");
        resultObject.setCount(count.getTotal());
        return resultObject;
    }


	@Override
	@PostMapping("indexCourseAnswer")
    @ResponseBody

	public ResultObject<List<IndexCourseAnswerDto>> indexCourseAnswer(@RequestBody
			RequestObject<IndexCourseAnswerParameter> requestObject) {
		IndexCourseAnswerParam param=new IndexCourseAnswerParam();
		ResultObject<List<IndexCourseAnswerDto>> resultObject=new ResultObject<>();
		if(requestObject.getData()==null) {
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		BeanUtil.copyFields(param, requestObject.getData());
		PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(param.getLimit()));
		List<IndexCourseAnswerModel> indexCourseAnswerModels=teacherBiz.selectIndexCourseAnswer(param);
		if(indexCourseAnswerModels==null) {
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
	public ResultObject<List<IndexMessageDto>> indexMessage(@RequestBody RequestObject<IndexMessageParameter> requestObject) {
		ResultObject<List<IndexMessageDto>> resultObject=new ResultObject<>();
		if(requestObject.getData()==null) {
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		IndexMessageParam param=new IndexMessageParam();
		BeanUtil.copyFields(param, requestObject.getData());
		PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(param.getLimit()));
		List<IndexMessageModel> indexMessageModels=teacherBiz.selectIndexMessage(param);
		if(indexMessageModels==null) {
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<IndexMessageDto> list=BeanUtil.copyList(IndexMessageDto.class, indexMessageModels);
		resultObject.setData(list);
		resultObject.setMsg("成功");
		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("indexDelMessage")
	@ResponseBody
	public ResultObject<Void> indexDelMessage(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<Void> resultObject=new ResultObject<>();
		if(requestObject.getData()==null) {
			return resultObject.setMsg("失败");
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		Integer delLine=messageBiz.deleteMessage(param);
		System.out.println("删除影响行数:"+delLine);
		resultObject.setMsg("成功");
		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("indexDelMessageDetails")
	@ResponseBody
	public ResultObject<IndexMessageDto> indexDelMessageDetails(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<IndexMessageDto> resultObject=new ResultObject<>();
		if(requestObject.getData()==null) {
			resultObject.setMsg("失败");
			resultObject.setData(new IndexMessageDto());
			return resultObject;
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		IndexMessageModel indexMessageModel=messageBiz.selectIndexDelMessageDetails(param);
		if(indexMessageModel==null){
			resultObject.setMsg("失败");
			resultObject.setData(new IndexMessageDto());
			return resultObject;
		}
		IndexMessageDto data=new IndexMessageDto();
		BeanUtil.copyFields(data, indexMessageModel);
		resultObject.setMsg("成功");
		resultObject.setData(data);
		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("indexMyCourseDetails")
	@ResponseBody
	public ResultObject<IndexMyCourseDetailsDto> indexMyCourseDetails(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<IndexMyCourseDetailsDto> resultObject=new ResultObject<>();
		if(requestObject.getData()==null) {
			resultObject.setMsg("失败");
			resultObject.setData(new IndexMyCourseDetailsDto());
			return resultObject;
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		IndexMyCourseDetailsModel indexMyCourseDetails=coursePkgBiz.selectIndexMyCourseDetails(param);
		if(indexMyCourseDetails==null){
			resultObject.setMsg("失败");
			resultObject.setData(new IndexMyCourseDetailsDto());
			return resultObject;
		}
		IndexMyCourseDetailsDto data=new IndexMyCourseDetailsDto();
		BeanUtil.copyFields(data, indexMyCourseDetails);
		resultObject.setMsg("成功");
		resultObject.setData(data);
		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("courseChapter")
	@ResponseBody
	public ResultObject<List<CourseChapterDto>> courseChapter(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<List<CourseChapterDto>> resultObject=new ResultObject<>();
		if(requestObject.getData()==null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		List<CourseChapterModel> courseChapterDtos=coursePkgBiz.selectCourseChapter(param);
		if(courseChapterDtos==null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<CourseChapterDto> list=BeanUtil.copyList(CourseChapterDto.class, courseChapterDtos);
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
	public ResultObject<UidAndTenantID> appIndexAddLCourse(@RequestBody RequestObject<InsertCoursePkgParameter> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<UidAndTenantID> robj=new ResultObject<>();
			robj.setMsg("没有参数");
			robj.setCode("1");
		}
		
		InsertCoursePkgParam param=new InsertCoursePkgParam();
		Integer easy = pkgLevelBiz.selectValue(param.getPkg_level_id());
		BeanUtil.copyFields(param, requestObject.getData());
		param.setUid(IdGenUtil.getUid("KP"));
		param.setEasy(easy);
		param.setStatus("1");
		param.setCreate_time(new Date());
		Integer result = coursePkgBiz.indexAddLCourse(param);
		if(result==null||result<=0) {
			ResultObject<Void> robj=new ResultObject<>();
			robj.setMsg("添加失败");
			robj.setCode("1");
		}
			ResultObject<UidAndTenantID> robj=new ResultObject<>();
			UidAndTenantID uid=new UidAndTenantID();
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
		if(requestObject.getData()==null) {
			ResultObject<Void> robj=new ResultObject<>();
			robj.setMsg("没有参数");
			robj.setCode("1");
		}
		AppInsertChapterParam param=new AppInsertChapterParam();
		BeanUtil.copyFields(param, requestObject.getData());
		param.setUid(IdGenUtil.getUid("ZJ"));
		Integer result = chapterBiz.appInsertChapter(param);
		if(result==null||result<=0) {
			ResultObject<Void> robj=new ResultObject<>();
			robj.setMsg("添加失败");
			robj.setCode("1");
		}
			ResultObject<Void> robj=new ResultObject<>();
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
	public ResultObject<Void> appUpdateCoursePkgByid(@RequestBody RequestObject<InsertCoursePkgParameter> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<Void> robj=new ResultObject<>();
			robj.setMsg("没有参数");
			robj.setCode("1");
		}
		InsertCoursePkgParam param=new InsertCoursePkgParam();
		Integer easy = pkgLevelBiz.selectValue(param.getPkg_level_id());
		BeanUtil.copyFields(param, requestObject.getData());
		param.setEasy(easy);
		param.setStatus("1");
		param.setCreate_time(new Date());
		Integer result = coursePkgBiz.appUpdateCoursePkgByid(param);
		if(result==null||result<=0) {
			ResultObject<Void> robj=new ResultObject<>();
			robj.setMsg("修改失败");
			robj.setCode("1");
		}
			ResultObject<Void> robj=new ResultObject<>();
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
		if(requestObject.getData()==null) {
			ResultObject<List<SelectPkgDto>> resultObj = new ResultObject<>();
			resultObj.setCode("1");
			resultObj.setMsg("传入参数为空");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();

		BeanUtil.copyFields(param, requestObject.getData());

		List<SelectPkgModel> models = coursePkgBiz.selectPkgModel(param);
		if(models.size()==0) {
			ResultObject<List<SelectPkgDto>> resultObj = new ResultObject<>();
			resultObj.setCode("0");
			resultObj.setMsg("没有数据哦");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		List<SelectPkgDto> list = new ArrayList<SelectPkgDto>();		
		for(SelectPkgModel model : models) {
			list.add(model.toDto());
		}
		ResultObject<List<SelectPkgDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}

	@Override
	@PostMapping("common/indexCourseChapterInfo")
    @ResponseBody
	public ResultObject<List<CourseChapterDto>> selectChapterByid(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<List<CourseChapterDto>> resultObject=new ResultObject<>();
		if(requestObject.getData()==null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		List<CourseChapterModel> courseChapterDtos=chapterBiz.selectChapterByid(param);
		if(courseChapterDtos==null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<CourseChapterDto> list=BeanUtil.copyList(CourseChapterDto.class, courseChapterDtos);
		resultObject.setMsg("成功");
		resultObject.setData(list);
		resultObject.setCode("0");
		return resultObject;
	}

	@Override
	@PostMapping("common/indexCoursePeriodInfo")
    @ResponseBody
	public ResultObject<List<CourseChapterDto>> selectPeriodByid(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<List<CourseChapterDto>> resultObject=new ResultObject<>();
		if(requestObject.getData()==null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		List<CourseChapterModel> courseChapterDtos=periodBiz.selectPeriodByid(param);
		if(courseChapterDtos==null) {
			resultObject.setMsg("失败");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<CourseChapterDto> list=BeanUtil.copyList(CourseChapterDto.class, courseChapterDtos);
		resultObject.setMsg("成功");
		resultObject.setData(list);
		resultObject.setCode("0");
		return resultObject;
	}
	
}
