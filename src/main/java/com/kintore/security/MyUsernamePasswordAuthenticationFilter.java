package com.kintore.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public MyUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        // "/api/login" の場合に認証を行うよう設定
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));

        // 成功した場合の処理, 今回は取得した UserLoginDto 情報を返しています。
        this.setAuthenticationSuccessHandler((req, res, ex) -> {
            res.setStatus(200);
            UserLoginDto user = (UserLoginDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            res.getWriter().write((new ObjectMapper()).writeValueAsString(user.getUsername()));
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            // リクエストのデータを LoginForm として取り出す
            LoginForm principal = new ObjectMapper().readValue(request.getInputStream(), LoginForm.class);
            // 認証処理を実行する
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(principal.getUserName(), principal.getPassword())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}