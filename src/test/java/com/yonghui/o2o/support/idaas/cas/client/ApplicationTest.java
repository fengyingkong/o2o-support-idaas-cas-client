package com.yonghui.o2o.support.idaas.cas.client;

import com.yonghui.o2o.support.idaas.cas.client.server.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;



@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootO2oSupportIdaasCasClientApplication.class)
public class ApplicationTest {

	@Resource
	private DemoService demoService;
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testDemo() {
		Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("test", "hello world");
		System.out.println(aBoolean);
	}



}

