package com.ss.lianxi.persistence.mapper;
import com.ss.lianxi.plugin.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.ss.lianxi.persistence.beans.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {


    SysUser findByUsernameAndPassword(@Param("username")String username,@Param("password")String password);



}