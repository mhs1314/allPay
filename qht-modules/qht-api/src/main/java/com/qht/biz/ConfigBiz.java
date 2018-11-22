package com.qht.biz;

import org.springframework.stereotype.Service;

import com.qht.entity.Config;
import com.qht.mapper.ConfigMapper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;

/**
 * 配置表,1
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-22 20:08:16
 */
@Service
public class ConfigBiz extends BaseBiz<ConfigMapper,Config> {
	
	public Config getConfig(String uid) {
		Config cfg = selectById(uid);
		if(cfg == null) {
			throw new RuntimeException("需要配置密钥");
		}
		return cfg;
	}
}