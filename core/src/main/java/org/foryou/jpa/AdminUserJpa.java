package org.foryou.jpa;

import org.foryou.dao.AdminUserEntity;

import java.util.List;

public interface AdminUserJpa extends CustomRepository<AdminUserEntity, Integer> {

    List<AdminUserEntity> findAll();

    AdminUserEntity save(AdminUserEntity adminUserEntity);

    AdminUserEntity findByAccount(String account);
}
