package cn.com.llt.utils;

import cn.com.llt.constant.IntegerConstant;
import cn.com.llt.constant.StringConstant;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Sha256Util {
    /**
     * 利用java内置类security实现sha256算法
     *
     * @param str
     * @return
     */
    public static String getSHA256StrJava(String str) {
        MessageDigest messageDigest;
        String encodeStr = StringConstant.BLACK_STR;
        try {
            messageDigest = MessageDigest.getInstance(StringConstant.SHA_256);
            messageDigest.update(str.getBytes(StringConstant.CHARSET_NAME_UTF8));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * javasha256加密算法得到的为byte数组，将其转换为16进制字符串
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = StringConstant.BLACK_STR;
        for (int i = IntegerConstant.ZERO_INT; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == IntegerConstant.ONE_INT) {
                // 得到一位的进行补0操作
                stringBuffer.append(StringConstant.ZERO_STR);
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}
