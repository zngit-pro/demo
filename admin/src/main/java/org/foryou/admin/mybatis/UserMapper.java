package org.foryou.admin.mybatis;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.foryou.dao.AdminUserEntity;

import java.util.List;

public interface UserMapper {
    int insertAll(@Param("users") List<AdminUserEntity> userEntities);

    Page<AdminUserEntity> list(@Param("page") int page);
}
