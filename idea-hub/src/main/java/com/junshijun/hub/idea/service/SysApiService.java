package com.junshijun.hub.idea.service;

import com.junshijun.hub.idea.model.vo.ApiPermissionVO;

import java.util.List;

public interface SysApiService {

    List<ApiPermissionVO> findAllApiPermission();
}
