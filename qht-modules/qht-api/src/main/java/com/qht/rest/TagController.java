package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.TagBiz;
import com.qht.entity.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TagController extends APIBaseController<TagBiz,Tag> {
	@Autowired
	private TagBiz tagBiz;

	//    /**
//     * 查看学生兴趣标签
//     * @param resultObject
//     * @return
//     */
//    @Override
//    @PostMapping("/student/app/myStudentInterest")
//    @ResponseBody
//    public ResultObject<List<TagDto>> myStudentInterest(ResultObject<AppStudentParameter> resultObject) {
//        List<TagDto> dto=tagBiz.appMyStudentInterest(resultObject.getData());
//        ResultObject< List<TagDto>> resultObj=new ResultObject<>();
//        resultObj.setCode("0");
//        resultObj.setMsg("成功");
//        resultObj.setData(dto);
//        return resultObj;
//    }

}