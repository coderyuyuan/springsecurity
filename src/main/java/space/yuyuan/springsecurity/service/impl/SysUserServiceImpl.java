package space.yuyuan.springsecurity.service.impl;

import org.springframework.stereotype.Service;
import space.yuyuan.springsecurity.bean.SysUser;
import space.yuyuan.springsecurity.mapper.SysUserMapper;
import space.yuyuan.springsecurity.service.SysUserService;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getByUserName(String userName) {
        return sysUserMapper.getByUserName(userName);
    }
}
