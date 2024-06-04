package space.yuyuan.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import space.yuyuan.springsecurity.bean.SysMenu;

import java.util.List;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<String> queryPermissionsByUserId(@Param("userId") Integer userId);
}
