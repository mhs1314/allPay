package com.qht;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.qht.baidu.uid.impl.CachedUidGenerator;
import com.qht.baidu.uid.impl.DefaultUidGenerator;
import com.qht.baidu.uid.worker.DisposableWorkerIdAssigner;
import com.qht.baidu.uid.worker.WorkerIdAssigner;
import com.qht.meituan.idleaf.IdLeafService;
import com.qht.meituan.idleaf.support.MysqlIdLeafServiceImpl;

@EnableTransactionManagement
@SpringBootApplication
public class UidGeneratorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UidGeneratorDemoApplication.class, args);
	}

	@Autowired
	private WorkerIdAssigner workerIdAssigner;

	@Bean
	public DefaultUidGenerator defaultUidGenerator() {
        DefaultUidGenerator defaultUidGenerator = new DefaultUidGenerator();
        defaultUidGenerator.setWorkerIdAssigner(workerIdAssigner);
        defaultUidGenerator.setTimeBits(29);
        defaultUidGenerator.setWorkerBits(21);
        defaultUidGenerator.setSeqBits(13);
        defaultUidGenerator.setEpochStr("2018-07-21");
	    return defaultUidGenerator;
    }

    @Bean
    public DisposableWorkerIdAssigner disposableWorkerIdAssigner() {
	    return new DisposableWorkerIdAssigner();
    }

    @Bean
    public CachedUidGenerator cachedUidGenerator() {
        CachedUidGenerator cachedUidGenerator = new CachedUidGenerator();
        cachedUidGenerator.setWorkerIdAssigner(workerIdAssigner);
        cachedUidGenerator.setTimeBits(29);
        cachedUidGenerator.setWorkerBits(21);
        cachedUidGenerator.setSeqBits(13);
        cachedUidGenerator.setEpochStr("2018-07-21");
        return cachedUidGenerator;
    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Bean(initMethod = "init")
    public IdLeafService idLeafService() {
        MysqlIdLeafServiceImpl mysqlIdLeafService = new MysqlIdLeafServiceImpl();
        mysqlIdLeafService.setJdbcTemplate(jdbcTemplate);
        mysqlIdLeafService.setAsynLoadingSegment(true);
        mysqlIdLeafService.setBizTag("Order");
        return mysqlIdLeafService;
    }
}
