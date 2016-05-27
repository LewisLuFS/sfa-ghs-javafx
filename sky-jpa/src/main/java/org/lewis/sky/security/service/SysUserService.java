package org.lewis.sky.security.service;

import java.util.List;

import org.lewis.sky.security.domain.SysUser;

public interface SysUserService {

	public List<SysUser> findAll();

	public SysUser save(SysUser entity);

	public void delete(SysUser entity);
	
	public void deleteAll();
}
