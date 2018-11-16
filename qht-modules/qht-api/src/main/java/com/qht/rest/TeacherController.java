package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.*;
import com.qht.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qht.biz.TeacherBiz;
import com.qht.entity.Teacher;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("teacher")
public class TeacherController extends APIBaseController<TeacherBiz,Teacher> implements TeacherService {
    @Autowired
    private TeacherBiz teacherBiz;

    @Override
    public ResultObject<String> login(RequestObject<LoginInfoDto> rquest) {
        return null;
    }

    @Override
    @PostMapping("indexMyCourse")
    @ResponseBody
    public ResultObject<List<IndexMyCourseDto>> indexMyCourse(RequestObject<IndexMyCourseParameter> requestObject) {
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
        List<IndexMyCourseDto> indexMyCourseDtos=teacherBiz.selectIndexMyCourseDto(requestObject.getData());
        PageInfo<IndexMyCourseDto> count=new PageInfo<>(indexMyCourseDtos);
        ResultObject<List<IndexMyCourseDto>> resultObject=new ResultObject<>();
        resultObject.setData(indexMyCourseDtos);
        resultObject.setMsg("成功");
        resultObject.setCode("0");
        resultObject.setCount(count.getTotal());
        return resultObject;
    }

    @Override
    @PostMapping("indexMyCourseList")
    @ResponseBody
    public ResultObject<List<IndexMyCourseListDto>> indexMyCourseList(RequestObject<IndexMyCourseListParameter> requestObject) {
        PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
        List<IndexMyCourseListDto> indexMyCourseListDtos=teacherBiz.selectIndexMyCourseList(requestObject.getData());
        PageInfo<IndexMyCourseListDto> count=new PageInfo<>(indexMyCourseListDtos);
        ResultObject<List<IndexMyCourseListDto>> resultObject=new ResultObject<>();
        resultObject.setData(indexMyCourseListDtos);
        resultObject.setMsg("成功");
        resultObject.setCode("0");
        resultObject.setCount(count.getTotal());
        return resultObject;
    }

    @Override
    @PostMapping("indexAddLcourse")
    @ResponseBody
    public ResultObject<Void> indexAddLcourse(RequestObject<IndexAddLcourseParameter> requestObject) {
        ResultObject<Void> resultObject=new ResultObject<>();
        //插入数据需要生成uid
        String uid="course_pkg"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        requestObject.getData().setUid(uid);
        Integer indexAddcourseLine=teacherBiz.insertIndexAddLcourse(requestObject.getData());
        if(indexAddcourseLine!=1){
            resultObject.setCode("1");
            resultObject.setMsg("课程包创建失败");
            return resultObject;
        }
        if(requestObject.getData().getPeriod_name()!=null){
            String chapter_uid="chapter"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            requestObject.getData().setChapter_uid(chapter_uid);
            Integer insertChapterLine=teacherBiz.insertChapter(requestObject.getData());
            if(insertChapterLine!=1){
                resultObject.setCode("1");
                resultObject.setMsg("章节创建失败");
                return resultObject;
            }
        }
        if (requestObject.getData().getPeriod_name()!=null){
            String period_uid="period"+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            requestObject.getData().setPeriod_uid(period_uid);
            Integer insertPeriodLine=teacherBiz.insertPeriod(requestObject.getData());
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


}