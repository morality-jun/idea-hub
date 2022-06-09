package com.junshijun.hub.idea.service;

import com.junshijun.hub.idea.model.vo.AuthApiPermissionVO;

import java.util.List;

public interface SysApiService {

    List<AuthApiPermissionVO> findAllApiPermission();
}
