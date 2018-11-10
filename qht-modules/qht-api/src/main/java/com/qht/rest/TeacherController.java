package com.qht.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qht.biz.TeacherBiz;
import com.qht.entity.Teacher;

@Controller
@RequestMapping("teacher")
public class TeacherController extends APIBaseController<TeacherBiz,Teacher> {

}