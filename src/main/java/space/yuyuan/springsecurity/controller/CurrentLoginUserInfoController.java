package space.yuyuan.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class CurrentLoginUserInfoController {
    @GetMapping("/getLoginUserInfo")
    public Principal getLoginUserInfo(Principal principal) {
        return principal;
    }
    @GetMapping("/getLoginUserInfo1")
    public Authentication getLoginUserInfo1(Authentication authentication){
        return authentication;
    }
    @GetMapping("/getLoginUserInfo2")
    public Authentication getLoginUserInfo2(){
        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        return authentication1;
    }
}
