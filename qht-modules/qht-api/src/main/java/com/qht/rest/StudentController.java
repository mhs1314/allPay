package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.StudentBiz;
import com.qht.dto.*;
import com.qht.entity.Student;
import com.qht.services.StudentService;
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
        List<BannerDto> list=studentBiz.selectBanner(this.getTenantId(req));
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
        //查询免费课程
        List<FreeClassDto> list=
                studentBiz.selectFreeClass(requestObject.getData().getPkg_subject_id(),
                        requestObject.getData().getPkg_grade_id(),this.getTenantId(req));
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
                                                        @RequestParam(defaultValue = "1") String  page ,
                                                        @RequestParam(defaultValue = "10")String limit,
                                                        HttpServletRequest req) {
        Integer p=Integer.parseInt(page);
        Integer l=Integer.parseInt(limit);
        //使用分页插件
        PageHelper.startPage(p, l);
        List<CourseListDto> courseListDtos=studentBiz.selectCourseList(requestObject.getData(),this.getTenantId(req));
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
                                                                @RequestParam(defaultValue = "1") String  page ,
                                                                @RequestParam(defaultValue = "10")String limit,
                                                                HttpServletRequest req) {
        Integer p=Integer.parseInt(page);
        Integer l=Integer.parseInt(limit);
        //使用分页插件
        PageHelper.startPage(p, l);
        List<TopTeacherListDto> topTeacherListDtos=studentBiz.selectTopTeacherList(requestObject.getData(),this.getTenantId(req));
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
                                                            @RequestParam(defaultValue = "1") String  page ,
                                                            @RequestParam(defaultValue = "10")String limit,
                                                            HttpServletRequest req) {
        Integer p=Integer.parseInt(page);
        Integer l=Integer.parseInt(limit);
        //使用分页插件
        PageHelper.startPage(p, l);
        List<MyIndexCourseDto> myIndexCourseDtos=studentBiz.selectMyIndexCourse(requestObject.getData(),this.getTenantId(req));
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
    public ResultObject<List<MyIndexMessageDto>> myIndexMessage(HttpServletRequest req,MyIndexMessageParamter paramter,
                                                                @RequestParam(defaultValue = "1")String page,
                                                                @RequestParam(defaultValue = "10")String limit) {
        Integer p=Integer.parseInt(page);
        Integer l=Integer.parseInt(limit);
        PageHelper.startPage(p,l);
        List<MyIndexMessageDto> list=studentBiz.selectMyIndexMessage(paramter.getUid(),paramter.getTenant_id(),this.getTenantId(req));
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

    @Override
    @PostMapping("myIndexCourseAnswer")
    @ResponseBody
    public ResultObject<List<MyIndexCourseAnswerDto>> myIndexCourseAnswer(RequestObject<MyIndexCourseAnswerParameter> requestObject,
                                                                          @RequestParam(defaultValue = "1") String page,
                                                                          @RequestParam(defaultValue = "10") String limit,
                                                                          HttpServletRequest req) {
        Integer p=Integer.parseInt(page);
        Integer l=Integer.parseInt(limit);
        //使用分页插件
        PageHelper.startPage(p, l);
        List<MyIndexCourseAnswerDto> myIndexCourseAnswerDtos=studentBiz.selectMyIndexCourseAnswer(requestObject.getData(),this.getTenantId(req));
        PageInfo<MyIndexCourseAnswerDto> count=new PageInfo<>(myIndexCourseAnswerDtos);
        ResultObject<List<MyIndexCourseAnswerDto>> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setCount(count.getTotal());
        resultObject.setData(myIndexCourseAnswerDtos);
        return resultObject;
    }

}