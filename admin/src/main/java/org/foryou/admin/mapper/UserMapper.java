package org.foryou.admin.mapper;

import org.foryou.admin.vo.UserVo;
import org.foryou.dao.AdminUserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BooleanMapper.class, DateMapper.class})
public interface UserMapper {

    UserVo getUserVo(AdminUserEntity userEntity);

    AdminUserEntity getAdminUserEntity(UserVo userVo);

    List<UserVo> getUserVos(List<AdminUserEntity> userEntities);
}
