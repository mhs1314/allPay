package com.qht.rest;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qht.baidu.uid.impl.CachedUidGenerator;
import com.qht.baidu.uid.impl.DefaultUidGenerator;
import com.qht.meituan.idleaf.IdLeafService;
import com.qht.util.StringUtil;



@RestController
@RequestMapping("uid")
public class UidController {
	
	@Autowired
    @Qualifier("defaultUidGenerator")
	private DefaultUidGenerator defaultUidGenerator;

	@Autowired
    @Qualifier("cachedUidGenerator")
	private CachedUidGenerator cachedUidGenerator;

	@Autowired
	private IdLeafService idLeafService;
	
	@RequestMapping(value="/defaultKey", method= RequestMethod.GET)
	public String defaultKey() {
		long uid = defaultUidGenerator.getUID();
		System.out.println(uid);
       // System.out.println(defaultUidGenerator.parseUID(uid));
		return defaultUidGenerator.parseUID(uid);
	}

	@RequestMapping(value="/cachedKey", method= RequestMethod.GET)
    public String cachedUidGenerator() {
        long uid = cachedUidGenerator.getUID();
        System.out.println(uid);
        //System.out.println(cachedUidGenerator.parseUID(uid));
        return cachedUidGenerator.parseUID(uid);
    }

    @RequestMapping(value="/idLeafKey", method= RequestMethod.POST)
    public String idLeafKey(@RequestBody RequestObject<String> requestObject) {    	
    	if(requestObject == null) {
    		return "{table为空}";
    	}
    	String table = requestObject.getData();
    	if(StringUtil.isEmpty(table)) {
    		return "table为空";
    	}    	
        Long id = idLeafService.getId();
        System.out.println(id);
        String shopId = table;
        String date = currentDte();
        long ts = System.currentTimeMillis();
        String orderSN = shopId + date + ts + id;
        System.out.println(orderSN);
        return orderSN;
    }  
    private String currentDte() {
    	LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String nowStr = now .format(format);
        return nowStr;
    }
    public static void main(String[] args) {
    	LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        String nowStr = now .format(format);
        System.out.println(nowStr);

    }
	
    
}
