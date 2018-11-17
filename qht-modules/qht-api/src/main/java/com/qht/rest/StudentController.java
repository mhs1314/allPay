
package com.qht.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qht.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.auth.util.RequestContextUtil;
import com.qht.biz.CollectBiz;
import com.qht.biz.PeriodBiz;
import com.qht.biz.StudentBiz;
import com.qht.biz.TeacherBiz;
import com.qht.common.util.BeanUtil;
import com.qht.entity.Student;
import com.qht.model.*;
import com.qht.services.StudentService;

@Controller
@RequestMapping("student")
public class StudentController extends APIBaseController<StudentBiz,Student> implements StudentService {


    @Autowired
    private StudentBiz studentBiz;
    @Autowired
    private TeacherBiz teacherBiz;
    @Autowired
    private CollectBiz collectBiz;
    
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private PeriodBiz periodBiz;


    @Override
    @PostMapping("login")
    @ResponseBody
    public ResultObject<StudentDto> login(@RequestBody RequestObject<LoginInfoDto> requestObject) {
        //获取到密码
        String account=requestObject.getData().getAccount();
        //获取到密码
        String password=requestObject.getData().getPassword();
        ResultObject<StudentDto> resultObject=new ResultObject<>();
        //查询
        if(account==null&&account==""){
            resultObject.setCode("0");
            resultObject.setMsg("请输入账号");
            return resultObject;
        }
        if(password==null&&password==""){
            resultObject.setCode("0");
            resultObject.setMsg("请输入密码");
            return resultObject;
        }
        //通过密码账号查询
        StudentDto studentDto=studentBiz.studentLogin(account,password);

        if(studentDto!=null){

            resultObject.setCode("0");
            resultObject.setMsg("登陆成功");
            resultObject.setData(studentDto);
            //将信息传入session
            HttpServletRequest req= getRequest();            
            req.getSession().setAttribute("studentDto",studentDto);
            return resultObject;
        }
        resultObject.setCode("0");
        resultObject.setMsg("账号或者密码错误");
        return resultObject;
    }

