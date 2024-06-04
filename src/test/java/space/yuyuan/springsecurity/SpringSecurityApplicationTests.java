package space.yuyuan.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import space.yuyuan.springsecurity.mapper.SysUserMapper;

import javax.annotation.Resource;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    void contextLoads() {
//        List<String> list = Arrays.asList("student:query", "student:add", "student:update");
//        String token = JWTUtils.createToken(19L, "zhuyi", list);
        System.out.println(JWTUtils.verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdXRoIjpbInN0dWRlbnQ6cXVlcnkiLCJzdHVkZW50OmFkZCIsInN0dWRlbnQ6dXBkYXRlIl0sImlzcyI6IlpodVlpIiwiZXhwIjoxNzE3MTIwNTE4LCJ1c2VySWQiOjE5LCJpYXQiOjE3MTcxMjA0ODgsInVzZXJuYW1lIjoiemh1eWkifQ.4IyJ_JXZIS8LA-hYPIlW44E7oCo0VIAFO9nz09-JWpU"));

    }

}


