package com.mong.book.springboot.config.auth;

import com.mong.book.springboot.web.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable()
                .and()
                //                 .csrf().disable().headers().frameOptions().disable()
                //                .and()
                // 이거 뺐더니 mockUser 권한 USER 로 줬는데 테스트 계속 실패함
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**")
                .permitAll()
                .antMatchers("/api/v1/**")
                .hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

    }
}

// @EnableWebSecurity 가 뭐임 ?
// - Spring Security 설정들을 활성화시켜줌.

// authorizeRequests() 가 뭐임 ?
// - URL 별 권한 관리를 설정하는 옵션의 시작점.
// andMatchers
// - authorizeRequests() 를 선언한 이후 사용 가능하며 권한 관리 대상을 지정하는 옵션
// - URL , Http 메서드 별로 관리가 가능하다.

// permitAll()
// - 허가한다.

// .antMatchers("/api/v1/**")
//                .hasRole(Role.USER.name())
//                .anyRequest().authenticated()
// - /api/v1/** 으로 접근시 USER 권한을 가진 사람만 권한 허용한다.