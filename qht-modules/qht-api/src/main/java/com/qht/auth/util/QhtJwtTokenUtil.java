package com.qht.auth.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.qht.auth.configuration.KeyConfiguration;

@Component
public class QhtJwtTokenUtil {
	
	@Value("${jwt.expire}")
	private int expire;
	@Autowired
	private KeyConfiguration keyConfiguration;
	
	
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String generateToken(QhtJWTInfo jwtInfo) throws Exception {
        return QhtJWTHelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(),expire);
    }

    public QhtJWTInfo getInfoFromToken(String token) throws Exception {
        return QhtJWTHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
    }
    
}
