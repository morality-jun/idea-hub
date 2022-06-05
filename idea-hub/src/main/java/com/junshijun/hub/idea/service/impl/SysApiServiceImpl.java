package com.junshijun.hub.idea.service.impl;

import com.junshijun.hub.idea.model.vo.ApiPermissionVO;
import com.junshijun.hub.idea.repository.SysApiPermissionRepository;
import com.junshijun.hub.idea.service.SysApiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysApiServiceImpl implements SysApiService {

    @Resource
    private SysApiPermissionRepository sysApiPermissionRepository;

    @Override
    public List<ApiPermissionVO> findAllApiPermission() {
        return sysApiPermissionRepository.findAllApiPermission();
    }
}
