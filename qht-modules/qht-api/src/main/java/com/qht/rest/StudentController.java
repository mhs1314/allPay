
package com.qht.rest;

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
import com.qht.biz.StudentBiz;
import com.qht.biz.TeacherBiz;
import com.qht.entity.Student;
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
        List<BannerDto> list=studentBiz.selectBanner(getTenantId(),"1");
        ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
        resultObject.setData(list);
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        return resultObject;
    }
    @Override
    @PostMapping("/app/indexBanner")
    @ResponseBody
    public ResultObject<List<BannerDto>> indexBanner(@RequestBody RequestObject<UidAndTenantID> requestObject) {
        //通过session取到运营的id

        List<BannerDto> list=studentBiz.selectBanner(requestObject.getData().getTenant_id(),"2");
        ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
        resultObject.setData(list);
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        return resultObject;
    }
    @Override
    @PostMapping("liveClass")
    @ResponseBody
    public ResultObject<List<LiveClassDto>> liveClass(@RequestBody RequestObject<Void> requestObject) {
        //查询首页直播课程

        List<LiveClassDto> list=studentBiz.selectLiveClass(getTenantId());
        ResultObject<List<LiveClassDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("freeClass")
    @ResponseBody
    public ResultObject<List<FreeClassDto>> freeClass(@RequestBody RequestObject<FreeClassParameter> requestObject) {
        //requestObject.getData().setTenant_id(getTenantId());
    	//TODO
        FreeClassParameter fcp = new FreeClassParameter();
       
        fcp.setTenant_id("11");
        //查询免费课程
        List<FreeClassDto> list= studentBiz.selectFreeClass(fcp);
        ResultObject<List<FreeClassDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("listeningClassRanking")
    @ResponseBody
    public ResultObject<List<ListeningClassRankingDto>> listeningClassRanking(@RequestBody RequestObject<Void> requestObject) {
        //查询试听排行榜
        List<ListeningClassRankingDto> list=studentBiz.selectListeningClassRanking(getTenantId());
        ResultObject<List<ListeningClassRankingDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("listeningClassList")
    @ResponseBody
    public ResultObject<List<ListeningClassListDto>> listeningClassList(@RequestBody RequestObject<Void> requestObject) {
        //查询
        List<ListeningClassListDto> list=studentBiz.selectListeningClassList(getTenantId());
        ResultObject<List<ListeningClassListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("teacherRanking")
    @ResponseBody
    public ResultObject<List<TeacherRankingDto>> teacherRanking(@RequestBody RequestObject<Void> requestObject) {
        //查询
        List<TeacherRankingDto> list=studentBiz.selectTeacherRanking(getTenantId());
        ResultObject<List<TeacherRankingDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("indexTeacherList")
    @ResponseBody
    public ResultObject<List<TeacherListDto>> teacherList(@RequestBody RequestObject<TeacherListParameter> requestObject) {

        requestObject.getData().setTenant_id(this.getTenantId());
        //查询
        List<TeacherListDto> list=studentBiz.selectTeacherList(requestObject.getData());
        ResultObject<List<TeacherListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("courseIntro")
    @ResponseBody
    public ResultObject<CourseIntroDto> courseIntro(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
        //通过课程包的uid和运营的id查询
        CourseIntroDto courseIntroDto=studentBiz.selectCourseIntro(requestObject.getData().getUid(),getTenantId());
        ResultObject<CourseIntroDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(courseIntroDto);
        return resultObject;
    }

    @Override
    @PostMapping("courseChapter")
    @ResponseBody
    public ResultObject<List<CourseChapterDto>> courseChapter(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
        List<CourseChapterDto> courseChapterDtos=studentBiz.selectCourseChapter(requestObject.getData().getUid(),getTenantId());
        ResultObject<List<CourseChapterDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(courseChapterDtos);
        return resultObject;
    }

    @Override
    @PostMapping("courseEvaluation")
    @ResponseBody
    public ResultObject<List<CourseEvaluationDto>> courseEvaluation(@RequestBody RequestObject<CourseEvaluationParameter> requestObject) {
        ResultObject<List<CourseEvaluationDto>> resultObject=new ResultObject<>();
        if(requestObject.getData().getEval()==""){
            PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
            List<CourseEvaluationDto> courseEvaluationDtos=studentBiz.selectCourseEvaluation(requestObject.getData());
            PageInfo<CourseEvaluationDto> count=new PageInfo<>(courseEvaluationDtos);
            List<CourseEvaluationDto> courseEvaluationDtosGood=studentBiz.selectCourseEvaluationGood(requestObject.getData());
            List<CourseEvaluationDto> courseEvaluationDtosMid=studentBiz.selectCourseEvaluationMid(requestObject.getData());
            List<CourseEvaluationDto> courseEvaluationDtosBad=studentBiz.selectCourseEvaluationBad(requestObject.getData());
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            resultObject.setCount(count.getTotal());
            resultObject.setCount_good(courseEvaluationDtosGood.size());
            resultObject.setCount_mid(courseEvaluationDtosMid.size());
            resultObject.setCount_bad(courseEvaluationDtosBad.size());
            resultObject.setData(courseEvaluationDtos);
            return resultObject;
        }
        if(requestObject.getData().getEval().equals("3")){
            PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
            List<CourseEvaluationDto> courseEvaluationDtosGood=studentBiz.selectCourseEvaluationGood(requestObject.getData());
            PageInfo<CourseEvaluationDto> count=new PageInfo<>(courseEvaluationDtosGood);
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            resultObject.setCount(count.getTotal());
            resultObject.setData(courseEvaluationDtosGood);
            return resultObject;
        }
        if(requestObject.getData().getEval().equals("2")){
            PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
            List<CourseEvaluationDto> courseEvaluationDtosMid=studentBiz.selectCourseEvaluationMid(requestObject.getData());
            PageInfo<CourseEvaluationDto> count=new PageInfo<>(courseEvaluationDtosMid);
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            resultObject.setCount(count.getTotal());
            resultObject.setData(courseEvaluationDtosMid);
            return resultObject;
        }
        if(requestObject.getData().getEval().equals("1")){
            PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
            List<CourseEvaluationDto> courseEvaluationDtosBad=studentBiz.selectCourseEvaluationMid(requestObject.getData());
            PageInfo<CourseEvaluationDto> count=new PageInfo<>(courseEvaluationDtosBad);
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            resultObject.setCount(count.getTotal());
            resultObject.setData(courseEvaluationDtosBad);
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
        TeacherInfoDto teacherInfoDto=studentBiz.selectTeacherInfo(requestObject.getData().getUid(),getTenantId());
        ResultObject<TeacherInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(teacherInfoDto);
        return resultObject;
    }



    @Override
    @PostMapping("courseList")
    @ResponseBody
    public ResultObject<List<CourseListDto>> courseList(@RequestBody RequestObject<CourseListParameter> requestObject) {
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()), Integer.parseInt(requestObject.getData().getLimit()));
        requestObject.getData().setTenant_id(getTenantId());
        List<CourseListDto> courseListDtos=studentBiz.selectCourseList(requestObject.getData());
        //得到总条数
        PageInfo<CourseListDto> count=new PageInfo<>(courseListDtos);
        ResultObject<List<CourseListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(courseListDtos);
        return resultObject;
    }

    @Override
    @PostMapping("teacherList")
    @ResponseBody
    public ResultObject<List<TopTeacherListDto>> topTeacherList(@RequestBody RequestObject<TopTeacherListParameter> requestObject) {
        System.out.println();
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()), Integer.parseInt(requestObject.getData().getLimit()));
        requestObject.getData().setTenant_id(getTenantId());
        List<TopTeacherListDto> topTeacherListDtos=studentBiz.selectTopTeacherList(requestObject.getData());
        //得到总条数
        PageInfo<TopTeacherListDto> count=new PageInfo<>(topTeacherListDtos);
        ResultObject<List<TopTeacherListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(topTeacherListDtos);
        return resultObject;
    }

    @Override
    @PostMapping("courseTeacherInfo")
    @ResponseBody

    public ResultObject<List<TopTeacherInfoDto>> topTeacherInfo(@RequestBody RequestObject<UidAndTenantID> request) {
        List<TopTeacherInfoDto> topTeacherInfoDtos=studentBiz.selectTopTeacherInfo(request.getData().getUid(),getTenantId());
        ResultObject<List<TopTeacherInfoDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(topTeacherInfoDtos);
        return resultObject;
    }

    @Override
    @PostMapping("teacherCourse")
    @ResponseBody
    public ResultObject<List<TeacherCourseDto>> teacherCourse(@RequestBody RequestObject<UidAndTenantID> request) {
        List<TeacherCourseDto> teacherCourseDtos=studentBiz.selectTeacherCourse(request.getData().getUid(),getTenantId());
        ResultObject<List<TeacherCourseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(teacherCourseDtos);
        resultObject.setCount((long) teacherCourseDtos.size());
        return resultObject;
    }

    @Override
    @PostMapping("teacherEvaluation")
    @ResponseBody


    public ResultObject<List<TeacherEvaluationDto>> teacherEvaluation(@RequestBody RequestObject<UidAndTenantID> request) {
        List<TeacherEvaluationDto> teacherEvaluationDtos=studentBiz.selectTeacherEvaluation(request.getData().getUid(),getTenantId());
        ResultObject<List<TeacherEvaluationDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(teacherEvaluationDtos);
        return resultObject;
    }

    @Override
    @PostMapping("tenantSchool")
    @ResponseBody
    public ResultObject<TenantSchoolDto> tenantSchool(@RequestBody RequestObject<Void> requestObject) {
        TenantSchoolDto tenantSchoolDto=studentBiz.selectTenantSchool(getTenantId());
        ResultObject<TenantSchoolDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(tenantSchoolDto);
        return resultObject;
    }

    @Override
    @PostMapping("tenantAlbum")
    @ResponseBody
    public ResultObject<List<TenantAlbumDto>> tenantAlbum(@RequestBody RequestObject<Void> requestObject) {
        List<TenantAlbumDto> tenantAlbumDtos=studentBiz.selectTenantAlbum(getTenantId());
        ResultObject<List<TenantAlbumDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(tenantAlbumDtos);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexCourse")
    @ResponseBody
    public ResultObject<List<MyIndexCourseDto>> myIndexCourse(@RequestBody RequestObject<MyIndexCourseParameter> requestObject) {
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()), Integer.parseInt(requestObject.getData().getLimit()));
        requestObject.getData().setTenant_id(getTenantId());
        List<MyIndexCourseDto> myIndexCourseDtos=studentBiz.selectMyIndexCourse(requestObject.getData());
        PageInfo<MyIndexCourseDto> count=new PageInfo<>(myIndexCourseDtos);
        ResultObject<List<MyIndexCourseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(myIndexCourseDtos);
        return resultObject;
    }

    @Override
    @PostMapping("indexCourseDetails")
    @ResponseBody
    public ResultObject<List<IndexCourseDetailsDto>> indexCourseDetails(@RequestBody RequestObject<UidAndTenantID> req) {
        List<IndexCourseDetailsDto> indexCourseDetailsDtos=studentBiz.selectIndexCourseDetails(req.getData().getUid(),getTenantId());
        ResultObject<List<IndexCourseDetailsDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(indexCourseDetailsDtos);
        return resultObject;
    }
    @Override
    @PostMapping("myIndexMessage")
    @ResponseBody
    public ResultObject<List<MyIndexMessageDto>> myIndexMessage(@RequestBody RequestObject<MyIndexMessageParamter> paramter) {
        Integer p=Integer.parseInt(paramter.getData().getPage());
        Integer l=Integer.parseInt(paramter.getData().getLimit());
        paramter.getData().setIsread(getTenantId());
        PageHelper.startPage(p,l);
        List<MyIndexMessageDto> list=studentBiz.selectMyIndexMessage(paramter);
        PageInfo<MyIndexMessageDto> count=new PageInfo<>(list);
        ResultObject<List<MyIndexMessageDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(list);
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
        MyIndexMessageDto dto=studentBiz.selectMessageById(requestObject.getData().getUid());
        ResultObject<MyIndexMessageDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexBuyrecord")
    @ResponseBody
    public ResultObject<List<MyIndexBuyRecordDto>> myIndexBuyRecord(@RequestBody RequestObject<MyIndexBuyRecordParameter> requestObject) {
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()) );
        requestObject.getData().setTenant_id(getTenantId());
        List<MyIndexBuyRecordDto> myIndexBuyRecordDtos=studentBiz.selectMyIndexBuyRecourd(requestObject.getData());
        PageInfo<MyIndexBuyRecordDto> count=new PageInfo<>(myIndexBuyRecordDtos);
        ResultObject<List<MyIndexBuyRecordDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(myIndexBuyRecordDtos);
        return resultObject;
    }

    @Override
    @PostMapping("studentInfo")
    @ResponseBody


    public ResultObject<StudentInfoDto> studentInfo(@RequestBody RequestObject<UidAndTenantID> requestObject) {
        StudentInfoDto dto=studentBiz.studentInfo(requestObject.getData().getUid(),getTenantId());
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
        parameter.getData().setTenant_id(getTenantId());
        Integer p=Integer.parseInt(parameter.getData().getPage());
        Integer l=Integer.parseInt(parameter.getData().getLimit());
        PageHelper.startPage(p,l);
        List<MyIndexMyintegralDetailDto> list=studentBiz.myIndexMyintegralDetail(parameter);
        PageInfo<MyIndexMyintegralDetailDto> count=new PageInfo<>(list);
        ResultObject<List<MyIndexMyintegralDetailDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexCourseAnswer")
    @ResponseBody
    public ResultObject<List<MyIndexCourseAnswerDto>> myIndexCourseAnswer(@RequestBody RequestObject<MyIndexCourseAnswerParameter> requestObject) {
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()) );
        requestObject.getData().setTenant_id(getTenantId());
        List<MyIndexCourseAnswerDto> myIndexCourseAnswerDtos=studentBiz.selectMyIndexCourseAnswer(requestObject.getData());
        PageInfo<MyIndexCourseAnswerDto> count=new PageInfo<>(myIndexCourseAnswerDtos);
        ResultObject<List<MyIndexCourseAnswerDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(myIndexCourseAnswerDtos);
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
        List<IndexFutureCoruseDto> dto=studentBiz.indexFutureCoruse(req.getData().getUid(),getTenantId());
        ResultObject<List<IndexFutureCoruseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("/app/indexTeacher")
    @ResponseBody
    public ResultObject<List<IndexTeacherDto>> indexTeacher(@RequestBody RequestObject<Void> req) {
        List<IndexTeacherDto> dto=studentBiz.indexTeacher(getTenantId());
        ResultObject<List<IndexTeacherDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
       return  resultObject;
    }

    @Override
    @PostMapping("/app/indexAnswer")
    @ResponseBody
    public ResultObject<List<IndexAnswerDto>> indexAnswer(@RequestBody RequestObject<Void> req) {
        List<IndexAnswerDto> dto=studentBiz.indexAnswer(getTenantId());
        ResultObject<List<IndexAnswerDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return  resultObject;
    }

    @Override
    @PostMapping("/app/indexCoruseList")
    @ResponseBody
    public ResultObject<List<IndexCoruseListDto>> indexCoruseList(@RequestBody RequestObject<IndexCoruseListParameter> parameter) {        System.out.println("-------------"+parameter);


        parameter.getData().setTenant_id(getTenantId());
        List<IndexCoruseListDto> dto=studentBiz.indexCoruseList(parameter.getData());
        ResultObject<List<IndexCoruseListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return  resultObject;
    }

    @Override
    @PostMapping("/app/indexTeacherList")
    @ResponseBody
    public ResultObject<List<IndexTeacherListDto>> indexTeacherList(@RequestBody RequestObject<IndexTeacherListParameter> parameter) {
        parameter.getData().setTenant_id(getTenantId());
    	IndexTeacherListParameter para = new IndexTeacherListParameter();
    	para.setTenant_id("11");
        List<IndexTeacherListDto> dto=studentBiz.indexTeacherList(para);
        ResultObject<List<IndexTeacherListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return  resultObject;
    }

    @Override
    @PostMapping("myIndexBuyrecordCourseDetails")
    @ResponseBody
    public ResultObject<List<MyIndexBuyRecordCourseDetailsDto>> myIndexBuyRecordCourseDetails(@RequestBody RequestObject<UidAndTenantID> req) {
        List<MyIndexBuyRecordCourseDetailsDto> myIndexBuyRecordCourseDetailsDtos=studentBiz.selectMyIndexBuyRecordDetails(req.getData().getUid());
        ResultObject<List<MyIndexBuyRecordCourseDetailsDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(myIndexBuyRecordCourseDetailsDtos);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexBuyrecordCourseBack")
    @ResponseBody
    public ResultObject<List<MyIndexBuyRecordCourseBackDto>> myIndexBuyRecordCourseBack(@RequestBody RequestObject<MyIndexBuyRecordCourseBackParameter> requestObject) {
        requestObject.getData().setTenant_id(getTenantId());
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
        List<MyIndexBuyRecordCourseBackDto> myIndexBuyRecordCourseBackDtos=studentBiz.selectMyIndexBuyRecordCourseBack(requestObject.getData());
        PageInfo<MyIndexBuyRecordCourseBackDto> count=new PageInfo<>(myIndexBuyRecordCourseBackDtos);
        ResultObject<List<MyIndexBuyRecordCourseBackDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(myIndexBuyRecordCourseBackDtos);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexMycollect")
    @ResponseBody
    public ResultObject<List<MyIndexMycollectDto>> myIndexMycollect(@RequestBody RequestObject<MyIndexMycollectParameter> requestObject) {
        requestObject.getData().setTenant_id(getTenantId());
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()) );
        List<MyIndexMycollectDto> myIndexMycollectDtos=studentBiz.selectMyIndexMycollect(requestObject.getData());
        PageInfo<MyIndexMycollectDto> count=new PageInfo<>(myIndexMycollectDtos);
        ResultObject<List<MyIndexMycollectDto>> resultObject=new ResultObject<>();
        resultObject.setCount(count.getTotal());
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        return null;
    }

    @Override
    @PostMapping("myIndexCancelcollect")
    @ResponseBody

    public ResultObject<Void> myIndexCancelcollect(@RequestBody RequestObject<MyIndexCanceCollectParameter> requestObject) {
        ResultObject<Void> resultObject=new ResultObject<>();
        String uid = requestObject.getData().getUid();

        String student_id = requestObject.getData().getStudent_id();
        Integer updateLine=studentBiz.updateMyIndexCancelcollect(uid,student_id,getTenantId());
        if(updateLine>0){

            resultObject.setCode("0");
            resultObject.setMsg("取消成功");
            return resultObject;
        }else{
            resultObject.setCode("2");
            resultObject.setMsg("服务器异常");
            return resultObject;
        }
    }

    @Override
    @PostMapping("/app/indexMyAnswer")
    @ResponseBody


    public ResultObject<List<IndexMyAnswerDto>> indexMyAnswer(@RequestBody RequestObject<UidAndTenantID> requestObject) {
        List<IndexMyAnswerDto> indexMyAnswerDtos=studentBiz.selectIndexMyAnswer(requestObject.getData().getUid(),getTenantId());
        ResultObject<List<IndexMyAnswerDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(indexMyAnswerDtos);
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
        TeacherDetailsDto teacherDetailsDto=teacherBiz.teacherDetails(requestObject.getData().getUid(),getTenantId());
        ResultObject<TeacherDetailsDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(teacherDetailsDto);
        return resultObject;
    }

    @Override
    @PostMapping("/app/indexAnswerDetails")
    @ResponseBody
    public ResultObject<IndexAnswerDetailsDto> indexAnswerDetails(@RequestBody RequestObject<UidAndTenantID> requestObject){
        IndexAnswerDetailsDto indexAnswerDetailsDto=studentBiz.selectIndexAnswerDetails(requestObject.getData().getUid(),getTenantId());
        ResultObject<IndexAnswerDetailsDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(indexAnswerDetailsDto);
        return resultObject;
    }


    /**
     * 名师详情--所有课程
     */
    @Override
    @PostMapping("/app/TeacherCourse")
    @ResponseBody
    public ResultObject<List<AppTeacherCourseDto>> appTeacherCourse(@RequestBody RequestObject<UidAndTenantID> requestObject) {
        List<AppTeacherCourseDto> dto=teacherBiz.appTeacherCourseDto(requestObject.getData().getUid(),getTenantId());
        ResultObject<List<AppTeacherCourseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
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

        List<AppTeacherEvaluationDto> dto=teacherBiz.teacherEvaluation(requestObject.getData().getUid(),getTenantId(),requestObject.getData().getEval());
        ResultObject<List<AppTeacherEvaluationDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("/app/indexAnswerDetailsAppendAnswer")
    @ResponseBody
    public ResultObject<Void> indexAnswerDetailsAppendAnswer(@RequestBody RequestObject<IndexAnswerDetailsAppendAnswerParameter> requestObject) {

        requestObject.getData().setTanant_id(getTenantId());
        Integer appendAskAnswer=studentBiz.insertAppendAskAnswer(requestObject.getData());
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


        AppMyStudentInfoDto dto=studentBiz.appMyStudentInfo(requestObject.getData().getUid(),getTenantId());
        ResultObject<AppMyStudentInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
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
    public ResultObject<Void> myStudentInfoEditHead(@RequestBody  ResultObject<AppStudentParameter> resultObject) {
        resultObject.getData().setTenant_id(this.getTenantId());
       Integer result= studentBiz.appUpdaetStudentHead(resultObject.getData());
        ResultObject<Void> resultObj=new ResultObject<>();
        if (result>=0){
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            return resultObj;
        }else{
            resultObject.setCode("1");
            resultObject.setMsg("失败");
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
    public ResultObject<Void> myStudentInfoEditNickname(@RequestBody  ResultObject<AppStudentParameter> resultObject) {
        resultObject.getData().setTenant_id(this.getTenantId());
        Integer result= studentBiz.appUpdaetStudentNickname(resultObject.getData());
        ResultObject<Void> resultObj=new ResultObject<>();
        if (result>=0){
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            return resultObj;
        }else{
            resultObject.setCode("1");
            resultObject.setMsg("失败");
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
    public ResultObject<Void> myStudentInfoEditPs(ResultObject<AppStudentParameter> resultObject) {
        resultObject.getData().setTenant_id(this.getTenantId());
        Integer result= studentBiz.appUpdaetStudentPassword(resultObject.getData());
        ResultObject<Void> resultObj=new ResultObject<>();
        if (result>=0){
            resultObject.setCode("0");
            resultObject.setMsg("成功");
            return resultObj;
        }else{
            resultObject.setCode("1");
            resultObject.setMsg("失败");
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
    public ResultObject<List<AppMyStudentGuardianDto>> myStudentGuardian(ResultObject<AppStudentParameter> resultObject) {

        List<AppMyStudentGuardianDto> dto=studentBiz.appMyStudentGuardian(resultObject.getData());
        ResultObject< List<AppMyStudentGuardianDto>> resultObj=new ResultObject<>();
        resultObj.setCode("0");
        resultObj.setMsg("成功");
        resultObj.setData(dto);
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