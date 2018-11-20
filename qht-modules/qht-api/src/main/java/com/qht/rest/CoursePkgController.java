package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.CoursePkgBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.*;
import com.qht.entity.CoursePkg;

import com.qht.model.*;
import com.qht.services.CoursePkgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoursePkgController extends APIBaseController<CoursePkgBiz,CoursePkg> implements CoursePkgService {
	@Autowired
	private CoursePkgBiz coursePkgBiz;

	@Override
	@PostMapping("/student/liveClass")
	@ResponseBody
	public ResultObject<List<LiveClassDto>> liveClass(@RequestBody RequestObject<Void> requestObject) {
		//查询首页直播课程
		List<LiveClassModel> list=coursePkgBiz.selectLiveClass(getTenantId());
		List<LiveClassDto> lists = BeanUtil.copyList(LiveClassDto.class, list);
		ResultObject<List<LiveClassDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(lists);
		return resultObject;
	}

	@Override
	@PostMapping("/student/freeClass")
	@ResponseBody
	public ResultObject<List<FreeClassDto>> freeClass(@RequestBody RequestObject<FreeClassParameter> requestObject) {
		//requestObject.getData().setTenant_id(getTenantId());
		//TODO
		FreeClassParam fcp = new FreeClassParam();
		BeanUtil.copyFields(fcp, requestObject.getData());
		//查询免费课程
		List<FreeClassModel> list= coursePkgBiz.selectFreeClass(fcp);
		List<FreeClassDto> lists = BeanUtil.copyList(FreeClassDto.class, list);
		ResultObject<List<FreeClassDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(lists);
		return resultObject;
	}

	@Override
	@PostMapping("/student/listeningClassList")
	@ResponseBody
	public ResultObject<List<ListeningClassListDto>> listeningClassList(@RequestBody RequestObject<Void> requestObject) {
		//查询

		List<ListeningClassListModel> list=coursePkgBiz.selectListeningClassList(getTenantId());
		List<ListeningClassListDto> lists = BeanUtil.copyList(ListeningClassListDto.class, list);
		ResultObject<List<ListeningClassListDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(lists);
		return resultObject;
	}

	@Override
	@PostMapping("/student/listeningClassRanking")
	@ResponseBody
	public ResultObject<List<ListeningClassRankingDto>> listeningClassRanking(@RequestBody RequestObject<Void> requestObject) {
		//查询试听排行榜
		List<ListeningClassRankingModel> list=coursePkgBiz.selectListeningClassRanking(getTenantId());
		List<ListeningClassRankingDto> lists = BeanUtil.copyList(ListeningClassRankingDto.class, list);
		ResultObject<List<ListeningClassRankingDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(lists);
		return resultObject;
	}

	@Override
	@PostMapping("/student/courseIntro")
	@ResponseBody
	public ResultObject<CourseIntroDto> courseIntro(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
		//通过课程包的uid和运营的id查询
		CourseIntroParam param=new CourseIntroParam();
		BeanUtil.copyFields(param,  requestObject.getData());
		CourseIntroModel courseIntroModel=coursePkgBiz.selectCourseIntro(param.getUid(),param.getTenant_id());
		CourseIntroDto dto=new CourseIntroDto();
		BeanUtil.copyFields(dto,courseIntroModel);
		ResultObject<CourseIntroDto> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(dto);
		return resultObject;
	}

	@Override
	@PostMapping("/student/courseList")
	@ResponseBody
	public ResultObject<List<CourseListDto>> courseList(@RequestBody RequestObject<CourseListParameter> requestObject) {
		//使用分页插件
		CourseListParam param=new CourseListParam();
		BeanUtil.copyFields(param, requestObject.getData());
		if(StringUtil.isEmpty(param.getPage())){
			param.setPage("1");
		}
		if(StringUtil.isEmpty(param.getLimit())){
			param.setLimit("10");
		}
		PageHelper.startPage(Integer.parseInt(param.getPage()), Integer.parseInt(param.getLimit()));
		requestObject.getData().setTenant_id(getTenantId());
		List<CourseListModel> courseListDtos=coursePkgBiz.selectCourseList(param);
		List<CourseListDto> list = BeanUtil.copyList(CourseListDto.class, courseListDtos);
		//得到总条数
		PageInfo<CourseListDto> count=new PageInfo<>(list);
		ResultObject<List<CourseListDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setCount(count.getTotal());
		resultObject.setData(list);
		return resultObject;
	}

	@Override
	@PostMapping("/student/teacherCourse")
	@ResponseBody
	public ResultObject<List<TeacherCourseDto>> teacherCourse(@RequestBody RequestObject<UidAndTenantID> request) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, request.getData());
		List<TeacherCourseModel> teacherCourseDtos=coursePkgBiz.selectTeacherCourse(param.getUid(),param.getTenant_id());
		List<TeacherCourseDto> list = BeanUtil.copyList(TeacherCourseDto.class, teacherCourseDtos);
		ResultObject<List<TeacherCourseDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(list);
		resultObject.setCount((long) list.size());
		return resultObject;
	}

	/**
	 * 近期课程
	 * @return
	 */
	@Override
	@PostMapping("/student/app/indexFutureCoruse")
	@ResponseBody
	public ResultObject<List<IndexFutureCoruseDto>> indexFutureCoruse(@RequestBody RequestObject<UidAndTenantID> req) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		if(req.getData()==null) {
			ResultObject<List<IndexFutureCoruseDto>> resultObject=new ResultObject<>();
			resultObject.setCode("1");
			resultObject.setMsg("没有接收到参数");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		BeanUtil.copyFields(param, req.getData());
		List<IndexFutureCoruseModel> dto=coursePkgBiz.indexFutureCoruse(param.getUid(),param.getTenant_id());
		if(dto.size()==0) {
			ResultObject<List<IndexFutureCoruseDto>> resultObject=new ResultObject<>();
			resultObject.setCode("0");
			resultObject.setMsg("成功");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<IndexFutureCoruseDto> list = BeanUtil.copyList(IndexFutureCoruseDto.class, dto);
		ResultObject<List<IndexFutureCoruseDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(list);
		return resultObject;
	}

	@Override
	@PostMapping("/student/app/indexAnswer")
	@ResponseBody
	public ResultObject<List<IndexAnswerDto>> indexAnswer(@RequestBody RequestObject<Void> req) {

		List<IndexAnswerModel> dto=coursePkgBiz.indexAnswer(getTenantId());
		if(dto.size()==0) {
			ResultObject<List<IndexAnswerDto>> resultObject=new ResultObject<>();
			resultObject.setCode("0");
			resultObject.setMsg("没有数据哦");
			resultObject.setData(new ArrayList<>());
			return  resultObject;
		}
		List<IndexAnswerDto> list = BeanUtil.copyList(IndexAnswerDto.class, dto);
		ResultObject<List<IndexAnswerDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(list);
		return  resultObject;
	}

	@Override
	@PostMapping("/student/app/indexCoruseList")
	@ResponseBody
	public ResultObject<List<IndexCoruseListDto>> indexCoruseList(@RequestBody RequestObject<IndexCoruseListParameter> parameter) {        System.out.println("-------------"+parameter);

		IndexCoruseListParam param=new IndexCoruseListParam();
		if(parameter.getData()==null) {
			ResultObject<List<IndexCoruseListDto>> resultObject=new ResultObject<>();
			resultObject.setCode("1");
			resultObject.setMsg("没有接收到参数");
			resultObject.setData(new ArrayList<>());
			return  resultObject;
		}
		BeanUtil.copyFields(param, parameter.getData());
		List<IndexCoruseListModel> dto=coursePkgBiz.indexCoruseList(param);
		if(dto.size()==0) {
			ResultObject<List<IndexCoruseListDto>> resultObject=new ResultObject<>();
			resultObject.setCode("0");
			resultObject.setMsg("没有数据哦");
			resultObject.setData(new ArrayList<>());
			return  resultObject;
		}
		List<IndexCoruseListDto> list = BeanUtil.copyList(IndexCoruseListDto.class, dto);
		ResultObject<List<IndexCoruseListDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(list);
		return  resultObject;
	}

	@Override
	@PostMapping("/student/myIndexBuyrecordCourseDetails")
	@ResponseBody
	public ResultObject<List<MyIndexBuyRecordCourseDetailsDto>> myIndexBuyRecordCourseDetails(@RequestBody RequestObject<UidAndTenantID> req) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, req.getData());
		List<MyIndexBuyRecordCourseDetailsModel> myIndexBuyRecordCourseDetailsDtos=coursePkgBiz.selectMyIndexBuyRecordDetails(param.getUid());
		List<MyIndexBuyRecordCourseDetailsDto> list = BeanUtil.copyList(MyIndexBuyRecordCourseDetailsDto.class, myIndexBuyRecordCourseDetailsDtos);
		ResultObject<List<MyIndexBuyRecordCourseDetailsDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(list);
		return resultObject;
	}

	@Override
	@PostMapping("/student/myIndexMycollect")
	@ResponseBody
	public ResultObject<List<MyIndexMycollectDto>> myIndexMycollect(@RequestBody RequestObject<MyIndexMycollectParameter> requestObject) {
		MyIndexMycollectParam param=new MyIndexMycollectParam();
		BeanUtil.copyFields(param, requestObject.getData());
		requestObject.getData().setTenant_id(getTenantId());
		PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()) );
		List<MyIndexMycollectModel> myIndexMycollectDtos=coursePkgBiz.selectMyIndexMycollect(param);
		List<MyIndexMycollectDto> list = BeanUtil.copyList(MyIndexMycollectDto.class, myIndexMycollectDtos);
		PageInfo<MyIndexMycollectDto> count=new PageInfo<>(list);
		ResultObject<List<MyIndexMycollectDto>> resultObject=new ResultObject<>();
		resultObject.setCount(count.getTotal());
		resultObject.setCode("0");
		resultObject.setData(list);
		resultObject.setMsg("成功");

		return resultObject;
	}

}