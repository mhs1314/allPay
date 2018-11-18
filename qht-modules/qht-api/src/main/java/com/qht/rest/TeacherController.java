package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Array;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.*;
import com.qht.services.TeacherService;

import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qht.biz.ChapterBiz;

import com.qht.biz.CoursePkgBiz;
import com.qht.biz.MessageBiz;
import com.qht.biz.PkgLevelBiz;
import com.qht.biz.TeacherBiz;
import com.qht.common.util.BeanUtil;
import com.qht.entity.Teacher;
import com.qht.mapper.CoursePkgMapper;

import com.qht.model.AppInsertChapterParam;
import com.qht.model.CourseChapterModel;
import com.qht.model.IndexAddLcourseParam;
import com.qht.model.IndexAddZcourseParam;
import com.qht.model.IndexCourseAnswerModel;
import com.qht.model.IndexCourseAnswerParam;
import com.qht.model.IndexMessageModel;
import com.qht.model.IndexMessageParam;
import com.qht.model.IndexMyCourseDetailsModel;
import com.qht.model.IndexMyCourseListModel;
import com.qht.model.IndexMyCourseListParam;
import com.qht.model.IndexMyCourseModel;
import com.qht.model.IndexMyCourseParam;
import com.qht.model.InsertCoursePkgParam;
import com.qht.model.UidAndTenantIDParam;

import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;

@Controller
@RequestMapping("teacher")
public class TeacherController extends APIBaseController<TeacherBiz,Teacher> implements TeacherService {
    @Autowired
    private TeacherBiz teacherBiz;
    @Autowired
    private CoursePkgBiz coursePkgBiz;
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
    @PostMapping("indexAddLcourse")
    @ResponseBody

    public ResultObject<Void> indexAddLcourse(@RequestBody RequestObject<IndexAddLcourseParameter> requestObject) {
        ResultObject<Void> resultObject=new ResultObject<>();
        //插入数据需要生成uid
        String uid="course_pkg"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        requestObject.getData().setUid(uid);
        IndexAddLcourseParam param=new IndexAddLcourseParam();
        BeanUtil.copyFields(param, requestObject.getData());
        Integer indexAddcourseLine=teacherBiz.insertIndexAddLcourse(param);
        if(indexAddcourseLine!=1){
            resultObject.setCode("1");
            resultObject.setMsg("课程包创建失败");
            return resultObject;
        }
        if(requestObject.getData().getPeriod_name()!=null){
            String chapter_uid="chapter"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            requestObject.getData().setChapter_uid(chapter_uid);
            Integer insertChapterLine=teacherBiz.insertChapter(param);
            if(insertChapterLine!=1){
                resultObject.setCode("1");
                resultObject.setMsg("章节创建失败");
                return resultObject;
            }
        }
        if (requestObject.getData().getPeriod_name()!=null){
            String period_uid="period"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            requestObject.getData().setPeriod_uid(period_uid);
            Integer insertPeriodLine=teacherBiz.insertPeriod(param);
            if(insertPeriodLine!=1){
                resultObject.setCode("1");
                resultObject.setMsg("课时创建失败");
                return resultObject;
            }
        }
        resultObject.setCode("1");
        resultObject.setMsg("创建成功审核中");
        return resultObject;
    }

	@Override
	@PostMapping("indexAddZcourse")
    @ResponseBody

	public ResultObject<Void> indexAddZcourse(@RequestBody RequestObject<IndexAddZcourseParameter> requestObject) {
		ResultObject<Void> resultObject=new ResultObject<>();
		String uid="course_pkg"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        requestObject.getData().setUid(uid);
        IndexAddZcourseParam param=new IndexAddZcourseParam();
        BeanUtil.copyFields(param, requestObject.getData());
        Integer indexAddcourseLine=teacherBiz.insertIndexAddZcourse(param);
        String chapter_uid="course_pkg"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        requestObject.getData().setChapter_uid(chapter_uid);
        Integer indexChapterLine=teacherBiz.insertChapterZ(param);
        String period_uid="course_pkg"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        requestObject.getData().setChapter_uid(period_uid);
        Integer indexPeriodLine=teacherBiz.insertPeriodZ(param);
        if((indexAddcourseLine+indexChapterLine+indexPeriodLine)==3) {
        	resultObject.setMsg("创建成功");
        	resultObject.setCode("0");
        	return resultObject;
        }
        resultObject.setMsg("创建失败");
    	resultObject.setCode("1");
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
	/**
	 * app添加课程包
	 */
	@Override
	@PostMapping("/app/appIndexAddLCourse")
    @ResponseBody
	public ResultObject<Void> appIndexAddLCourse(@RequestBody RequestObject<InsertCoursePkgParameter> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<Void> robj=new ResultObject<>();
			robj.setMsg("没有参数");
			robj.setCode("1");
		}
		
		InsertCoursePkgParam param=new InsertCoursePkgParam();
		String easy = pkgLevelBiz.selectValue(param.getPkg_level_id());
		BeanUtil.copyFields(param, requestObject.getData());
		param.setEasy(Integer.parseInt(easy));
		param.setStatus("1");
		param.setCreat_time(new Date());
		Integer result = coursePkgBiz.indexAddLCourse(param);
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
	 * app添加章节
	 */
	@Override
	@PostMapping("app/indexAddLCourse")
    @ResponseBody
	public ResultObject<Void> appInsertChapter(@RequestBody RequestObject<AppInsertChapterParameter> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<Void> robj=new ResultObject<>();
			robj.setMsg("没有参数");
			robj.setCode("1");
		}
		AppInsertChapterParam param=new AppInsertChapterParam();
		BeanUtil.copyFields(param, requestObject.getData());
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
		PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(param.getLimit()));
		BeanUtil.copyFields(param, requestObject.getData());
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
	 * app修改课程包
	 */
	@Override
	@PostMapping("app/indexEditLCourse")
    @ResponseBody
	public ResultObject<Void> appUpdateCoursePkgByid(@RequestBody RequestObject<InsertCoursePkgParameter> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<Void> robj=new ResultObject<>();
			robj.setMsg("没有参数");
			robj.setCode("1");
		}
		InsertCoursePkgParam param=new InsertCoursePkgParam();
		String easy = pkgLevelBiz.selectValue(param.getPkg_level_id());
		BeanUtil.copyFields(param, requestObject.getData());
		param.setEasy(Integer.parseInt(easy));
		param.setStatus("1");
		param.setCreat_time(new Date());
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

}