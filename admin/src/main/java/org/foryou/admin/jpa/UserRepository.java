package org.foryou.admin.jpa;

import org.foryou.dao.ApiUserEntity;

import java.util.List;

public interface UserRepository extends CustomRepository<ApiUserEntity, Integer> {

    List<ApiUserEntity> findAll();

    ApiUserEntity save(ApiUserEntity apiUserEntity);

    ApiUserEntity findByAccount(String account);
}
