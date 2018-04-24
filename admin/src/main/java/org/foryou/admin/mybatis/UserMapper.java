package org.foryou.admin.mybatis;

import org.apache.ibatis.annotations.Param;
import org.foryou.dao.ApiUserEntity;
import org.foryou.dao.Pageable;
import org.foryou.dao.QueryDate;

import java.util.List;

public interface UserMapper {
    int insertAll(@Param("users") List<ApiUserEntity> userEntities);

    List<ApiUserEntity> list(@Param("pageable") Pageable pageable, @Param("queryDate") QueryDate queryDate);

    Integer count(@Param("queryDate") QueryDate queryDate);
}
