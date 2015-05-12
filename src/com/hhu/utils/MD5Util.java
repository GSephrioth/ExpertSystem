package com.hhu.utils;

import sun.misc.BASE64Encoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用于密码加密
 */
public class MD5Util {
    /**
     * 获取md5
     * @param message
     * @return md5
     */
    public static String encode(String message){

        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte b[] = md.digest(message.getBytes());
            return new BASE64Encoder().encode(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
