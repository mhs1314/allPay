package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.StudentBiz;
import com.qht.dto.*;
import com.qht.entity.Student;
import com.qht.services.StudentService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController extends APIBaseController<StudentBiz,Student> implements StudentService {

    @Autowired
    private StudentBiz studentBiz;

    /**
     * 得到tenantId
     * @param request
     * @return
     */
    public String getTenantId(HttpServletRequest request){
        String tenantId=null;
        StudentDto studentDto=(StudentDto)request.getSession().getAttribute("studentDto");
        if (studentDto!=null){
            tenantId=studentDto.getTenantId();
        }
        return tenantId;
    }

    @Override
    @PostMapping("login")
    @ResponseBody
    public ResultObject<StudentDto> login(RequestObject<LoginInfoDto> requestObject) {
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
            resultObject.setCode("1");
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
    public ResultObject<List<BannerDto>> banner(HttpServletRequest req) {
        //通过session取到运营的id
        List<BannerDto> list=studentBiz.selectBanner(this.getTenantId(req),"1");
        ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
        resultObject.setData(list);
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        return resultObject;
    }
    @Override
    @PostMapping("/app/indexBanner")
    @ResponseBody
    public ResultObject<List<BannerDto>> indexBanner(HttpServletRequest req) {
        //通过session取到运营的id
        List<BannerDto> list=studentBiz.selectBanner(this.getTenantId(req),"2");
        ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
        resultObject.setData(list);
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        return resultObject;
    }
    @Override
    @PostMapping("liveClass")
    @ResponseBody
    public ResultObject<List<LiveClassDto>> liveClass(HttpServletRequest req) {
        //查询首页直播课程
        List<LiveClassDto> list=studentBiz.selectLiveClass(this.getTenantId(req));
        ResultObject<List<LiveClassDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("freeClass")
    @ResponseBody
    public ResultObject<List<FreeClassDto>> freeClass(RequestObject<FreeClassParameter> requestObject,HttpServletRequest req) {
        requestObject.getData().setTenant_id(this.getTenantId(req));
        //查询免费课程
        List<FreeClassDto> list= studentBiz.selectFreeClass(requestObject.getData());
        ResultObject<List<FreeClassDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("listeningClassRanking")
    @ResponseBody
    public ResultObject<List<ListeningClassRankingDto>> listeningClassRanking(HttpServletRequest req) {
        //查询试听排行榜
        List<ListeningClassRankingDto> list=studentBiz.selectListeningClassRanking(this.getTenantId(req));
        ResultObject<List<ListeningClassRankingDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("listeningClassList")
    @ResponseBody
    public ResultObject<List<ListeningClassListDto>> listeningClassList(HttpServletRequest req) {
        //查询
        List<ListeningClassListDto> list=studentBiz.selectListeningClassList(this.getTenantId(req));
        ResultObject<List<ListeningClassListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("teacherRanking")
    @ResponseBody
    public ResultObject<List<TeacherRankingDto>> teacherRanking(HttpServletRequest req) {
        //查询
        List<TeacherRankingDto> list=studentBiz.selectTeacherRanking(this.getTenantId(req));
        ResultObject<List<TeacherRankingDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @GetMapping("teacherList")
    @ResponseBody
    public ResultObject<List<TeacherListDto>> teacherList(HttpServletRequest req) {
        //查询
        List<TeacherListDto> list=studentBiz.selectTeacherList(this.getTenantId(req));
        ResultObject<List<TeacherListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("courseIntro")
    @ResponseBody
    public ResultObject<CourseIntroDto> courseIntro(RequestObject<CourseIntroParameter> requestObject,HttpServletRequest req) {
        //通过课程包的uid和运营的id查询
        CourseIntroDto courseIntroDto=studentBiz.selectCourseIntro(requestObject.getData().getUid(),this.getTenantId(req));
        ResultObject<CourseIntroDto> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(courseIntroDto);
        return resultObject;
    }

    @Override
    @PostMapping("courseChapter")
    @ResponseBody
    public ResultObject<List<CourseChapterDto>> courseChapter(RequestObject<CourseIntroParameter> requestObject, HttpServletRequest req) {
        List<CourseChapterDto> courseChapterDtos=studentBiz.selectCourseChapter(requestObject.getData().getUid(),this.getTenantId(req));
        ResultObject<List<CourseChapterDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(courseChapterDtos);
        return resultObject;
    }

    @Override
    @PostMapping("courseEvaluation")
    @ResponseBody
    public ResultObject<List<CourseEvaluationDto>> courseEvaluation(RequestObject<CourseIntroParameter> requestObject, HttpServletRequest req) {
        List<CourseEvaluationDto> courseEvaluationDtos=studentBiz.selectCourseEvaluation(requestObject.getData().getUid(),this.getTenantId(req));
        ResultObject<List<CourseEvaluationDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(courseEvaluationDtos);
        return resultObject;
    }

    @Override
    @PostMapping("teacherInfo")
    @ResponseBody
    public ResultObject<TeacherInfoDto> teacherInfo(RequestObject<CourseIntroParameter> requestObject, HttpServletRequest req) {
        TeacherInfoDto teacherInfoDto=studentBiz.selectTeacherInfo(requestObject.getData().getUid(),this.getTenantId(req));
        ResultObject<TeacherInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(teacherInfoDto);
        return resultObject;
    }



    @Override
    @PostMapping("courseList")
    @ResponseBody
    public ResultObject<List<CourseListDto>> courseList(RequestObject<CourseListParameter> requestObject,
                                                        HttpServletRequest req) {

        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()), Integer.parseInt(requestObject.getData().getLimit()));
        requestObject.getData().setTenant_id(this.getTenantId(req));
        List<CourseListDto> courseListDtos=studentBiz.selectCourseList(requestObject.getData());
        //得到总条数
        PageInfo<CourseListDto> count=new PageInfo<>(courseListDtos);
        ResultObject<List<CourseListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(courseListDtos);
        return resultObject;
    }

    @Override
    @PostMapping("teacherList")
    @ResponseBody
    public ResultObject<List<TopTeacherListDto>> topTeacherList(RequestObject<TopTeacherListParameter> requestObject,
                                                                HttpServletRequest req) {
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()), Integer.parseInt(requestObject.getData().getLimit()));
        requestObject.getData().setTenant_id(this.getTenantId(req));
        List<TopTeacherListDto> topTeacherListDtos=studentBiz.selectTopTeacherList(requestObject.getData());
        //得到总条数
        PageInfo<TopTeacherListDto> count=new PageInfo<>(topTeacherListDtos);
        ResultObject<List<TopTeacherListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(topTeacherListDtos);
        return resultObject;
    }

    @Override
    @PostMapping("courseTeacherInfo")
    @ResponseBody
    public ResultObject<List<TopTeacherInfoDto>> topTeacherInfo(@RequestParam("uid") String uid, HttpServletRequest req) {
        List<TopTeacherInfoDto> topTeacherInfoDtos=studentBiz.selectTopTeacherInfo(uid,this.getTenantId(req));
        ResultObject<List<TopTeacherInfoDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(topTeacherInfoDtos);
        return resultObject;
    }

    @Override
    @PostMapping("teacherCourse")
    @ResponseBody
    public ResultObject<List<TeacherCourseDto>> teacherCourse(@RequestParam("uid")String uid, HttpServletRequest req) {
        List<TeacherCourseDto> teacherCourseDtos=studentBiz.selectTeacherCourse(uid,this.getTenantId(req));
        ResultObject<List<TeacherCourseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(teacherCourseDtos);
        resultObject.setCount((long) teacherCourseDtos.size());
        return resultObject;
    }

    @Override
    @PostMapping("teacherEvaluation")
    @ResponseBody
    public ResultObject<List<TeacherEvaluationDto>> teacherEvaluation(@RequestParam("uid")String uid, HttpServletRequest req) {
        List<TeacherEvaluationDto> teacherEvaluationDtos=studentBiz.selectTeacherEvaluation(uid,this.getTenantId(req));
        ResultObject<List<TeacherEvaluationDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(teacherEvaluationDtos);
        return resultObject;
    }

    @Override
    @PostMapping("tenantSchool")
    @ResponseBody
    public ResultObject<TenantSchoolDto> tenantSchool(HttpServletRequest req) {
        TenantSchoolDto tenantSchoolDto=studentBiz.selectTenantSchool(this.getTenantId(req));
        ResultObject<TenantSchoolDto> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(tenantSchoolDto);
        return resultObject;
    }

    @Override
    @PostMapping("tenantAlbum")
    @ResponseBody
    public ResultObject<TenantAlbumDto> tenantAlbum(HttpServletRequest req) {
        TenantAlbumDto tenantAlbumDto=studentBiz.selectTenantAlbum(this.getTenantId(req));
        ResultObject<TenantAlbumDto> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(tenantAlbumDto);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexCourse")
    @ResponseBody
    public ResultObject<List<MyIndexCourseDto>> myIndexCourse(RequestObject<MyIndexCourseParameter> requestObject,
                                                            HttpServletRequest req) {
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()), Integer.parseInt(requestObject.getData().getLimit()));
        requestObject.getData().setTenant_id(this.getTenantId(req));
        List<MyIndexCourseDto> myIndexCourseDtos=studentBiz.selectMyIndexCourse(requestObject.getData());
        PageInfo<MyIndexCourseDto> count=new PageInfo<>(myIndexCourseDtos);
        ResultObject<List<MyIndexCourseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(myIndexCourseDtos);
        return resultObject;
    }

    @Override
    @PostMapping("indexCourseDetails")
    @ResponseBody
    public ResultObject<List<IndexCourseDetailsDto>> indexCourseDetails(@RequestParam("uid") String uid, HttpServletRequest req) {
        List<IndexCourseDetailsDto> indexCourseDetailsDtos=studentBiz.selectIndexCourseDetails(uid,this.getTenantId(req));
        ResultObject<List<IndexCourseDetailsDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(indexCourseDetailsDtos);
        return resultObject;
    }
    @Override
    @PostMapping("myIndexMessage")
    @ResponseBody
    public ResultObject<List<MyIndexMessageDto>> myIndexMessage(HttpServletRequest req,RequestObject<MyIndexMessageParamter> paramter) {
        Integer p=Integer.parseInt(paramter.getData().getPage());
        Integer l=Integer.parseInt(paramter.getData().getLimit());
        paramter.getData().setIsread(this.getTenantId(req));
        PageHelper.startPage(p,l);
        List<MyIndexMessageDto> list=studentBiz.selectMyIndexMessage(paramter);
        PageInfo<MyIndexMessageDto> count=new PageInfo<>(list);
        ResultObject<List<MyIndexMessageDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(list);
        return resultObject;

    }

    @Override
    @PostMapping("myIndexDelMessage")
    @ResponseBody
    public ResultObject<Integer> deleteMessage(String uid) {
        Integer row=studentBiz.deleteMessage(uid);
        ResultObject<Integer> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(row);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexMessageDetails")
    @ResponseBody
    public ResultObject<MyIndexMessageDto> selectMessageById(String uid) {
        MyIndexMessageDto dto=studentBiz.selectMessageById(uid);
        ResultObject<MyIndexMessageDto> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexBuyrecord")
    @ResponseBody
    public ResultObject<List<MyIndexBuyRecordDto>> myIndexBuyRecord(RequestObject<MyIndexBuyRecordParameter> requestObject,
                                                                    HttpServletRequest req) {
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()) );
        requestObject.getData().setTenant_id(this.getTenantId(req));
        List<MyIndexBuyRecordDto> myIndexBuyRecordDtos=studentBiz.selectMyIndexBuyRecourd(requestObject.getData());
        PageInfo<MyIndexBuyRecordDto> count=new PageInfo<>(myIndexBuyRecordDtos);
        ResultObject<List<MyIndexBuyRecordDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(myIndexBuyRecordDtos);
        return resultObject;
    }

    @Override
    @PostMapping("studentInfo")
    @ResponseBody
    public ResultObject<StudentInfoDto> studentInfo(HttpServletRequest reg,String uid,String tid) {
        StudentInfoDto dto=studentBiz.studentInfo(uid,this.getTenantId(reg));
        ResultObject<StudentInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }
    //消費記錄
    @Override
    @PostMapping("/myIndexMyintegralDetail")
    @ResponseBody
    public ResultObject<List<MyIndexMyintegralDetailDto>> myIndexMyintegralDetail(HttpServletRequest reg, RequestObject<MyIndexMyintegralDetailParameter> parameter) {
        parameter.getData().setTenant_id(this.getTenantId(reg));
        Integer p=Integer.parseInt(parameter.getData().getPage());
        Integer l=Integer.parseInt(parameter.getData().getLimit());
        PageHelper.startPage(p,l);
        List<MyIndexMyintegralDetailDto> list=studentBiz.myIndexMyintegralDetail(parameter);
        PageInfo<MyIndexMyintegralDetailDto> count=new PageInfo<>(list);
        ResultObject<List<MyIndexMyintegralDetailDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexCourseAnswer")
    @ResponseBody
    public ResultObject<List<MyIndexCourseAnswerDto>> myIndexCourseAnswer(RequestObject<MyIndexCourseAnswerParameter> requestObject,
                                                                          HttpServletRequest req) {

        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()) );
        requestObject.getData().setTenant_id(this.getTenantId(req));
        List<MyIndexCourseAnswerDto> myIndexCourseAnswerDtos=studentBiz.selectMyIndexCourseAnswer(requestObject.getData());
        PageInfo<MyIndexCourseAnswerDto> count=new PageInfo<>(myIndexCourseAnswerDtos);
        ResultObject<List<MyIndexCourseAnswerDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(myIndexCourseAnswerDtos);
        return resultObject;
    }

    /**
     * 近期课程
     * @param reg
     * @param uid
     * @param tid
     * @return
     */
    @Override
    @PostMapping("/app/indexFutureCoruse")
    @ResponseBody
    public ResultObject<List<IndexFutureCoruseDto>> indexFutureCoruse(HttpServletRequest reg, String uid, String tid) {
        List<IndexFutureCoruseDto> dto=studentBiz.indexFutureCoruse(uid,this.getTenantId(reg));
        ResultObject<List<IndexFutureCoruseDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }

    @Override
    @PostMapping("/app/indexTeacher")
    @ResponseBody
    public ResultObject<List<IndexTeacherDto>> indexTeacher(HttpServletRequest reg) {
        List<IndexTeacherDto> dto=studentBiz.indexTeacher(this.getTenantId(reg));
        ResultObject<List<IndexTeacherDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
       return  resultObject;
    }

    @Override
    @PostMapping("/app/indexAnswer")
    @ResponseBody
    public ResultObject<List<IndexAnswerDto>> indexAnswer(HttpServletRequest reg) {
        List<IndexAnswerDto> dto=studentBiz.indexAnswer(this.getTenantId(reg));
        ResultObject<List<IndexAnswerDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return  resultObject;
    }

}