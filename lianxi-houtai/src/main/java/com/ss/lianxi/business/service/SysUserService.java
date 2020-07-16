package com.ss.lianxi.business.service;

import com.ss.lianxi.business.entity.User;
import com.ss.lianxi.framework.object.AbstractService;


public interface SysUserService extends AbstractService<User,Integer> {

    boolean findUser(String username, String password);

}
