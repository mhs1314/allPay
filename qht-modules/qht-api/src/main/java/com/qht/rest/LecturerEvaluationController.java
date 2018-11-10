package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.LecturerEvaluationBiz;
import com.qht.entity.LecturerEvaluation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("lecturerEvaluation")
public class LecturerEvaluationController extends APIBaseController<LecturerEvaluationBiz,LecturerEvaluation> {

}