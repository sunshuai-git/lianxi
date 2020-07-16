package com.ss.lianxi.persistence.beans;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class SysUser {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private LocalDateTime ctime;

    private LocalDateTime utime;

}