package org.foryou.admin.converter;

import com.github.pagehelper.PageInfo;
import org.foryou.admin.vo.UserVo;
import org.foryou.dao.AdminUserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BooleanConverter.class, DateConverter.class})
public interface UserConverter {

    UserVo getUserVo(AdminUserEntity userEntity);

    AdminUserEntity getAdminUserEntity(UserVo userVo);

    List<UserVo> getUserVos(List<AdminUserEntity> userEntities);

    PageInfo<UserVo> getUserVos(PageInfo<AdminUserEntity> userEntities);

    List<AdminUserEntity> getAdminUserEntitys(List<UserVo> userEntities);
}
