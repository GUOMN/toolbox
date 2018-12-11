package com.guomn.toolbox.utils;

import io.netty.handler.codec.base64.Base64Encoder;

import java.util.Base64;

/**
 * Created by GuoMengnan on 2018/11/29.
 */

public class MyBase64Cipher {

	private static final Base64.Encoder encoder = Base64.getUrlEncoder();
	private static final Base64.Decoder decoder = Base64.getUrlDecoder();
	public String encode(String input) {
		return new String(encoder.encode(input.getBytes()));
	}

	public String decode(String input) {
		return new String(decoder.decode(input.getBytes()));
	}
}
