package space.yuyuan.springsecurity.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/login/toLogin")) {
            doFilter(request, response, filterChain);
            return;
        }
        String entryCode = request.getParameter("code");
        String sessionCode = (String) request.getSession().getAttribute("CAPTCHA_CODE_CODE");
        if (entryCode.isEmpty()) {
            request.getSession().setAttribute("error", "请输入验证码");
            response.sendRedirect("/login/toLogin");
            return;
        }
        if (sessionCode.isEmpty()) {

            request.getSession().setAttribute("error", "请输入验证码");
            response.sendRedirect("/login/toLogin");
            return;
        }
        if (!entryCode.equalsIgnoreCase(sessionCode)) {
            request.getSession().setAttribute("error", "验证码错误");
            response.sendRedirect("/login/toLogin");
        }
        doFilter(request, response, filterChain);
    }
}
