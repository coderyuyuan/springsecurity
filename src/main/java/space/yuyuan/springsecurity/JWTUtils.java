package space.yuyuan.springsecurity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JWTUtils {
    private static final String secret = "12345";

    public static String createToken(Long userId, String username, List<String> auth) {
        HashMap<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        return JWT.create().withHeader(header).withClaim("userId", userId).withClaim("username", username).withClaim("auth", auth)
                .withIssuer("ZhuYi") //设置签发人
                .withIssuedAt(new Date()) //设置签发时间
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) //设置过期时间
                .sign(Algorithm.HMAC256(secret));
    }

    public static boolean verifyToken(String JWTToken) {
        try {
            JWTVerifier build = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT verify = build.verify(JWTToken);
            return true;
        } catch (IllegalArgumentException | JWTVerificationException e) {
            System.out.println();
            return false;
        }
    }

    public static Long getUserIdFromJWT(String JWTToken) {
        try {
            JWTVerifier build = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT verify = build.verify(JWTToken);
            return verify.getClaim("userId").asLong();
        } catch (IllegalArgumentException | JWTVerificationException e) {
            return null;
        }
    }

    public static String getUserNameFromJWT(String JWTToken) {
        try {
            JWTVerifier build = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT verify = build.verify(JWTToken);
            return verify.getClaim("userName").asString();
        } catch (IllegalArgumentException | JWTVerificationException e) {
            return null;
        }
    }


}
