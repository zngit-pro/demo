package org.foryou.jpa;

import org.foryou.dao.AdminUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminUserJpa extends JpaRepository<AdminUserEntity, Integer> {
    List<AdminUserEntity> findAll();

    AdminUserEntity save(AdminUserEntity adminUserEntity);
}
