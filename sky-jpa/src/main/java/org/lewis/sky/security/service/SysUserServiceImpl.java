package org.lewis.sky.security.service;

import java.util.List;

import org.lewis.sky.security.domain.SysUser;
import org.lewis.sky.security.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserRepository sysUserRepository;

	@Override
	public List<SysUser> findAll() {
		return this.sysUserRepository.findAll();
	}

	@Override
	public SysUser save(SysUser entity) {
		return this.sysUserRepository.save(entity);
	}

	@Override
	public void delete(SysUser entity) {
		this.sysUserRepository.delete(entity);
	}

}
