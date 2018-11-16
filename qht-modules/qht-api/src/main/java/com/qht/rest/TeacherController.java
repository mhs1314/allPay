package com.qht.rest;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.IndexMyCourseDto;
import com.qht.dto.IndexMyCourseParameter;
import com.qht.dto.LoginInfoDto;
import com.qht.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qht.biz.TeacherBiz;
import com.qht.entity.Teacher;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController extends APIBaseController<TeacherBiz,Teacher> implements TeacherService {

    @Override
    public ResultObject<String> login(RequestObject<LoginInfoDto> rquest) {
        return null;
    }

    @Override
    @PostMapping("indexMyCourse")
    @ResponseBody
    public ResultObject<List<IndexMyCourseDto>> indexMyCourse(RequestObject<IndexMyCourseParameter> requestObject) {

        return null;
    }
}