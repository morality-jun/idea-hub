package com.junshijun.hub.idea.mapper;

import com.junshijun.hub.idea.entity.SysApiPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.junshijun.hub.idea.model.vo.ApiPermissionVO;

import java.util.List;

/**
 * <p>
 * 接口-权限关联表 Mapper 接口
 * </p>
 *
 * @author 节操君
 * @since 2022-06-05
 */
public interface SysApiPermissionMapper extends BaseMapper<SysApiPermission> {

    List<ApiPermissionVO> findAllApiPermission();
}
