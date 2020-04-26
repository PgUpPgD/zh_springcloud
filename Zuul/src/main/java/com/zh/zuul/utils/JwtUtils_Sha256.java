package com.zh.zuul.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils_Sha256 {  //对称加密

    //秘钥
    private final static String secret = "21212";

    public static String creatJwt(){

        //指定签名算法，hs256 表示 sha256
        SignatureAlgorithm sign = SignatureAlgorithm.HS256;

        String jwtInfo = Jwts.builder().setHeaderParam("typ","jwt").setHeaderParam("alg","HS256") //设置头
            .claim("username","zhangsan") //设置载荷的私有数据
            .claim("id","123")
            //.setExpiration(new Date())   //设置过期时间
            .signWith(sign, secret)    //指定签名算法和秘钥
            .compact(); //生成字符串
        return jwtInfo;
    }

    public static Claims parseJWT(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(jsonWebToken).getBody();  //获取载荷对象
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }


    public static void main(String[] args) {
        //https://base64.supfree.net/ 载荷和头信息可以被解密
        String jwt = JwtUtils_Sha256.creatJwt();
        System.out.println(jwt);
        Claims claims = parseJWT(jwt);
        System.out.println(claims.get("username"));
    }


}
