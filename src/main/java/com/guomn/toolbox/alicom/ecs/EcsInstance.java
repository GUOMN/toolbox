package com.guomn.toolbox.alicom.ecs;


/**
 * Created by GuoMengnan on 2018/7/9.
 */
public class EcsInstance {
	private static String instanceId;

	public static String getInstanceId() {
		return instanceId;
	}

	public static void setInstanceId(String input) {
		instanceId = input;
	}
}
