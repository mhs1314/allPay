package com.qht.auth.util;

import org.joda.time.DateTime;
import com.github.wxiaoqi.security.auth.common.util.StringHelper;
import com.github.wxiaoqi.security.auth.common.util.jwt.RsaKeyHelper;
import com.qht.constant.CommonConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class QhtJWTHelper {
	private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();
    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(QhtJWTInfo jwtInfo, String priKeyPath, int expire) throws Exception {
        String compactJws = Jwts.builder()
        		.setSubject(jwtInfo.getUid())               
                .claim(CommonConstants.CONTEXT_KEY_TENANT_ID, jwtInfo.getTenantId())
                .claim(CommonConstants.CONTEXT_KEY_ACCOUNT, jwtInfo.getAccount())
                .claim(CommonConstants.CONTEXT_KEY_USERNAME, jwtInfo.getName())
                .claim(CommonConstants.CONTEXT_KEY_NICKNAME, jwtInfo.getNickname())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKeyPath))
                .compact();
        return compactJws;
    }

    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(QhtJWTInfo jwtInfo, byte priKey[], int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUid())               
                .claim(CommonConstants.CONTEXT_KEY_TENANT_ID, jwtInfo.getTenantId())
                .claim(CommonConstants.CONTEXT_KEY_ACCOUNT, jwtInfo.getAccount())
                .claim(CommonConstants.CONTEXT_KEY_USERNAME, jwtInfo.getName())
                .claim(CommonConstants.CONTEXT_KEY_NICKNAME, jwtInfo.getNickname())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
    }
    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
        return claimsJws;
    }
    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static QhtJWTInfo getInfoFromToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();       
        
        return new QhtJWTInfo(body.getSubject(), 
        		StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_TENANT_ID)),
        		StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_NICKNAME)),
        		StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_USERNAME)),
        		StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_ACCOUNT)));
    }
    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static QhtJWTInfo getInfoFromToken(String token, byte[] pubKey) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKey);
        Claims body = claimsJws.getBody();
        return new QhtJWTInfo(body.getSubject(),
        		StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_TENANT_ID)),
        		StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_NICKNAME)),
        		StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_USERNAME)),
        		StringHelper.getObjectValue(body.get(CommonConstants.CONTEXT_KEY_ACCOUNT)));
    }
}
