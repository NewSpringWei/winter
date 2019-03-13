package com.winter.snowman.baseservice.api.util;

import java.security.MessageDigest;

public class Encode {

    private static String MD5 = "MD5";
    private static String SHA1 = "SHA-1";
    private static String SHA256 = "SHA-256";
    private static String SHA512 = "SHA-512";

    public static String encodePassword(String text, String salt) {
        String res = getSHA512(text + salt);
        res = getMD5(res + salt);
        return res;
    }

    public static String getMD5(String str) {
        try {
            return digest(str, MD5);
        } catch (Exception e) {
            throw new RuntimeException("摘要MD5失败");
        }
    }

    public static String getSHA1(String str) {
        try {
            return digest(str, SHA1);
        } catch (Exception e) {
            throw new RuntimeException("摘要SHA1失败");
        }
    }

    public static String getSHA256(String str) {
        try {
            return digest(str, SHA256);
        } catch (Exception e) {
            throw new RuntimeException("摘要SHA256失败");
        }
    }

    public static String getSHA512(String str) {
        try {
            return digest(str, SHA512);
        } catch (Exception e) {
            throw new RuntimeException("摘要SHA512失败");
        }
    }

    /**
     * 字符串 SHA 加密
     * 
     * @param strSourceText
     * @return
     * @throws Exception
     */
    private static String digest(final String strText, final String strType) throws Exception {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();
                // 將 byte 轉換爲 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (Exception e) {
                throw e;
            }
        }
        return strResult;
    }

    public static void main(String[] args) {
        try {
            String pw = encodePassword("1","winter");
            System.out.println(pw);
            System.out.println(pw.length());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
