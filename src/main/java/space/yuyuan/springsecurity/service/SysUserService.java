package space.yuyuan.springsecurity.service;

import space.yuyuan.springsecurity.bean.SysUser;

public interface SysUserService {
    SysUser getByUserName(String userName);
}
