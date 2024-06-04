package space.yuyuan.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.yuyuan.springsecurity.service.TeacherService;

import javax.annotation.Resource;


@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @GetMapping("/query")
    public String queryInfo() {
        return teacherService.query();
    }

    @GetMapping("/add")
    public String addInfo() {
        System.out.println("add");
        return teacherService.add();
    }

    @GetMapping("/update")
    public String updateInfo() {
        return teacherService.update();
    }

    @GetMapping("/delete")
    public String deleteInfo() {
        return teacherService.delete();
    }
}
