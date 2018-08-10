package com.guomn.toolbox.alicom.ecs;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by GuoMengnan on 2018/7/6.
 */
public class EcsAccess {
	@Value("${ecs.accessKeyId}")
	private String accessKey;
	@Value("${ecs.accessKeySecret}")
	private String accessKeySecret;
	protected IClientProfile profile = DefaultProfile.getProfile("cn-hongkong", accessKey, accessKeySecret);
	protected IAcsClient client = new DefaultAcsClient(profile);
}
