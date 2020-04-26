package com.zh.micro_user.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

public class JWTUtils {

    // 密钥
    private static String priKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC4011BHA4AljbwTwiv/rFIFGb5lnB18Sbif/8/qGZUWVzm1QRRJ1skXaoSwF5Kg9DOXor0zhu9xn0HkOe1GqkfQzaGYFZC9FkBSBa2Gk5b/6LxTT275KY/e0q5D87HBJI/K2qm75klylNbSxJjpJOHGx6Rf9s31oMUbq0vzIMr0p/d+KRf0SWDco3cH/0XfIYr0TJuRqPf1lJ2e5l4hEpn9x7hhfRf1jcB8Tjhd/irjCjCeTLg43q/Qqtwu1m9cPzv9A35H8gn56/HE25CNDHQD3e0Qg9JC1Z3jXPK1lWOW1hduUL5Lc5X6MA2x0EMm+NL51c+ljYkFLUIXTrhFblPAgMBAAECggEAUhY13bwLEAGnRtWjQx84N44wKfvB2PAQ2BoHEIvHXwENfMvxDeYP2bfr2EYt2qRusalVx+JeecvVLe4SquG7aVIdvlK9HSGPAj21MI3AbaW9BbTLjU7A84LbrhOyP7vtBDdRN/FEMH+KxAo0kaK/jwrhabfCcitIrmN1cbxAKc6vp/p6xM3dCuXfqyg2L/8upUFtiuVXdnZ1UZCozyd8nf5KN9+Q8aXcDxaDcRHy9yaWdNo6+OfFg14wd1ZlSK0crT4rT4f3MCvpNaBDs/RnXZxMHifJmXtw1KXERUvPAMT4kE/dOXW31EfnRbN/f7Rc+2jQVOAQj03Io2RueHduMQKBgQD8iquOydPZwN+SUGt5M4ENNgO/L+XDxuO76N8KdBELZzXxvJDXzcH9TgMFMpaoGg1qe4I+CAvnDX8cVTgMLss+9SG1dZo2JuUlr9zfrewQp/GsSW3RRiENgVKdnxEwW8i69CgWPlfdXAw+VnOQnLEYLZGjRxiRGw9QrfAzVDTU5wKBgQC7W02xgymLrSiiuS+S3ekRQvztlwaOE2PIjaWdRqPHmJF4PFz714/y+0xHXswHueUjwqmGjgquiTHOt9I+HMF4VjaYvQxd9kCqNu7Y6e2HK923M7y3p49L7M4ToX4GdBaA+aduNO4m3OMiTZLEIvF/gjtR4tqa/Op6ufwDYd8DWQKBgQCo40Pf9fGLioT5oHZ/U4ZWg2z2Ct4pk3TxUcb3gq9zZM6an3RuHdhBwk4ax74hJWsbbwWm3lK3bjs3g3Y8D38011J3u/IpjNFp5rZbkEBy0x24DlM2xSONmJLbfmlMYdVX0biNR5wTGV/GwKIAcAmvFapz+zPetq4DUo90hDfguQKBgQCFSFim9WXyxYZo7FCZrGAHNZ507sFtBQIxRAMTNZOBhFnILTkAt8Lh2j/Tbe67eFU38V1kKVwT+emC42YfZZmEn+BLHAHWPj6WWGnlydR+GoipsZaJGBxqqNWZRYM/2AnCStf/IIxi/TRfzMuh2DHwwZatlDJrm4y7Ld/IEDH0UQKBgQCS+p2L13HTBJKm3ZRvCVDK2zuq+AeEYt2dmlWnd/73QDgtL1Mu54StveAmT+iFIU6r25f63GkCMHlTjkVm/5EfV4EP3pflPFxzCxPhWWM3KhyTJkF6pvV0KDWHmoYUBK2/tQfXI5PEom46Hy2Ym15G0ivgNvVdeK89ISVR+onA6Q==";


    private static String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuNNdQRwOAJY28E8Ir/6xSBRm+ZZwdfEm4n//P6hmVFlc5tUEUSdbJF2qEsBeSoPQzl6K9M4bvcZ9B5DntRqpH0M2hmBWQvRZAUgWthpOW/+i8U09u+SmP3tKuQ/OxwSSPytqpu+ZJcpTW0sSY6SThxsekX/bN9aDFG6tL8yDK9Kf3fikX9Elg3KN3B/9F3yGK9Eybkaj39ZSdnuZeIRKZ/ce4YX0X9Y3AfE44Xf4q4wownky4ON6v0KrcLtZvXD87/QN+R/IJ+evxxNuQjQx0A93tEIPSQtWd41zytZVjltYXblC+S3OV+jANsdBDJvjS+dXPpY2JBS1CF064RW5TwIDAQAB";
    /**
     * 生成hash值
     */
    public static String createJwt(String username){
        // 签名算法，表示rsa
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;
        //构造jwt
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ","jwt") // 设置头
                .setHeaderParam("alg", "RS256")
                .claim("username",username) // 设置payload 载荷
//                .claim("timestamp", System.currentTimeMillis()) // payload中增加时间戳，同一用户每次生成的token都不一样
                .setExpiration(new Date(System.currentTimeMillis() + 1800000)) //设置过期时间在三分钟之后
                .signWith(signatureAlgorithm, getPrivateKey(priKey)); // 使用指定算法设置签名
        //生成jwt
        return builder.compact();
    }

    //私钥加密
    private static PrivateKey getPrivateKey(String strPk) {
        byte[] b1 = Base64.getDecoder().decode(strPk);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b1);
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(spec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
    //公钥解析
    public static PublicKey getPublicKey(String pubKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(pubKey);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(spec);
    }

    /**
     * 用公钥解析token，如果不符合，报异常,返回null
     */
    public static Claims parseJWT(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getPublicKey(pubKey))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        String zhangsan = JWTUtils.createJwt("zhangsan");    //加密
        System.out.println(zhangsan);
        Claims claims = JWTUtils.parseJWT(zhangsan);        //解析
        System.out.println(claims.get("username"));
    }

}
