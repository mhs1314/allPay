package com.qht;

import java.util.UUID;

/**
 * 请求对象构造器
 * @author 草原狼
 * @date Jul 11, 2018 3:21:19 PM
 */
public class RequestBuilder {
	public static <T> RequestObject<T> build(T data) {
		String uuid = UUID.randomUUID().toString();
        return new RequestObject<T>(uuid, data);
    }

    public static <T> RequestObject<T> build(String requestId,T data) {
        return new RequestObject<T>(requestId,data);
    }
    

}
