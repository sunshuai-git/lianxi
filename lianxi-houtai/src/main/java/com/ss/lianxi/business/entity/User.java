package com.ss.lianxi.business.entity;

import com.ss.lianxi.persistence.beans.SysUser;

import java.time.LocalDateTime;

public class User {
    private SysUser sysUser;
    public User(){
        this.sysUser = new SysUser();
    }
    public User(SysUser sysUser){
        this.sysUser = sysUser;
    }
    public SysUser getSysUser(){
        return this.sysUser;
    }
    public int getId(){
        return this.sysUser.getId();
    }
    public void setId(int id){
        this.sysUser.setId(id);
    }
    public String getUsername(){
        return this.sysUser.getUsername();
    }
    public void setUsername(String username){
        this.sysUser.setUsername(username);
    }
    public String getPassword(){
        return this.sysUser.getPassword();
    }
    public void setPassword(String password){
        this.sysUser.setPassword(password);
    }
    public String getEmail(){
        return this.sysUser.getEmail();
    }
    public void setEmail(String email){
        this.sysUser.setEmail(email);
    }
    public String phone(){
        return sysUser.getPhone();
    }
    public void setPhone(String phone){
        this.sysUser.setPhone(phone);
    }
    public LocalDateTime getCtime(){
        return this.sysUser.getCtime();
    }
    public void setCtime(LocalDateTime ctime){
        this.sysUser.setCtime(ctime);
    }
    public LocalDateTime getUtime(){
        return this.sysUser.getUtime();
    }
    public void setUtime(LocalDateTime utime){
        this.sysUser.setUtime(utime);
    }
}
