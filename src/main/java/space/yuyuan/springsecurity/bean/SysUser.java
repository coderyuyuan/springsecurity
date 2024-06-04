package space.yuyuan.springsecurity.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("sys_table")
public class SysUser implements Serializable {
    @TableId
    private Integer id;
    @TableField()
    private String username;
    private String password;
    @TableField("sex")
    private String sex;
    private String address;
    private Integer enabled;
    private Integer accountNoExpired;
    private Integer credentialsNoExpired;
    private Integer accountNoLocked;
}