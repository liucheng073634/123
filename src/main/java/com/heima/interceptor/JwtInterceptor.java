package com.heima.interceptor;


import com.heima.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 放行登录接口
        if (request.getRequestURI().contains("/login")) {
            return true;
        }

        // 获取token
        String authorization = request.getHeader("Authorization");
        if (!StringUtils.hasText(authorization)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        try {
            // 确保正确处理 Bearer token
            String token = null;
            if (authorization.startsWith("Bearer ")) {
                token = authorization.substring(7).trim();
            } else {
                token = authorization.trim();
            }
            
            if (StringUtils.hasText(token) ) {
                // 将token存储在request中，使用与Controller一致的属性名
                request.setAttribute("token", token);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
} 