    @Override
    @PostMapping("banner")
    @ResponseBody
    public ResultObject<List<BannerDto>> banner(@RequestBody RequestObject<Void> requestObject) {
        //通过session取到运营的id
        System.out.println(getTenantId());
        List<BannerModel> list=studentBiz.selectBanner(getTenantId(),"1");
        List<BannerDto> lists = BeanUtil.copyList(BannerDto.class, list);
        ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
        resultObject.setData(lists);
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        return resultObject;
    }
    @Override
    @PostMapping("/app/indexBanner")
    @ResponseBody
    public ResultObject<List<BannerDto>> indexBanner(@RequestBody RequestObject<UidAndTenantID> requestObject) {
        //通过session取到运营的id
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	if(requestObject.getData()==null) {
            ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
            resultObject.setData(new ArrayList<>());
            resultObject.setCode("1");
            resultObject.setMsg("没有参数哦");
            return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
        List<BannerModel> list=studentBiz.selectBanner(param.getTenant_id(),"2");
        if(list.size()==0) {
        	ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
            resultObject.setData(new ArrayList<>());
            resultObject.setCode("0");
            resultObject.setMsg("没有数据");
            return resultObject;
        }
       List<BannerDto> lists = BeanUtil.copyList(BannerDto.class, list);
        ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
        resultObject.setData(lists);
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        return resultObject;
    }
    @Override
    @PostMapping("liveClass")
    @ResponseBody
    public ResultObject<List<LiveClassDto>> liveClass(@RequestBody RequestObject<Void> requestObject) {
        //查询首页直播课程
        List<LiveClassModel> list=studentBiz.selectLiveClass(getTenantId());
        List<LiveClassDto> lists = BeanUtil.copyList(LiveClassDto.class, list);
        ResultObject<List<LiveClassDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(lists);
        return resultObject;
    }

    @Override
    @PostMapping("freeClass")
    @ResponseBody
    public ResultObject<List<FreeClassDto>> freeClass(@RequestBody RequestObject<FreeClassParameter> requestObject) {
        //requestObject.getData().setTenant_id(getTenantId());
    	//TODO
        FreeClassParam fcp = new FreeClassParam();
        BeanUtil.copyFields(fcp, requestObject.getData());
        //查询免费课程
        List<FreeClassModel> list= studentBiz.selectFreeClass(fcp);
        List<FreeClassDto> lists = BeanUtil.copyList(FreeClassDto.class, list);
        ResultObject<List<FreeClassDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(lists);
        return resultObject;
    }

    @Override
    @PostMapping("listeningClassRanking")
    @ResponseBody
    public ResultObject<List<ListeningClassRankingDto>> listeningClassRanking(@RequestBody RequestObject<Void> requestObject) {
        //查询试听排行榜
        List<ListeningClassRankingModel> list=studentBiz.selectListeningClassRanking(getTenantId());
        List<ListeningClassRankingDto> lists = BeanUtil.copyList(ListeningClassRankingDto.class, list);
        ResultObject<List<ListeningClassRankingDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(lists);
        return resultObject;
    }

    @Override
    @PostMapping("listeningClassList")
    @ResponseBody
    public ResultObject<List<ListeningClassListDto>> listeningClassList(@RequestBody RequestObject<Void> requestObject) {
        //查询
    	
        List<ListeningClassListModel> list=studentBiz.selectListeningClassList(getTenantId());
        List<ListeningClassListDto> lists = BeanUtil.copyList(ListeningClassListDto.class, list);
        ResultObject<List<ListeningClassListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(lists);
        return resultObject;
    }

    @Override
    @PostMapping("teacherRanking")
    @ResponseBody
    public ResultObject<List<TeacherRankingDto>> teacherRanking(@RequestBody RequestObject<Void> requestObject) {
        //查询
        List<TeacherRankingModel> list=studentBiz.selectTeacherRanking(getTenantId());
        List<TeacherRankingDto> lists = BeanUtil.copyList(TeacherRankingDto.class, list);
        ResultObject<List<TeacherRankingDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(lists);
        return resultObject;
    }

    @Override
    @PostMapping("indexTeacherList")
    @ResponseBody
    public ResultObject<List<TeacherListDto>> teacherList(@RequestBody RequestObject<TeacherListParameter> requestObject) {
    	TeacherListParam param=new TeacherListParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        requestObject.getData().setTenant_id(this.getTenantId());
        //查询
        List<TeacherListModel> list=studentBiz.selectTeacherList(param);
       List<TeacherListDto> lists = BeanUtil.copyList(TeacherListDto.class, list);
        ResultObject<List<TeacherListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(lists);
        return resultObject;
    }

    @Override
    @PostMapping("courseIntro")
    @ResponseBody
    public ResultObject<CourseIntroDto> courseIntro(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
        //通过课程包的uid和运营的id查询
    	CourseIntroParam param=new CourseIntroParam();
    	BeanUtil.copyFields(param,  requestObject.getData());
        CourseIntroModel courseIntroModel=studentBiz.selectCourseIntro(param.getUid(),param.getTenant_id());
        CourseIntroDto dto=new CourseIntroDto();
        BeanUtil.copyFields(dto,courseIntroModel);
        ResultObject<CourseIntroDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("courseChapter")
    @ResponseBody
    public ResultObject<List<CourseChapterDto>> courseChapter(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
    	CourseIntroParam param=new CourseIntroParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        List<CourseChapterModel> courseChapterDtos=studentBiz.selectCourseChapter(param.getUid(),param.getTenant_id());
        List<CourseChapterDto> list = BeanUtil.copyList(CourseChapterDto.class, courseChapterDtos);
        BeanUtil.copyList(CourseChapterDto.class, courseChapterDtos);
        ResultObject<List<CourseChapterDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("courseEvaluation")
    @ResponseBody
    public ResultObject<List<CourseEvaluationDto>> courseEvaluation(@RequestBody RequestObject<CourseEvaluationParameter> requestObject) {
        ResultObject<List<CourseEvaluationDto>> resultObject=new ResultObject<>();
        CourseEvaluationParam param=new CourseEvaluationParam();
        if(requestObject.getData().getEval()==null&&requestObject.getData().getEval()==""){
        	
        	BeanUtil.copyFields(param, requestObject.getData());
            PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(param.getLimit()));
            List<CourseEvaluationModel> courseEvaluationDtos=studentBiz.selectCourseEvaluation(param);
            List<CourseEvaluationDto> list = BeanUtil.copyList(CourseEvaluationDto.class, courseEvaluationDtos);
            PageInfo<CourseEvaluationDto> count=new PageInfo<>(list);
            List<CourseEvaluationModel> courseEvaluationDtosGood=studentBiz.selectCourseEvaluationGood(param);
            List<CourseEvaluationModel> courseEvaluationDtosMid=studentBiz.selectCourseEvaluationMid(param);
            List<CourseEvaluationModel> courseEvaluationDtosBad=studentBiz.selectCourseEvaluationBad(param);
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            resultObject.setCount(count.getTotal());
            resultObject.setCount_good(courseEvaluationDtosGood.size());
            resultObject.setCount_mid(courseEvaluationDtosMid.size());
            resultObject.setCount_mid(courseEvaluationDtosBad.size());
            resultObject.setData(list);
            return resultObject;
        }
        if(requestObject.getData().getEval().equals("3")){
            PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(param.getLimit()));
            List<CourseEvaluationModel> courseEvaluationDtosGood=studentBiz.selectCourseEvaluationGood(param);
            List<CourseEvaluationDto> list = BeanUtil.copyList(CourseEvaluationDto.class, courseEvaluationDtosGood);
            PageInfo<CourseEvaluationDto> count=new PageInfo<>(list);
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            resultObject.setCount(count.getTotal());
            resultObject.setData(list);
            return resultObject;
        }
        if(requestObject.getData().getEval().equals("2")){
            PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(param.getLimit()));
            List<CourseEvaluationModel> courseEvaluationDtosMid=studentBiz.selectCourseEvaluationMid(param);
            List<CourseEvaluationDto> list = BeanUtil.copyList(CourseEvaluationDto.class, courseEvaluationDtosMid);
            PageInfo<CourseEvaluationDto> count=new PageInfo<>(list);
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            resultObject.setCount(count.getTotal());
            resultObject.setData(list);
            return resultObject;
        }
        if(requestObject.getData().getEval().equals("1")){
            PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(param.getLimit()));
            List<CourseEvaluationModel> courseEvaluationDtosBad=studentBiz.selectCourseEvaluationMid(param);
           List<CourseEvaluationDto> list = BeanUtil.copyList(CourseEvaluationDto.class, courseEvaluationDtosBad);
            PageInfo<CourseEvaluationDto> count=new PageInfo<>(list);
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            resultObject.setCount(count.getTotal());
            resultObject.setData(list);
            return resultObject;
        }
        resultObject.setCode("1");
        resultObject.setMsg("失败");
        return resultObject;
    }

    @Override
    @PostMapping("teacherInfo")
    @ResponseBody
    public ResultObject<TeacherInfoDto> teacherInfo(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
    	CourseIntroParam param=new CourseIntroParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        TeacherInfoModel teacherInfoModel=studentBiz.selectTeacherInfo(param.getUid(),param.getTenant_id());
        TeacherInfoDto dto=new TeacherInfoDto();
        BeanUtil.copyFields(dto, teacherInfoModel);
        ResultObject<TeacherInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }



    @Override
    @PostMapping("courseList")
    @ResponseBody
    public ResultObject<List<CourseListDto>> courseList(@RequestBody RequestObject<CourseListParameter> requestObject) {
        //使用分页插件
    	CourseListParam param=new CourseListParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        PageHelper.startPage(Integer.parseInt(param.getPage()), Integer.parseInt(param.getLimit()));
        requestObject.getData().setTenant_id(getTenantId());
        List<CourseListModel> courseListDtos=studentBiz.selectCourseList(param);
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
    @PostMapping("teacherList")
    @ResponseBody
    public ResultObject<List<TopTeacherListDto>> topTeacherList(@RequestBody RequestObject<TopTeacherListParameter> requestObject) {
    	TopTeacherListParam param=new TopTeacherListParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(param.getPage()), Integer.parseInt(param.getLimit()));
        requestObject.getData().setTenant_id(getTenantId());
        List<TopTeacherListModel> topTeacherListDtos=studentBiz.selectTopTeacherList(param);
       List<TopTeacherListDto> list = BeanUtil.copyList(TopTeacherListDto.class, topTeacherListDtos);
        //得到总条数
        PageInfo<TopTeacherListDto> count=new PageInfo<>(list);
        ResultObject<List<TopTeacherListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("courseTeacherInfo")
    @ResponseBody

    public ResultObject<TopTeacherInfoDto> topTeacherInfo(@RequestBody RequestObject<UidAndTenantID> request) {
    	ResultObject<TopTeacherInfoDto> resultObject=new ResultObject<>();
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	BeanUtil.copyFields(param, request.getData());
        TopTeacherInfoModel topTeacherInfoDtos= studentBiz.selectTopTeacherInfo(param.getUid(),param.getTenant_id());
        TopTeacherInfoDto dto =new TopTeacherInfoDto();
        if(topTeacherInfoDtos==null) {
        	resultObject.setCode("1");
        	resultObject.setMsg("没有数据");
        	return resultObject;
        }
        
        BeanUtil.copyFields(dto, topTeacherInfoDtos);
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("teacherCourse")
    @ResponseBody


    public ResultObject<List<TeacherCourseDto>> teacherCourse(@RequestBody RequestObject<UidAndTenantID> request) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	BeanUtil.copyFields(param, request.getData());
        List<TeacherCourseModel> teacherCourseDtos=studentBiz.selectTeacherCourse(param.getUid(),param.getTenant_id());
       List<TeacherCourseDto> list = BeanUtil.copyList(TeacherCourseDto.class, teacherCourseDtos);
        ResultObject<List<TeacherCourseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        resultObject.setCount((long) list.size());
        return resultObject;
    }

    @Override
    @PostMapping("teacherEvaluation")
    @ResponseBody


    public ResultObject<List<TeacherEvaluationDto>> teacherEvaluation(@RequestBody RequestObject<UidAndTenantID> request) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	BeanUtil.copyFields(param, request.getData());
        List<TeacherEvaluationModel> teacherEvaluationDtos=studentBiz.selectTeacherEvaluation(param.getUid(),param.getTenant_id());
        List<TeacherEvaluationDto> list = BeanUtil.copyList(TeacherEvaluationDto.class, teacherEvaluationDtos);
        ResultObject<List<TeacherEvaluationDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("tenantSchool")
    @ResponseBody
    public ResultObject<TenantSchoolDto> tenantSchool(@RequestBody RequestObject<UidAndTenantID> requestObject) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        TenantSchoolModel tenantSchoolDto=studentBiz.selectTenantSchool(param);
        TenantSchoolDto dto=new TenantSchoolDto();
        BeanUtil.copyFields(dto, tenantSchoolDto);
        ResultObject<TenantSchoolDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("tenantAlbum")
    @ResponseBody
    public ResultObject<List<TenantAlbumDto>> tenantAlbum(@RequestBody RequestObject<Void> requestObject) {
    	
        List<TenantAlbumModel> tenantAlbumDto=studentBiz.selectTenantAlbum(getTenantId());
        List<TenantAlbumDto> list = BeanUtil.copyList(TenantAlbumDto.class, tenantAlbumDto);
        ResultObject<List<TenantAlbumDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexCourse")
    @ResponseBody
    public ResultObject<List<MyIndexCourseDto>> myIndexCourse(@RequestBody RequestObject<MyIndexCourseParameter> requestObject) {
        //使用分页插件
    	MyIndexCourseParam param=new MyIndexCourseParam();
        PageHelper.startPage(Integer.parseInt(param.getPage()), Integer.parseInt(param.getLimit()));
        requestObject.getData().setTenant_id(getTenantId());
        List<MyIndexCourseModel> myIndexCourseDtos=studentBiz.selectMyIndexCourse(param);
       List<MyIndexCourseDto> list = BeanUtil.copyList(MyIndexCourseDto.class, myIndexCourseDtos);
        PageInfo<MyIndexCourseDto> count=new PageInfo<>(list);
        ResultObject<List<MyIndexCourseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("indexCourseDetails")
    @ResponseBody


    public ResultObject<List<IndexCourseDetailsDto>> indexCourseDetails(@RequestBody RequestObject<UidAndTenantID> req) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	BeanUtil.copyFields(param, req.getData());
        List<IndexCourseDetailsModel> indexCourseDetailsDtos=studentBiz.selectIndexCourseDetails(param.getUid(),param.getTenant_id());
        List<IndexCourseDetailsDto> list = BeanUtil.copyList(IndexCourseDetailsDto.class, indexCourseDetailsDtos);
        ResultObject<List<IndexCourseDetailsDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }
    @Override
    @PostMapping("myIndexMessage")
    @ResponseBody
    public ResultObject<List<MyIndexMessageDto>> myIndexMessage(@RequestBody RequestObject<MyIndexMessageParamter> paramter) {
    	MyIndexMessageParam param=new MyIndexMessageParam();
        Integer p=Integer.parseInt(param.getPage());
        Integer l=Integer.parseInt(param.getLimit());
        paramter.getData().setIsread(getTenantId());
        PageHelper.startPage(p,l);
        List<MyIndexMessageModel> list=studentBiz.selectMyIndexMessage(param);
        List<MyIndexMessageDto> lists = BeanUtil.copyList(MyIndexMessageDto.class, list);
        PageInfo<MyIndexMessageDto> count=new PageInfo<>(lists);
        ResultObject<List<MyIndexMessageDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(lists);
        return resultObject;

    }

    @Override
    @PostMapping("myIndexDelMessage")
    @ResponseBody

    public ResultObject<Void> deleteMessage(@RequestBody RequestObject<UidAndTenantID> requestObject) {
        ResultObject<Void> resultObject=new ResultObject<>();

        Integer deleteLine=studentBiz.deleteMessage(requestObject.getData().getUid());
        if(deleteLine>0){
            resultObject.setMsg("删除成功");

            resultObject.setCode("0");
            return resultObject;
        }else{
            resultObject.setMsg("删除失败");
            resultObject.setCode("2");
            return resultObject;
        }
    }

    @Override
    @PostMapping("myIndexMessageDetails")
    @ResponseBody


    public ResultObject<MyIndexMessageDto> selectMessageById(@RequestBody RequestObject<UidAndTenantID> requestObject) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        MyIndexMessageModel dto=studentBiz.selectMessageById(param.getUid());
        MyIndexMessageDto dtod=new MyIndexMessageDto();
        BeanUtil.copyFields(dtod, dto);
        ResultObject<MyIndexMessageDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dtod);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexBuyrecord")
    @ResponseBody
    public ResultObject<List<MyIndexBuyRecordDto>> myIndexBuyRecord(@RequestBody RequestObject<MyIndexBuyRecordParameter> requestObject) {
        //使用分页插件
    	MyIndexBuyRecordParam param=new MyIndexBuyRecordParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(param.getLimit()) );
        requestObject.getData().setTenant_id(getTenantId());
        List<MyIndexBuyRecordModel> myIndexBuyRecordDtos=studentBiz.selectMyIndexBuyRecourd(param);
        List<MyIndexBuyRecordDto> list = BeanUtil.copyList(MyIndexBuyRecordDto.class, myIndexBuyRecordDtos);
        PageInfo<MyIndexBuyRecordDto> count=new PageInfo<>(list);
        ResultObject<List<MyIndexBuyRecordDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("studentInfo")
    @ResponseBody
    public ResultObject<StudentInfoDto> studentInfo(@RequestBody RequestObject<UidAndTenantID> requestObject) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	if(requestObject.getData()==null) {
    		  ResultObject<StudentInfoDto> resultObject=new ResultObject<>();
    	        resultObject.setCode("1");
    	        resultObject.setMsg("没接收到参数");
    	        resultObject.setData(new StudentInfoDto());
    	        return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
        StudentInfoModel model=studentBiz.studentInfo(param.getUid(),param.getTenant_id());
        if(model==null) {
        	ResultObject<StudentInfoDto> resultObject=new ResultObject<>();
	        resultObject.setCode("0");
	        resultObject.setMsg("成功");
	        resultObject.setData(new StudentInfoDto());
	        return resultObject;
        }
        StudentInfoDto dto=new StudentInfoDto();
        BeanUtil.copyFields(dto, model);
        ResultObject<StudentInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }
    //消費記錄
    @Override
    @PostMapping("/myIndexMyintegralDetail")
    @ResponseBody
    public ResultObject<List<MyIndexMyintegralDetailDto>> myIndexMyintegralDetail(@RequestBody RequestObject<MyIndexMyintegralDetailParameter> parameter) {
    	MyIndexMyintegralDetailParam param=new MyIndexMyintegralDetailParam();
    	BeanUtil.copyFields(param, parameter.getData());
    	parameter.getData().setTenant_id(getTenantId());
        Integer p=Integer.parseInt(param.getPage());
        Integer l=Integer.parseInt(param.getLimit());
        PageHelper.startPage(p,l);
        List<MyIndexMyintegralDetailModel> list=studentBiz.myIndexMyintegralDetail(param);
       List<MyIndexMyintegralDetailDto> lists = BeanUtil.copyList(MyIndexMyintegralDetailDto.class, list);
        PageInfo<MyIndexMyintegralDetailDto> count=new PageInfo<>(lists);
        ResultObject<List<MyIndexMyintegralDetailDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(lists);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexCourseAnswer")
    @ResponseBody
    public ResultObject<List<MyIndexCourseAnswerDto>> myIndexCourseAnswer(@RequestBody RequestObject<MyIndexCourseAnswerParameter> requestObject) {
        //使用分页插件
    	MyIndexCourseAnswerParam param=new MyIndexCourseAnswerParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()) );
        requestObject.getData().setTenant_id(getTenantId());
        List<MyIndexCourseAnswerModel> myIndexCourseAnswerDtos=studentBiz.selectMyIndexCourseAnswer(param);
       List<MyIndexCourseAnswerDto> list = BeanUtil.copyList(MyIndexCourseAnswerDto.class, myIndexCourseAnswerDtos);
        PageInfo<MyIndexCourseAnswerDto> count=new PageInfo<>(list);
        ResultObject<List<MyIndexCourseAnswerDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(list);
        return resultObject;
    }

    /**
     * 近期课程
     * @return
     */
    @Override
    @PostMapping("/app/indexFutureCoruse")
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
        List<IndexFutureCoruseModel> dto=studentBiz.indexFutureCoruse(param.getUid(),param.getTenant_id());
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
    @PostMapping("/app/indexTeacher")
    @ResponseBody
    public ResultObject<List<IndexTeacherDto>> indexTeacher(@RequestBody RequestObject<Void> req) {
        List<IndexTeacherModel> dto=studentBiz.indexTeacher(getTenantId());
        if(dto.size()==0) {
        	 ResultObject<List<IndexTeacherDto>> resultObject=new ResultObject<>();
             resultObject.setCode("0");
             resultObject.setMsg("没有数据哦");
             resultObject.setData(new ArrayList<>());
            return  resultObject;
        }
       List<IndexTeacherDto> list = BeanUtil.copyList(IndexTeacherDto.class, dto);
        ResultObject<List<IndexTeacherDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
       return  resultObject;
    }

    @Override
    @PostMapping("/app/indexAnswer")
    @ResponseBody
    public ResultObject<List<IndexAnswerDto>> indexAnswer(@RequestBody RequestObject<Void> req) {
    	
        List<IndexAnswerModel> dto=studentBiz.indexAnswer(getTenantId());
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
    @PostMapping("/app/indexCoruseList")
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
        List<IndexCoruseListModel> dto=studentBiz.indexCoruseList(param);
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
    @PostMapping("/app/indexTeacherList")
    @ResponseBody
    public ResultObject<List<IndexTeacherListDto>> indexTeacherList(@RequestBody RequestObject<IndexTeacherListParameter> parameter) {
    	IndexTeacherListParam param=new IndexTeacherListParam();
    	if(parameter.getData()==null) {
    		ResultObject<List<IndexTeacherListDto>> resultObject=new ResultObject<>();
            resultObject.setCode("1");
            resultObject.setMsg("没有接收到参数哦");
            resultObject.setData(new ArrayList<>());
            return  resultObject;
    	}
    	BeanUtil.copyFields(param,parameter.getData());
        List<IndexTeacherListModel> dto=studentBiz.indexTeacherList(param);
        if(dto.size()==0) {
    		ResultObject<List<IndexTeacherListDto>> resultObject=new ResultObject<>();
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            resultObject.setData(new ArrayList<>());
            return  resultObject;
    	}
       List<IndexTeacherListDto> list = BeanUtil.copyList(IndexTeacherListDto.class, dto);
        ResultObject<List<IndexTeacherListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return  resultObject;
    }

    @Override
    @PostMapping("myIndexBuyrecordCourseDetails")
    @ResponseBody


    public ResultObject<List<MyIndexBuyRecordCourseDetailsDto>> myIndexBuyRecordCourseDetails(@RequestBody RequestObject<UidAndTenantID> req) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	BeanUtil.copyFields(param, req.getData());
        List<MyIndexBuyRecordCourseDetailsModel> myIndexBuyRecordCourseDetailsDtos=studentBiz.selectMyIndexBuyRecordDetails(param.getUid());
       List<MyIndexBuyRecordCourseDetailsDto> list = BeanUtil.copyList(MyIndexBuyRecordCourseDetailsDto.class, myIndexBuyRecordCourseDetailsDtos);
        ResultObject<List<MyIndexBuyRecordCourseDetailsDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexBuyrecordCourseBack")
    @ResponseBody
    public ResultObject<List<MyIndexBuyRecordCourseBackDto>> myIndexBuyRecordCourseBack(@RequestBody RequestObject<MyIndexBuyRecordCourseBackParameter> requestObject) {
        requestObject.getData().setTenant_id(getTenantId());
        MyIndexBuyRecordCourseBackParam param=new MyIndexBuyRecordCourseBackParam();
        BeanUtil.copyFields(param, requestObject.getData());
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
        List<MyIndexBuyRecordCourseBackModel> myIndexBuyRecordCourseBackDtos=studentBiz.selectMyIndexBuyRecordCourseBack(param);
        List<MyIndexBuyRecordCourseBackDto> list = BeanUtil.copyList(MyIndexBuyRecordCourseBackDto.class, myIndexBuyRecordCourseBackDtos);
        PageInfo<MyIndexBuyRecordCourseBackDto> count=new PageInfo<>(list);
        ResultObject<List<MyIndexBuyRecordCourseBackDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexMycollect")
    @ResponseBody
    public ResultObject<List<MyIndexMycollectDto>> myIndexMycollect(@RequestBody RequestObject<MyIndexMycollectParameter> requestObject) {
    	MyIndexMycollectParam param=new MyIndexMycollectParam();
    	BeanUtil.copyFields(param, requestObject.getData());
    	requestObject.getData().setTenant_id(getTenantId());
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()) );
        List<MyIndexMycollectModel> myIndexMycollectDtos=studentBiz.selectMyIndexMycollect(param);
       List<MyIndexMycollectDto> list = BeanUtil.copyList(MyIndexMycollectDto.class, myIndexMycollectDtos);
        PageInfo<MyIndexMycollectDto> count=new PageInfo<>(list);
        ResultObject<List<MyIndexMycollectDto>> resultObject=new ResultObject<>();
        resultObject.setCount(count.getTotal());
        resultObject.setCode("0");
        resultObject.setData(list);
        resultObject.setMsg("成功");
        return resultObject;
    }

    @Override
    @PostMapping("myIndexCancelcollect")
    @ResponseBody

    public ResultObject<Void> myIndexCancelcollect(@RequestBody RequestObject<MyIndexCanceCollectParameter> requestObject) {
    	MyIndexCanceCollectParam param=new MyIndexCanceCollectParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        ResultObject<Void> resultObject=new ResultObject<>();
        String uid =param.getUid();

        String student_id =param.getStudent_id();
        Integer updateLine=studentBiz.updateMyIndexCancelcollect(uid,student_id,getTenantId());
        resultObject.setCode("0");
        resultObject.setMsg("取消成功");
        return resultObject;
    }

    @Override
    @PostMapping("/app/indexMyAnswer")
    @ResponseBody


    public ResultObject<List<IndexMyAnswerDto>> indexMyAnswer(@RequestBody RequestObject<UidAndTenantID> requestObject) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	if(requestObject.getData()==null) {
    		 ResultObject<List<IndexMyAnswerDto>> resultObject=new ResultObject<>();
    	        resultObject.setCode("1");
    	        resultObject.setMsg("参数错误"); 
    	        resultObject.setData(new ArrayList<>());
    	        return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
        List<IndexMyAnswerModel> models=studentBiz.selectIndexMyAnswer(param.getUid(),param.getTenant_id());
        if(models.size()==0) {
        	 ResultObject<List<IndexMyAnswerDto>> resultObject=new ResultObject<>();
             resultObject.setCode("0");
             resultObject.setMsg("没有数据");
             resultObject.setData(new ArrayList<>());
             return resultObject;
        }
        List<IndexMyAnswerDto> list = BeanUtil.copyList(IndexMyAnswerDto.class, models);
        ResultObject<List<IndexMyAnswerDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }
    /**
     * 名师详情-基本信息
     * @return
     */
    @Override
    @PostMapping("/app/TeacherDetails")
    @ResponseBody


    public ResultObject<TeacherDetailsDto> teacherDetails(@RequestBody RequestObject<UidAndTenantID> requestObject) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	if( requestObject.getData()==null) {
    		ResultObject<TeacherDetailsDto> resultObject=new ResultObject<>();
            resultObject.setCode("1");
            resultObject.setMsg("参数不对");
            resultObject.setData(new TeacherDetailsDto());
            return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
        TeacherDetailsModel model=teacherBiz.teacherDetails(param.getUid(),param.getTenant_id());
        if(model==null) {
        	 ResultObject<TeacherDetailsDto> resultObject=new ResultObject<>();
             resultObject.setCode("0");
             resultObject.setMsg("成功");
             resultObject.setData(new TeacherDetailsDto());
             return resultObject;
        }
       
        TeacherDetailsDto dto=new TeacherDetailsDto();
        BeanUtil.copyFields(dto, model);
        ResultObject<TeacherDetailsDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("/app/indexAnswerDetails")
    @ResponseBody


    public ResultObject<IndexAnswerDetailsDto> indexAnswerDetails(@RequestBody RequestObject<UidAndTenantID> requestObject){
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	BeanUtil.copyFields(param, requestObject.getData());
        IndexAnswerDetailsModel model=studentBiz.selectIndexAnswerDetails(param.getUid(),param.getTenant_id());
        IndexAnswerDetailsDto dto=new IndexAnswerDetailsDto();
        if(model==null) {
        	ResultObject<IndexAnswerDetailsDto> resultObject=new ResultObject<>();
            resultObject.setCode("0");
            resultObject.setMsg("没有数据");
            resultObject.setData(new IndexAnswerDetailsDto());
            return resultObject;
        }
        BeanUtil.copyFields(dto, model);
        ResultObject<IndexAnswerDetailsDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }


    /**
     * 名师详情--所有课程
     */
    @Override
    @PostMapping("/app/TeacherCourse")
    @ResponseBody


    public ResultObject<List<AppTeacherCourseDto>> appTeacherCourse(@RequestBody RequestObject<UidAndTenantID> requestObject) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	if(requestObject.getData()==null) {
    		  ResultObject<List<AppTeacherCourseDto>> resultObject=new ResultObject<>();
    	        resultObject.setCode("1");
    	        resultObject.setMsg("参数不对");
    	        resultObject.setData(new ArrayList<>());
    	        return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
        List<AppTeacherCourseModel> dto=teacherBiz.appTeacherCourseDto(param.getUid(),param.getTenant_id());
        if(dto.size()==0) {
        	 ResultObject<List<AppTeacherCourseDto>> resultObject=new ResultObject<>();
             resultObject.setCode("0");
             resultObject.setMsg("没有数据");
             resultObject.setData(new ArrayList<>());
             return resultObject;
        }
        List<AppTeacherCourseDto> list = BeanUtil.copyList(AppTeacherCourseDto.class, dto);
        ResultObject<List<AppTeacherCourseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }
    /**
     * 名师详情-所有评论
     * @return
     */
    @Override
    @PostMapping("/app/teacherEvaluation")
    @ResponseBody
    public ResultObject<List<AppTeacherEvaluationDto>> teacherEvaluation1(@RequestBody RequestObject<TeacherEvaluationDto> requestObject) {
    	TeacherEvaluationModel  param=new TeacherEvaluationModel();
    	if(requestObject.getData()==null) {
    		ResultObject<List<AppTeacherEvaluationDto>> resultObject=new ResultObject<>();
            resultObject.setCode("1");
            resultObject.setMsg("没有参数哦");
            resultObject.setData(new ArrayList<>());
            return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
        List<AppTeacherEvaluationModel> dto=teacherBiz.teacherEvaluation(param.getUid(),getTenantId(),param.getEval());
        if(dto.size()==0) {
        	ResultObject<List<AppTeacherEvaluationDto>> resultObject=new ResultObject<>();
            resultObject.setCode("0");
            resultObject.setMsg("没有数据");
            resultObject.setData(new ArrayList<>());
            return resultObject;
        }
        List<AppTeacherEvaluationDto> list = BeanUtil.copyList(AppTeacherEvaluationDto.class, dto);
        ResultObject<List<AppTeacherEvaluationDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("/app/indexAnswerDetailsAppendAnswer")
    @ResponseBody
    public ResultObject<Void> indexAnswerDetailsAppendAnswer(@RequestBody RequestObject<IndexAnswerDetailsAppendAnswerParameter> requestObject) {
    	IndexAnswerDetailsAppendAnswerParam param=new IndexAnswerDetailsAppendAnswerParam();
    	if(requestObject.getData()==null) {
    		ResultObject<Void> resultObject=new ResultObject<>();
            resultObject.setCode("1");
            resultObject.setMsg("没有参数");
            return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
        requestObject.getData().setTanant_id(getTenantId());
        Integer appendAskAnswer=studentBiz.insertAppendAskAnswer(param);
        ResultObject<Void> resultObject=new ResultObject<>();
        if(appendAskAnswer==1){

            resultObject.setCode("0");
            resultObject.setMsg("回答成功");
            return resultObject;
        }
        
        return resultObject.setMsg("稍后重试");
    }

    @Override
    @GetMapping("/app/indexAnswerDetailsExceptional")
    @ResponseBody
    public ResultObject<Void> indexAnswerDetailsExceptional(@RequestBody RequestObject<IndexAnswerDetailsExceptionalParameter> requestObject) {
        ResultObject<Void> resultObject=new ResultObject<>();
        //先检测问题的type是否被解决
        Integer type=studentBiz.selectAnswerType(requestObject.getData().getAnswer_id());
        if(type==1){
            return resultObject.setMsg("该问题为解决，不能打赏");
        }
        //在判断学生的积分余额
        Integer balance=studentBiz.selectStudentBalance(requestObject.getData().getStudent_id());
        if(balance<requestObject.getData().getValue()){
            return resultObject.setMsg("余额不足");
        }
        //判断学生是否已经打赏
        Integer is_exceptional=studentBiz.selectAnswerReward(requestObject.getData().getAnswer_id());
        if(is_exceptional==2){
            return resultObject.setMsg("已经打赏过了");
        }
        //进行打赏操作
        Integer updateStudentBalance=studentBiz.updateStudentBalanceByUid(requestObject.getData().getStudent_id(),requestObject.getData().getValue());
        if(updateStudentBalance==1){
            //表示学生扣了积分
            Integer updateTeacherBalance=studentBiz.updateTeacherBalanceByUid(requestObject.getData().getTeacher_id(),requestObject.getData().getValue());
            if(updateTeacherBalance==1){
                //插入积分消费记录
                String uid="1111111111";
                Integer insertStudentRecord=studentBiz.insertStudentRecord(uid,requestObject.getData().getValue(),requestObject.getData().getTeacher_id(),requestObject.getData().getStudent_id());
                Integer insertTeacherRecord=studentBiz.insertTeacherRecord(uid,requestObject.getData().getValue(),requestObject.getData().getTeacher_id());
                if((insertStudentRecord+insertTeacherRecord)==2){
                    resultObject.setMsg("打赏成功");
        
                    resultObject.setCode("0");
                    return resultObject;
                }
                resultObject.setMsg("打赏成功");
    
                resultObject.setCode("0");
                return resultObject;
            }
        }else{
            return resultObject.setMsg("打赏失败");
        }
        return resultObject.setMsg("打赏失败");
    }

   @Override
    @PostMapping("/app/myCollectlist")
    @ResponseBody

    public ResultObject<List<MyCollectlistDto>> myCollectlist(@RequestBody RequestObject<UidAndTenantID> requestObject) {
	   

        List<MyCollectlistDto> dto=collectBiz.myCollectlist(requestObject.getData().getUid(),getTenantId());
        ResultObject<List<MyCollectlistDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(Long.parseLong(dto.size()+""));
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("/app/myStudentInfo")
    @ResponseBody

    public ResultObject<AppMyStudentInfoDto> appMyStudentInfo(@RequestBody RequestObject<UidAndTenantID> requestObject) {
    	UidAndTenantIDParam param=new UidAndTenantIDParam();
    	if(requestObject.getData()==null) {
    		 ResultObject<AppMyStudentInfoDto> resultObject=new ResultObject<>();
    		 resultObject.setCode("1");
    	       resultObject.setMsg("没有参数");
    	        resultObject.setData(new AppMyStudentInfoDto());
    	        return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
        AppMyStudentInfoModel dto=studentBiz.appMyStudentInfo(param.getUid(),param.getTenant_id());
        if(dto==null) {
        	 ResultObject<AppMyStudentInfoDto> resultObject=new ResultObject<>();
    		 resultObject.setCode("0");
    	       resultObject.setMsg("没有数据");
    	        resultObject.setData(new AppMyStudentInfoDto());
    	        return resultObject;
        }
        AppMyStudentInfoDto dtod=new AppMyStudentInfoDto();
        BeanUtil.copyFields(dtod, dto);
        ResultObject<AppMyStudentInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dtod);
        return resultObject;
    }

    /**
     *app修改头像
     * @param resultObject
     * @return
     */
    @Override
    @PostMapping("/app/myStudentInfoEditHead")
    @ResponseBody
    public ResultObject<Void> myStudentInfoEditHead(@RequestBody  RequestObject<AppStudentParameter> resultObject) {
    	if(resultObject.getData()==null) {
    		 ResultObject<Void> resultObj=new ResultObject<>();
    		 resultObj.setCode("1");
         	resultObj.setMsg("没有参数");
             return resultObj;
    	}
    	AppStudentParam param=new AppStudentParam();
    	BeanUtil.copyFields(param, resultObject.getData());
        resultObject.getData().setTenant_id(this.getTenantId());
       Integer result= studentBiz.appUpdaetStudentHead(param);
       ResultObject<Void> resultObj=new ResultObject<>();
        if (result>=0){
        	resultObj.setCode("0");
        	resultObj.setMsg("成功");
            return resultObj;
        }else{
        	resultObj.setCode("1");
        	resultObj.setMsg("失败");
            return resultObj;
        }
    }

    /**
     * app修改昵称
     * @param resultObject
     * @return
     */
    @Override
    @PostMapping("/app/myStudentInfoEditNickname")
    @ResponseBody
    public ResultObject<Void> myStudentInfoEditNickname(@RequestBody  RequestObject<AppStudentParameter> resultObject) {
    	if(resultObject.getData()==null) {
    		 ResultObject<Void> resultObj=new ResultObject<>();
    		 resultObj.setCode("0");
         	resultObj.setMsg("没有参数");
             return resultObj;
    	}
    	AppStudentParam param=new AppStudentParam();
    	BeanUtil.copyFields(param, resultObject.getData());
        resultObject.getData().setTenant_id(this.getTenantId());
        Integer result= studentBiz.appUpdaetStudentNickname(param);
        ResultObject<Void> resultObj=new ResultObject<>();
        if (result>=0){
        	resultObj.setCode("0");
        	resultObj.setMsg("成功");
            return resultObj;
        }else{
        	resultObj.setCode("1");
        	resultObj.setMsg("失败");
            return resultObj;
        }
    }

    /**
     * app修改学生密码
     * @param resultObject
     * @return
     */
    @Override
    @PostMapping("/app/myStudentInfoEditPs")
    @ResponseBody
    public ResultObject<Void> myStudentInfoEditPs(@RequestBody RequestObject<AppStudentParameter> resultObject) {
    	if(resultObject.getData()==null) {
   		 ResultObject<Void> resultObj=new ResultObject<>();
   		 resultObj.setCode("0");
        	resultObj.setMsg("没有参数");
            return resultObj;
   	}
    	AppStudentParam param=new AppStudentParam();
    	BeanUtil.copyFields(param, resultObject.getData());
        resultObject.getData().setTenant_id(this.getTenantId());
        Integer result= studentBiz.appUpdaetStudentPassword(param);
        ResultObject<Void> resultObj=new ResultObject<>();
        if (result>=0){
        	resultObj.setCode("0");
        	resultObj.setMsg("成功");
            return resultObj;
        }else{
        	resultObj.setCode("1");
        	resultObj.setMsg("失败");
            return resultObj;
        }
    }

    /**
     * app查看监护人
     * @param resultObject
     * @return
     */
    @Override
    @PostMapping("/app/myStudentGuardian")
    @ResponseBody
    public ResultObject<List<AppMyStudentGuardianDto>> myStudentGuardian(@RequestBody RequestObject<AppStudentParameter> resultObject) {
    	if(resultObject.getData()==null) {
    		 ResultObject< List<AppMyStudentGuardianDto>> resultObj=new ResultObject<>();
             resultObj.setCode("0");
             resultObj.setMsg("成功");
             resultObj.setData(new ArrayList<>());
             return resultObj;
    	}
    	AppStudentParam param=new AppStudentParam();
    	BeanUtil.copyFields(param, resultObject.getData());
        List<AppMyStudentGuardianModel> dto=studentBiz.appMyStudentGuardian(param);
        System.out.println(dto);
        if(dto.size()==0) {
        	 ResultObject< List<AppMyStudentGuardianDto>> resultObj=new ResultObject<>();
             resultObj.setCode("0");
             resultObj.setMsg("成功");
             resultObj.setData(new ArrayList<>());
             return resultObj;
        }
       List<AppMyStudentGuardianDto> list = BeanUtil.copyList(AppMyStudentGuardianDto.class, dto);
        ResultObject< List<AppMyStudentGuardianDto>> resultObj=new ResultObject<>();
        resultObj.setCode("0");
        resultObj.setMsg("成功");
        resultObj.setData(list);
        return resultObj;
    }
    /**
     * 学生在线课程的课表
     */
	@Override
	@PostMapping("app/indexMycourseTable")
    @ResponseBody
	public ResultObject<List<IndexMyCourseTableDto>> indexMycourseTable(@RequestBody RequestObject<IndexMyCourseTableParameter> parameter) {
		if(parameter.getData()==null) {
			ResultObject<List<IndexMyCourseTableDto>> resultObj=new ResultObject<>();
	        resultObj.setCode("1");
	        resultObj.setMsg("没有收到参数");
	        resultObj.setData(new ArrayList<>());
	        return resultObj;
		}
		IndexMyCourseTableParam param=new IndexMyCourseTableParam();
		System.out.println("======================"+parameter.getData());
		BeanUtil.copyFields(param, parameter.getData());
		List<IndexMyCourseTableModel> list = periodBiz.indexMycourseTable(param);
		if(parameter.getData()==null) {
			ResultObject<List<IndexMyCourseTableDto>> resultObj=new ResultObject<>();
	        resultObj.setCode("0");
	        resultObj.setMsg("没哟数据");
	        resultObj.setData(new ArrayList<>());
	        return resultObj;
		}
		List<IndexMyCourseTableDto> lists = BeanUtil.copyList(IndexMyCourseTableDto.class, list);
		ResultObject<List<IndexMyCourseTableDto>> resultObj=new ResultObject<>();
        resultObj.setCode("0");
        resultObj.setMsg("成功");
        resultObj.setData(lists);
        return resultObj;
	}

//    /**
//     * 查看学生兴趣标签
//     * @param resultObject
//     * @return
//     */
//    @Override
//    @PostMapping("/app/myStudentInterest")
//    @ResponseBody
//    public ResultObject<List<TagDto>> myStudentInterest(ResultObject<AppStudentParameter> resultObject) {
//        List<TagDto> dto=studentBiz.appMyStudentInterest(resultObject.getData());
//        ResultObject< List<TagDto>> resultObj=new ResultObject<>();
//        resultObj.setCode("0");
//        resultObj.setMsg("成功");
//        resultObj.setData(dto);
//        return resultObj;
//    }


}