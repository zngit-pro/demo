package org.foryou.admin.mapper;

import org.foryou.admin.vo.UserVo;
import org.foryou.dao.AdminUserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserVo getUserVo(AdminUserEntity userEntity);

    List<UserVo> getUserVos(List<AdminUserEntity> userEntities);
}
