package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.IndexMyCourseDto;
import com.qht.dto.IndexMyCourseParameter;
import com.qht.dto.LoginInfoDto;
import com.qht.services.TeacherService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qht.biz.TeacherBiz;
import com.qht.entity.Teacher;
import com.qht.model.IndexMyCourseModel;
import com.qht.model.IndexMyCourseParam;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
        IndexMyCourseParam param=new IndexMyCourseParam();
        BeanUtils.copyProperties(param, requestObject.getData());
        List<IndexMyCourseModel> models=teacherBiz.selectIndexMyCourseDto(param);
        List<IndexMyCourseDto> indexMyCourseDtos=new ArrayList<>();
        
        
        PageInfo<IndexMyCourseDto> count=new PageInfo<>(indexMyCourseDtos);
        ResultObject<List<IndexMyCourseDto>> resultObject=new ResultObject<>();
        resultObject.setData(indexMyCourseDtos);
        resultObject.setMsg("成功");
        resultObject.setCode("0");
        resultObject.setCount(count.getTotal());
        return resultObject;
    }
}