package com.qht.biz;

import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Tag;
import com.qht.mapper.TagMapper;

/**
 * 标签表
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class TagBiz extends BaseBiz<TagMapper,Tag> {
}