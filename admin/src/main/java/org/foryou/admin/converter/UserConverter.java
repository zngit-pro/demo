package org.foryou.admin.converter;

import org.foryou.admin.vo.UserVo;
import org.foryou.dao.ApiUserEntity;
import org.foryou.dao.Page;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BooleanConverter.class, DateConverter.class})
public interface UserConverter {

    UserVo getUserVo(ApiUserEntity apiUserEntity);

    ApiUserEntity getUserEntity(UserVo userVo);

    List<UserVo> getUserVos(List<ApiUserEntity> userEntities);

    Page<UserVo> getUserVos(Page<ApiUserEntity> userEntities);

    List<ApiUserEntity> getUserEntitys(List<UserVo> userEntities);
}
