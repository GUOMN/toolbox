package com.guomn.toolbox.controller.guester;

import com.guomn.toolbox.utils.MyBase64Cipher;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;



/**
 * Created by GuoMengnan on 2018/11/29.
 */

public class Base64EncoderTest {
	private static final MyBase64Cipher ciper = Mockito.mock(MyBase64Cipher.class);

	@Test
	public void encode() {
		when(ciper.encode("input")).thenReturn("asdf");
		assertThat(ciper.encode("input")).isEqualTo("asdf");
	}

	@Test
	public void decode() {
		when(ciper.decode("input")).thenReturn("asdf");
		assertThat(ciper.decode("input")).isEqualTo("asdf");
	}
}
