
package com.qht.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.qht.biz.CollectBiz;
import com.qht.biz.StudentBiz;
import com.qht.biz.TeacherBiz;
import com.qht.dto.AppMyStudentInfoDto;
import com.qht.dto.AppTeacherCourseDto;
import com.qht.dto.AppTeacherEvaluationDto;
import com.qht.dto.BannerDto;
import com.qht.dto.CourseChapterDto;
import com.qht.dto.CourseEvaluationDto;
import com.qht.dto.CourseIntroDto;
import com.qht.dto.CourseIntroParameter;
import com.qht.dto.CourseListDto;
import com.qht.dto.CourseListParameter;
import com.qht.dto.FreeClassDto;
import com.qht.dto.FreeClassParameter;
import com.qht.dto.IndexAnswerDetailsAppendAnswerParameter;
import com.qht.dto.IndexAnswerDetailsDto;
import com.qht.dto.IndexAnswerDetailsExceptionalParameter;
import com.qht.dto.IndexAnswerDto;
import com.qht.dto.IndexCoruseListDto;
import com.qht.dto.IndexCoruseListParameter;
import com.qht.dto.IndexCourseDetailsDto;
import com.qht.dto.IndexFutureCoruseDto;
import com.qht.dto.IndexMyAnswerDto;
import com.qht.dto.IndexTeacherDto;
import com.qht.dto.IndexTeacherListDto;
import com.qht.dto.IndexTeacherListParameter;
import com.qht.dto.ListeningClassListDto;
import com.qht.dto.ListeningClassRankingDto;
import com.qht.dto.LiveClassDto;
import com.qht.dto.LoginInfoDto;
import com.qht.dto.MyCollectlistDto;
import com.qht.dto.MyIndexBuyRecordCourseBackDto;
import com.qht.dto.MyIndexBuyRecordCourseBackParameter;
import com.qht.dto.MyIndexBuyRecordCourseDetailsDto;
import com.qht.dto.MyIndexBuyRecordDto;
import com.qht.dto.MyIndexBuyRecordParameter;
import com.qht.dto.MyIndexCourseAnswerDto;
import com.qht.dto.MyIndexCourseAnswerParameter;
import com.qht.dto.MyIndexCourseDto;
import com.qht.dto.MyIndexCourseParameter;
import com.qht.dto.MyIndexMessageDto;
import com.qht.dto.MyIndexMessageParamter;
import com.qht.dto.MyIndexMycollectDto;
import com.qht.dto.MyIndexMycollectParameter;
import com.qht.dto.MyIndexMyintegralDetailDto;
import com.qht.dto.MyIndexMyintegralDetailParameter;
import com.qht.dto.StudentDto;
import com.qht.dto.StudentInfoDto;
import com.qht.dto.TeacherCourseDto;
import com.qht.dto.TeacherDetailsDto;
import com.qht.dto.TeacherDto;
import com.qht.dto.TeacherEvaluationDto;
import com.qht.dto.TeacherInfoDto;
import com.qht.dto.TeacherListDto;
import com.qht.dto.TeacherRankingDto;
import com.qht.dto.TenantAlbumDto;
import com.qht.dto.TenantSchoolDto;
import com.qht.dto.TopTeacherInfoDto;
import com.qht.dto.TopTeacherListDto;
import com.qht.dto.TopTeacherListParameter;
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
    /**
     * 得到tenantId
     * @return
     */
    public String getTenant_id(){
        String tenant_id=null;
        TeacherDto studentDto=(TeacherDto)request.getSession().getAttribute("user_session_key");
        if (studentDto!=null){
            tenant_id=studentDto.getTenant_id();
        }
        return tenant_id == null ? "11": tenant_id;
    }

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
        List<BannerDto> list=studentBiz.selectBanner(getTenant_id(),"1");
        ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
        resultObject.setData(list);
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        return resultObject;
    }
    @Override
    @PostMapping("/app/indexBanner")
    @ResponseBody
    public ResultObject<List<BannerDto>> indexBanner(@RequestBody RequestObject<Void> requestObject) {
        //通过session取到运营的id

        List<BannerDto> list=studentBiz.selectBanner("11","2");
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
        List<LiveClassDto> list=studentBiz.selectLiveClass(getTenant_id());
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
        List<ListeningClassRankingDto> list=studentBiz.selectListeningClassRanking(getTenant_id());
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
        List<ListeningClassListDto> list=studentBiz.selectListeningClassList(getTenant_id());
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
        List<TeacherRankingDto> list=studentBiz.selectTeacherRanking(getTenant_id());
        ResultObject<List<TeacherRankingDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
    }

    @Override
    @GetMapping("teacherList")
    @ResponseBody
    public ResultObject<List<TeacherListDto>> teacherList(@RequestBody RequestObject<Void> requestObject) {
        //查询
        List<TeacherListDto> list=studentBiz.selectTeacherList(getTenant_id());
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
        CourseIntroDto courseIntroDto=studentBiz.selectCourseIntro(requestObject.getData().getUid(),getTenant_id());
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
        List<CourseChapterDto> courseChapterDtos=studentBiz.selectCourseChapter(requestObject.getData().getUid(),getTenant_id());
        ResultObject<List<CourseChapterDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(courseChapterDtos);
        return resultObject;
    }

    @Override
    @PostMapping("courseEvaluation")
    @ResponseBody
    public ResultObject<List<CourseEvaluationDto>> courseEvaluation(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
        List<CourseEvaluationDto> courseEvaluationDtos=studentBiz.selectCourseEvaluation(requestObject.getData().getUid(),getTenant_id());
        ResultObject<List<CourseEvaluationDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(courseEvaluationDtos);
        return resultObject;
    }

    @Override
    @PostMapping("teacherInfo")
    @ResponseBody
    public ResultObject<TeacherInfoDto> teacherInfo(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
        TeacherInfoDto teacherInfoDto=studentBiz.selectTeacherInfo(requestObject.getData().getUid(),getTenant_id());
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
        requestObject.getData().setTenant_id(getTenant_id());
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
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()), Integer.parseInt(requestObject.getData().getLimit()));
        requestObject.getData().setTenant_id(getTenant_id());
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
    public ResultObject<List<TopTeacherInfoDto>> topTeacherInfo(@RequestBody RequestObject<String> request) {
        List<TopTeacherInfoDto> topTeacherInfoDtos=studentBiz.selectTopTeacherInfo(request.getData(),getTenant_id());
        ResultObject<List<TopTeacherInfoDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(topTeacherInfoDtos);
        return resultObject;
    }

    @Override
    @PostMapping("teacherCourse")
    @ResponseBody
    public ResultObject<List<TeacherCourseDto>> teacherCourse(@RequestBody RequestObject<String> request) {
        List<TeacherCourseDto> teacherCourseDtos=studentBiz.selectTeacherCourse(request.getData(),getTenant_id());
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
    public ResultObject<List<TeacherEvaluationDto>> teacherEvaluation(@RequestBody RequestObject<String> request) {
        List<TeacherEvaluationDto> teacherEvaluationDtos=studentBiz.selectTeacherEvaluation(request.getData(),getTenant_id());
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
        TenantSchoolDto tenantSchoolDto=studentBiz.selectTenantSchool(getTenant_id());
        ResultObject<TenantSchoolDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(tenantSchoolDto);
        return resultObject;
    }

    @Override
    @PostMapping("tenantAlbum")
    @ResponseBody
    public ResultObject<TenantAlbumDto> tenantAlbum(@RequestBody RequestObject<Void> requestObject) {
        TenantAlbumDto tenantAlbumDto=studentBiz.selectTenantAlbum(getTenant_id());
        ResultObject<TenantAlbumDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(tenantAlbumDto);
        return resultObject;
    }

    @Override
    @PostMapping("myIndexCourse")
    @ResponseBody
    public ResultObject<List<MyIndexCourseDto>> myIndexCourse(@RequestBody RequestObject<MyIndexCourseParameter> requestObject) {
        //使用分页插件
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()), Integer.parseInt(requestObject.getData().getLimit()));
        requestObject.getData().setTenant_id(getTenant_id());
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
    public ResultObject<List<IndexCourseDetailsDto>> indexCourseDetails(@RequestBody RequestObject<String> req) {
        List<IndexCourseDetailsDto> indexCourseDetailsDtos=studentBiz.selectIndexCourseDetails(req.getData(),getTenant_id());
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
        paramter.getData().setIsread(getTenant_id());
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
    public ResultObject<Void> deleteMessage(String uid) {
        ResultObject<Void> resultObject=new ResultObject<>();
        if(studentBiz.deleteMessage(uid)>0){
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
    public ResultObject<MyIndexMessageDto> selectMessageById(String uid) {
        MyIndexMessageDto dto=studentBiz.selectMessageById(uid);
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
        requestObject.getData().setTenant_id(getTenant_id());
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
    public ResultObject<StudentInfoDto> studentInfo(HttpServletRequest reg,String uid,String tid) {
        StudentInfoDto dto=studentBiz.studentInfo(uid,getTenant_id());
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
        parameter.getData().setTenant_id(getTenant_id());
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
        requestObject.getData().setTenant_id(getTenant_id());
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
    public ResultObject<List<IndexFutureCoruseDto>> indexFutureCoruse(@RequestBody RequestObject<String> req) {
        List<IndexFutureCoruseDto> dto=studentBiz.indexFutureCoruse(req.getData(),getTenant_id());
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
        List<IndexTeacherDto> dto=studentBiz.indexTeacher(getTenant_id());
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
        List<IndexAnswerDto> dto=studentBiz.indexAnswer(getTenant_id());
        ResultObject<List<IndexAnswerDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return  resultObject;
    }

    @Override
    @PostMapping("/app/indexCoruseList")
    @ResponseBody
    public ResultObject<List<IndexCoruseListDto>> indexCoruseList(@RequestBody RequestObject<IndexCoruseListParameter> parameter) {
        parameter.getData().setTenant_id(getTenant_id());
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
        //parameter.getData().setTenant_id(getTenantId());
    	IndexTeacherListParameter para = new IndexTeacherListParameter();
    	para.setTid("11");
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
    public ResultObject<List<MyIndexBuyRecordCourseDetailsDto>> myIndexBuyRecordCourseDetails(@RequestBody RequestObject<String> req) {
        List<MyIndexBuyRecordCourseDetailsDto> myIndexBuyRecordCourseDetailsDtos=studentBiz.selectMyIndexBuyRecordDetails(req.getData());
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
        requestObject.getData().setTenant_id(getTenant_id());
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
        requestObject.getData().setTenant_id(getTenant_id());
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
    public ResultObject<Void> myIndexCancelcollect(@RequestBody RequestObject<StudentDto> requestObject) {
        ResultObject<Void> resultObject=new ResultObject<>();
        String uid = requestObject.getData().getUid();
        String student_id = requestObject.getData().getStudentId();
        Integer updateLine=studentBiz.updateMyIndexCancelcollect(uid,student_id,getTenant_id());
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
    public ResultObject<List<IndexMyAnswerDto>> indexMyAnswer(@RequestBody RequestObject<String> requestObject) {
        List<IndexMyAnswerDto> indexMyAnswerDtos=studentBiz.selectIndexMyAnswer(requestObject.getData(),getTenant_id());
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
    public ResultObject<TeacherDetailsDto> teacherDetails(@RequestBody RequestObject<String> requestObject) {
        TeacherDetailsDto teacherDetailsDto=teacherBiz.teacherDetails(requestObject.getData(),getTenant_id());
        ResultObject<TeacherDetailsDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(teacherDetailsDto);
        return resultObject;
    }

    @Override
    @PostMapping("/app/indexAnswerDetails")
    @ResponseBody
    public ResultObject<IndexAnswerDetailsDto> indexAnswerDetails(@RequestBody RequestObject<String> requestObject){
        IndexAnswerDetailsDto indexAnswerDetailsDto=studentBiz.selectIndexAnswerDetails(requestObject.getData(),getTenant_id());
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
    public ResultObject<List<AppTeacherCourseDto>> appTeacherCourse(@RequestBody RequestObject<String> requestObject) {
        List<AppTeacherCourseDto> dto=teacherBiz.appTeacherCourseDto(requestObject.getData(),getTenant_id());
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
        List<AppTeacherEvaluationDto> dto=teacherBiz.teacherEvaluation(requestObject.getData().getUid(),getTenant_id(),requestObject.getData().getEval());
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
        requestObject.getData().setTanant_id(getTenant_id());
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
    public ResultObject<List<MyCollectlistDto>> myCollectlist(@RequestBody RequestObject<String> requestObject) {
        List<MyCollectlistDto> dto=collectBiz.myCollectlist(requestObject.getData(),getTenant_id());
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
    public ResultObject<AppMyStudentInfoDto> appMyStudentInfo(@RequestBody RequestObject<String> requestObject) {
        AppMyStudentInfoDto dto=studentBiz.appMyStudentInfo(requestObject.getData(),getTenant_id());
        ResultObject<AppMyStudentInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("1");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }
}