package space.yuyuan.springsecurity.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import space.yuyuan.springsecurity.bean.SysUser;
import space.yuyuan.springsecurity.config.SecurityUser;
import space.yuyuan.springsecurity.mapper.SysMenuMapper;
import space.yuyuan.springsecurity.service.SecurityUserDetailsService;
import space.yuyuan.springsecurity.service.SysUserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SecurityUserDetailsServiceImpl implements SecurityUserDetailsService, UserDetailsService {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getByUserName(username);
        log.error("执行了");
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        List<String> list = sysMenuMapper.queryPermissionsByUserId(sysUser.getId());
        for (String s : list) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(s);
            simpleGrantedAuthorities.add(simpleGrantedAuthority);
        }
        return new SecurityUser(sysUser, simpleGrantedAuthorities);
    }
}
