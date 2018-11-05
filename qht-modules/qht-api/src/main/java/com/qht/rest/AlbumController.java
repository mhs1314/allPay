package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.AlbumBiz;
import com.qht.entity.Album;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("album")
public class AlbumController extends BaseController<AlbumBiz,Album> {

}