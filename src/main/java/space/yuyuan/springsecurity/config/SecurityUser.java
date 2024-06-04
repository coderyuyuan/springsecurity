package space.yuyuan.springsecurity.config;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import space.yuyuan.springsecurity.bean.SysUser;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class SecurityUser implements UserDetails {
    private final SysUser sysUser;

    private final List<SimpleGrantedAuthority> authorityList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }



    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
