package com.heima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    /**
     * 生成jwt
     * @param secretKey 密钥
     * @param ttlMillis jwt过期时间
     * @param claims jwt中封装的数据
     * @return
     */
    public static String createJWT(String secretKey, Long ttlMillis, Map<String, Object> claims) {
        // 生成足够长度的密钥
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        
        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(exp)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析jwt
     * @param secretKey 密钥
     * @param jwt jwt字符串
     * @return
     */
    public static Claims parseJWT(String secretKey, String jwt) {
        // 生成足够长度的密钥
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
}
