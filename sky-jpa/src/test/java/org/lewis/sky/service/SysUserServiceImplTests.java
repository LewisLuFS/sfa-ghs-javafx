package org.lewis.sky.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lewis.sky.MainApp;
import org.lewis.sky.security.domain.SysUser;
import org.lewis.sky.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MainApp.class)
public class SysUserServiceImplTests {

	@Autowired
	private SysUserService sysUserSrv;

	@Test
	public void save() {
		long count = this.sysUserSrv.findAll().size();

		SysUser sysUser = new SysUser("431520", "pwd", "Lewis", "431520@sfa.com", "13912345678");
		this.sysUserSrv.save(sysUser);
		
		assertEquals(count + 1, this.sysUserSrv.findAll().size());
	}

}
