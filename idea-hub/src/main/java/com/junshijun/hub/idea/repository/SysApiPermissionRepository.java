package com.junshijun.hub.idea.repository;

import com.junshijun.hub.idea.entity.SysApiPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.junshijun.hub.idea.model.vo.ApiPermissionVO;

import java.util.List;

/**
 * <p>
 * 接口-权限关联表 服务类
 * </p>
 *
 * @author 节操君
 * @since 2022-06-05
 */
public interface SysApiPermissionRepository extends IService<SysApiPermission> {

    List<ApiPermissionVO> findAllApiPermission();
}
