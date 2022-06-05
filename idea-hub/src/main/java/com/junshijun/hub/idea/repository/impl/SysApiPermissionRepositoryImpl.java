package com.junshijun.hub.idea.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junshijun.hub.idea.entity.SysApiPermission;
import com.junshijun.hub.idea.mapper.SysApiPermissionMapper;
import com.junshijun.hub.idea.model.vo.ApiPermissionVO;
import com.junshijun.hub.idea.repository.SysApiPermissionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 接口-权限关联表 服务实现类
 * </p>
 *
 * @author 节操君
 * @since 2022-06-05
 */
@Service
public class SysApiPermissionRepositoryImpl extends ServiceImpl<SysApiPermissionMapper, SysApiPermission> implements SysApiPermissionRepository {

    @Resource
    private SysApiPermissionMapper sysApiPermissionMapper;

    @Override
    public List<ApiPermissionVO> findAllApiPermission() {
        List<ApiPermissionVO> allApiPermission = sysApiPermissionMapper.findAllApiPermission();
        return allApiPermission == null ? Collections.emptyList() : allApiPermission;
    }
}
