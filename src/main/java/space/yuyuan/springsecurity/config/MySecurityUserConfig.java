package space.yuyuan.springsecurity.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootConfiguration
public class MySecurityUserConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User.builder()
//                .username("student").roles("student")
//                .password(passwordEncoder().encode("123456"))
//                .roles("student")
//                .build();
//        UserDetails user2 = User.builder().username("teacher").roles("teacher")
//                .authorities("teacher:query").password(passwordEncoder().encode("123456"))
//                .build();
//        UserDetails user3 = User.builder().username("admin").roles("admin")
//                .authorities("teacher:query", "teacher:add", "teacher:update", "teacher:delete").password(passwordEncoder().encode("123456"))
//                .build();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(user1);
//        manager.createUser(user2); manager.createUser(user3);
//        return manager;
//    }

}
