package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.CollectBiz;
import com.qht.biz.CoursePkgBiz;
import com.qht.biz.PeriodBiz;
import com.qht.biz.StudentBiz;
import com.qht.biz.TeacherBiz;
import com.qht.common.util.BeanUtil;
import com.qht.common.util.IdGenUtil;
import com.qht.dto.*;
import com.qht.dto.CourseChapterDto;
import com.qht.entity.Student;
import com.qht.model.*;
import com.qht.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
    private CoursePkgBiz coursePkgBiz;
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
    public ResultObject<List<BannerDto>> banner(@RequestBody RequestObject<UidAndTenantID> requestObject) {
        System.out.println("===================================tenant_id="+requestObject.getData().getTenant_id());
        ResultObject<List<BannerDto>> resultObject=new ResultObject<>();
        if(StringUtil.isEmpty(requestObject.getData().getTenant_id())){
            return resultObject.setMsg("参数不能为空");
        }
        List<BannerModel> list=studentBiz.selectBanner(requestObject.getData().getTenant_id(),"1");
        List<BannerDto> lists = BeanUtil.copyList(BannerDto.class, list);

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
    @PostMapping("teacherRanking")
    @ResponseBody
    public ResultObject<List<TeacherRankingDto>> teacherRanking(@RequestBody RequestObject<UidAndTenantID> requestObject) {
        //查询
        List<TeacherRankingModel> list=teacherBiz.selectTeacherRanking(requestObject.getData().getTenant_id());
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
        List<TeacherListModel> list=teacherBiz.selectTeacherList(param);
       List<TeacherListDto> lists = BeanUtil.copyList(TeacherListDto.class, list);
        ResultObject<List<TeacherListDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(lists);
        return resultObject;
    }

    @Override
    @PostMapping("courseEvaluation")
    @ResponseBody
    public ResultObject<List<CourseEvaluationDto>> courseEvaluation(@RequestBody RequestObject<CourseEvaluationParameter> requestObject) {
        ResultObject<List<CourseEvaluationDto>> resultObject=new ResultObject<>();
        CourseEvaluationParam param=new CourseEvaluationParam();
        if(requestObject.getData()==null){
            return resultObject.setMsg("没有参数");
        }
        BeanUtil.copyFields(param, requestObject.getData());
        if(StringUtil.isEmpty(requestObject.getData().getEval())){
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
            resultObject.setCount_bad(courseEvaluationDtosBad.size());
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
        TeacherInfoModel teacherInfoModel=teacherBiz.selectTeacherInfo2(param.getUid(),param.getTenant_id());
        TeacherInfoDto dto=new TeacherInfoDto();
        BeanUtil.copyFields(dto, teacherInfoModel);
        ResultObject<TeacherInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
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
        List<TopTeacherListModel> topTeacherListDtos=teacherBiz.selectTopTeacherList(param);
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
        TopTeacherInfoModel topTeacherInfoDtos= teacherBiz.selectTopTeacherInfo(param.getUid(),param.getTenant_id());
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
        List<GuardianDto> guardianDtos = new ArrayList<>();
        for(int i=0;i<model.getGua().size();i++){
            GuardianDto guardianDto = new GuardianDto();
            BeanUtil.copyFields(guardianDto,model.getGua().get(i));
            guardianDtos.add(guardianDto);
        }
        dto.setGuardian(guardianDtos);
        ResultObject<StudentInfoDto> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(dto);
        return resultObject;
    }
    @Override
    @PostMapping("/app/indexTeacher")
    @ResponseBody
    public ResultObject<List<IndexTeacherDto>> indexTeacher(@RequestBody RequestObject<UidAndTenantID> req) {
        List<IndexTeacherModel> dto=teacherBiz.indexTeacher(req.getData().getTenant_id());
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
        List<IndexTeacherListModel> dto=teacherBiz.indexTeacherList(param);
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
    @PostMapping("myIndexCancelcollect")
    @ResponseBody
    public ResultObject<Void> myIndexCancelcollect(@RequestBody RequestObject<MyIndexCanceCollectParameter> requestObject) {
        ResultObject<Void> resultObject=new ResultObject<>();
    	MyIndexCanceCollectParam param=new MyIndexCanceCollectParam();
        if(requestObject.getData()==null){
            resultObject.setMsg("失败");
            resultObject.setCode("1");
            return resultObject;
        }
        BeanUtil.copyFields(param, requestObject.getData());
        Integer updateLine=studentBiz.updateMyIndexCancelcollect(param);
        if(updateLine<1){
            resultObject.setMsg("取消失败");
            resultObject.setCode("1");
            return resultObject;
        }
        resultObject.setCode("0");
        resultObject.setMsg("取消成功");
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
    	System.out.println(requestObject.getData());
    	
    	BeanUtil.copyFields(param, requestObject.getData());
    	System.out.println(param);
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
    @PostMapping("/app/indexAnswerDetailsExceptional")
    @ResponseBody
    public ResultObject<Void> indexAnswerDetailsExceptional(@RequestBody RequestObject<IndexAnswerDetailsExceptionalParameter> requestObject) {
    	if(requestObject.getData()==null) {
    		ResultObject<Void> r=new ResultObject<>();
            r.setCode("1");
            r.setMsg("没有参数"); 
            return r;
    	}
        ResultObject<Void> resultObject=new ResultObject<>();
        //先检测问题的type是否被解决
        Integer type=studentBiz.selectAnswerType(requestObject.getData().getAnswer_id());
        if(type==1){
            return resultObject.setMsg("该问题为解决，不能打赏");
        }
        //在判断学生的积分余额
        Integer balance=studentBiz.selectStudentBalance(requestObject.getData().getStudent_id());
        if(balance==null||balance<requestObject.getData().getValue()){
        			resultObject.setCode("1");
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
    /***
     * 收藏课程
     */
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
	@Override
	@PostMapping("myIndexCourseCelcollect")
    @ResponseBody
	public ResultObject<Void> myIndexCourseCelcollect(@RequestBody RequestObject<MyIndexCourseCelcollectParameter> requestObject) {
		ResultObject<Void> resultObject=new ResultObject<>();
		if(requestObject.getData()==null) {
			return resultObject.setMsg("失败");
		}
		MyIndexCourseCelcollectParam param=new MyIndexCourseCelcollectParam();
		BeanUtil.copyFields(param, requestObject.getData());
		//收藏 插入数据需要生成一个collect表的主键
        String collect="IN";
        String id=IdGenUtil.getUid(collect);
		param.setId(id);
		Integer deleteLine=collectBiz.insertMyIndexCourseCelcollect(param);
		if(deleteLine<1){
            resultObject.setCode("1");
            resultObject.setMsg("失败");
            return resultObject;
        }
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		return resultObject;
	}

	@Override
    @PostMapping("app/myStudentCourseManagement")
    @ResponseBody
	public ResultObject<List<SelectPkgByStuIdDto>> selectPkgByStuId(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
    	if(requestObject.getData()==null) {
    		  ResultObject<List<SelectPkgByStuIdDto>> resultObject=new ResultObject<>();
    	        resultObject.setCode("1");
    	        resultObject.setMsg("参数不对");
    	        resultObject.setData(new ArrayList<>());
    	        return resultObject;
    	}
    	BeanUtil.copyFields(param, requestObject.getData());
        List<SelectPkgByStuIdModel> dto=coursePkgBiz.selectPkgByStuId(param);
        if(dto.size()==0) {
        	 ResultObject<List<SelectPkgByStuIdDto>> resultObject=new ResultObject<>();
             resultObject.setCode("0");
             resultObject.setMsg("没有数据");
             resultObject.setData(new ArrayList<>());
             return resultObject;
        }
        List<SelectPkgByStuIdDto> list = BeanUtil.copyList(SelectPkgByStuIdDto.class, dto);
        ResultObject<List<SelectPkgByStuIdDto>> resultObject=new ResultObject<>();
        resultObject.setCode("0");
        resultObject.setMsg("成功");
        resultObject.setData(list);
        return resultObject;
	}

	// 查询学生是否绑定监护人
	@Override
    @PostMapping("app/findStudent")
    @ResponseBody
    public ResultObject<Void> findStudent(@RequestBody RequestObject<AppStudentParameter> resultObject){
		
		
		
		return resultObject;
	}


}