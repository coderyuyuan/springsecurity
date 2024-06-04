package space.yuyuan.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import space.yuyuan.springsecurity.bean.SysUser;


public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser getByUserName(@Param("username") String username);
}
