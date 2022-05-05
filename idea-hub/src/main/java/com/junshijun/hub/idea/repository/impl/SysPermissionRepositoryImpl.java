package com.junshijun.hub.idea.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junshijun.hub.idea.entity.SysPermission;
import com.junshijun.hub.idea.mapper.SysPermissionMapper;
import com.junshijun.hub.idea.repository.SysPermissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author 节操君
 * @since 2022-05-04
 */
@Service
public class SysPermissionRepositoryImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionRepository {
}
