package org.lewis.sky.security.repository;

import org.lewis.sky.security.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

}
