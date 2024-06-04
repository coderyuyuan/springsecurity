package space.yuyuan.springsecurity.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import javax.annotation.Resource;

@SpringBootConfiguration
@EnableMethodSecurity
public class SecurityConfig {
    @Resource
    private AppAutheticationSuccessHandler appAutheticationSuccessHandler;

    @Resource
    private AppAuthericationFaileHander appAuthericationFaileHander;

    @Resource
    private AppLogoutSuccessHandler appLogoutHandler;

    @Resource
    private AppAccessDenyHandler appAccessDenyHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests().mvcMatchers("/student/**").hasRole("student")   //.hasAnyAuthority("ROLE_student")
//                        .mvcMatchers("/teacher/**").hasAnyAuthority("ROLE_teacher")
//                        .anyRequest().authenticated();
        http.authorizeRequests()
                .mvcMatchers("/code/getChaptcha").permitAll()
                .anyRequest().authenticated();
        http.formLogin().loginPage("/login/toLogin")
                .usernameParameter("uname").passwordParameter("pwd")
                .loginProcessingUrl("/login/doLogin").failureForwardUrl("/login/toLogin")
                .successForwardUrl("/index/toIndex")
//                .successHandler(appAutheticationSuccessHandler)
//                .failureHandler(appAuthericationFaileHander)
                .permitAll();
        http.logout()
//                .logoutSuccessHandler(appLogoutHandler);
                .logoutSuccessUrl("/login/toLogin");
//        http.exceptionHandling().accessDeniedHandler(appAccessDenyHandler);
        http.csrf().disable();
        return http.build();
    }
}
