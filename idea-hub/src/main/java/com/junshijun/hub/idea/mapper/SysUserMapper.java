package com.junshijun.hub.idea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junshijun.hub.idea.entity.SysUser;
import com.junshijun.hub.idea.model.vo.AuthUserRolePermissionVO;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 节操君
 * @since 2022-05-02
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    AuthUserRolePermissionVO getUserRolePermissionByLoginName(String loginName);
}
