package com.guomn.toolbox.controller.guester;

import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


/**
 * Created by GuoMengnan on 2018/11/29.
 */

public class HealthychkControllerTest {
	HealthychkController controller = Mockito.mock(HealthychkController.class);
	@Test
	public void healthCheckIsOk() {
		when(controller.helloworld()).thenReturn("helloworld");
		assertThat(controller.helloworld()).isEqualTo("helloworld");
	}
}