package com.guomn.toolbox.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Base64EncoderHelper {

    private static BASE64Encoder ecoder = new BASE64Encoder();
    private static BASE64Decoder decoder = new BASE64Decoder();


    public static String AESEncode(String input){
        return ecoder.encodeBuffer(input.getBytes());
    }
    public static String AESDencode(String input){
        try {
            return new String(decoder.decodeBuffer(input) , "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void  main(String[] args){

        List<String> input = new ArrayList<>();
        input.add("aaaa");

        for (String str : input) {
            System.out.print("加密前：" + str);
            str = AESEncode(str);
            System.out.print("加密后：" + str);
            str = AESDencode(str);
            System.out.print("解密后：" + str);
        }
    }

}