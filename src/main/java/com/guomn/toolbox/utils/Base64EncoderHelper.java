package com.guomn.toolbox.utils;

import com.alibaba.fastjson.JSON;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

       String ss = "PGh0bWw+DQo8aGVhZD48dGl0bGU+NDAwIEJhZCBSZXF1ZXN0PC90aXRsZT48L2hlYWQ+DQo8Ym9keSBiZ2NvbG9yPSJ3aGl0ZSI+DQo8Y2VudGVyPjxoMT40MDAgQmFkIFJlcXVlc3Q8L2gxPjwvY2VudGVyPg0KPGhyPjxjZW50ZXI+bmdpbngvMS4xMi4yPC9jZW50ZXI+DQo8L2JvZHk+DQo8L2h0bWw+DQo=";


        ss = AESDencode(ss);
        System.out.print("解密后：" + ss);

        JSON.parseObject(ss, Map.class);

    }

}