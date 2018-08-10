package com.guomn.toolbox.alicom.ecs;

import com.aliyuncs.ecs.model.v20140526.DescribeImagesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeImagesResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeLaunchTemplatesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeLaunchTemplatesResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Component;

/**
 * ecs-sdk的适配层代码
 * Created by GuoMengnan on 2018/7/6.
 */
@Component
public class EcsQuerreyService  extends EcsAccess{

	/**
	 * 查询可用镜像
	 */
	public void getListImages()	{
		try {
			DescribeImagesRequest describe = new DescribeImagesRequest();
			describe.setRegionId("cn-hongkong");
			DescribeImagesResponse response;
			response = client.getAcsResponse(describe);
			for(DescribeImagesResponse.Image image:response.getImages())
			{
				System.out.println(image.getImageId());
				System.out.println(image.getImageName());
			}
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询可用启动模板
	 */
	public void getListTemplates()	{
		try {
			DescribeLaunchTemplatesRequest describe = new DescribeLaunchTemplatesRequest();
			describe.setRegionId("cn-hongkong");
			DescribeLaunchTemplatesResponse response;
			response = client.getAcsResponse(describe);
			for(DescribeLaunchTemplatesResponse.LaunchTemplateSet launchTemplateSet:response.getLaunchTemplateSets())
			{
				System.out.println(launchTemplateSet.getLaunchTemplateName());
				System.out.println(launchTemplateSet.getLaunchTemplateId());
			}
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		new EcsQuerreyService().getListTemplates();

	}
}
