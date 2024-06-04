package space.yuyuan.springsecurity.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
public class CaptchaController {
    @GetMapping("/code/getChaptcha")
    public void createCaptchaCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(200, 100, 2, 20);
        String code = circleCaptcha.getCode();
        log.info(code);
        httpServletRequest.getSession().setAttribute("CAPTCHA_CODE", code);
        ImageIO.write(circleCaptcha.getImage(),"jpeg",httpServletResponse.getOutputStream());
    }
}
