package space.yuyuan.springsecurity.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import space.yuyuan.springsecurity.service.TeacherService;

@Slf4j
@Service
@PreAuthorize("hasRole('teacher')")
public class TeacherServiceImpl implements TeacherService {
    @PreAuthorize("hasAuthority('teacher:add')")
    @Override
    public String add() {
        log.info("添加教师成功");
        return "添加教师成功";
    }

    @PreAuthorize("hasAuthority('teacher:update')")
    @Override
    public String update() {
        log.info("修改教师成功");
        return "修改教师成功";
    }

    @PreAuthorize("hasAuthority('teacher:delete')")
    @Override
    public String delete() {
        log.info("删除教师成功");
        return "删除教师成功";
    }

    @PreAuthorize("hasAuthority('teacher:query')")
    @Override
    public String query() {
        log.info("查询教师成功");
        return "查询教师成功";
    }
}
