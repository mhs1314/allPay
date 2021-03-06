package com.qht.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.github.wxiaoqi.security.common.context.BaseContextHandler;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.github.wxiaoqi.security.common.msg.TableResultResponse;

import com.github.wxiaoqi.security.common.util.Query;
import com.qht.auth.util.RequestContextUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class APIBaseController <Biz extends BaseBiz,Entity>{
	 @Autowired
	    protected HttpServletRequest request;
	    @Autowired
	    protected Biz baseBiz;	    

	    public HttpServletRequest getRequest() {
	    	return request;
	    }

	    /*
	    

	    /**

	     * 得到tenant_id
	     * @return
	     *
	     *  */
	    public String getTenantId(){
	    	/*
	        String tenant_id=null;
	        TeacherDto studentDto=(TeacherDto)request.getSession().getAttribute("user_session_key");
	        if (studentDto!=null){
	            tenant_id=studentDto.getTenant_id();
	        }
	        return tenant_id == null ? "11": tenant_id;
	        */    	
	    	return RequestContextUtil.getTenantId();
	    }

	   
}
