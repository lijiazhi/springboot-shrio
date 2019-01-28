package com.dencycheng.demoshiro;

import com.dencycheng.shiro.CustormRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustormRealmTest {



	@Test
	public void contextLoads() {

		CustormRealm custormRealm = new CustormRealm();

		//1. 构建SecurityManager 环境
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(custormRealm);

		//2. 获得主体
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();

		//3. 认证（登录）
		UsernamePasswordToken token = new UsernamePasswordToken("dency","123456");
		subject.login(token);
		System.out.println("isAuthenticated:"+subject.isAuthenticated());

		//4. 登出
		//subject.logout();
		//System.out.println("isAuthenticated:"+subject.isAuthenticated());

		subject.checkRole("admin");

		subject.checkPermissions("user:add1","user:remove");
	}

}
