package com.guomn.toolbox.alicom.ecs;

import com.aliyuncs.ecs.model.v20140526.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by GuoMengnan on 2018/7/6.
 */
@Component
public class EcsCreateDeleteService extends EcsAccess{
	/**
	 * 创建实例
	 */
	public void createEcsInstance(){
		//设置参数
		CreateInstanceRequest createInstance = new CreateInstanceRequest();
		createInstance.setRegionId("cn-hongkong");
		createInstance.setZoneId("cn-hongkong-c");
		createInstance.setImageId("m-j6cgvwn7f0mukbonaiez");
		createInstance.setInstanceType("ecs.xn4.small");
		createInstance.setInternetMaxBandwidthIn(200);
		createInstance.setInternetMaxBandwidthOut(100);
		createInstance.setInstanceChargeType("PostPaid");
		createInstance.setInstanceName("ToolBox创建");
		createInstance.setInternetChargeType("PayByTraffic");
		createInstance.setHostName("Ecs-GUOMN");
		createInstance.setPassword("nan@941209");

		// 发起请求
		try {
			CreateInstanceResponse response = client.getAcsResponse(createInstance);
			EcsInstance.setInstanceId(response.getInstanceId());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 批量创建实例
	 */
	public void runInstances(Integer hours){
		//设置参数
		RunInstancesRequest runInstances = new RunInstancesRequest();
		runInstances.setInstanceName("ToolBox创建");
		runInstances.setInternetChargeType("PayByTraffic");
		runInstances.setInternetMaxBandwidthIn(200);
		runInstances.setInternetMaxBandwidthOut(100);
		runInstances.setHostName("Ecs-GUOMN");
		runInstances.setPassword("nan941209");
		runInstances.setRegionId("cn-hongkong");
		runInstances.setZoneId("cn-hongkong-c");
		runInstances.setLaunchTemplateId("lt-j6cfamz0x92j0lglqb99");
		runInstances.setAmount(1);
//		runInstances.setAutoReleaseTime(getDateString(hours));

		// 发起请求
		try {
			RunInstancesResponse response = client.getAcsResponse(runInstances);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 转换为标准时间格式，参数为推迟小时数
	 * @param input
	 * @return
	 */
	private String getDateString(int input){
		TimeZone tz = TimeZone.getTimeZone("UTC");
		String pattern = "YYYY-MM-DD'T'HH:mm:ssZ";
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		sf.setTimeZone(tz);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.setTimeZone(tz);
		calendar.add(Calendar.HOUR, input);
		return sf.format(calendar.getTime());

	}

	/**
	 * 释放实例
	 */
	public void deletteInstance(){
		//设置参数
		DeleteInstanceRequest deleteInstance = new DeleteInstanceRequest();
		deleteInstance.setInstanceId(EcsInstance.getInstanceId());
		deleteInstance.setForce(false);
		deleteInstance.setTerminateSubscription(false);

		// 发起请求
		try {
			DeleteInstanceResponse response = client.getAcsResponse(deleteInstance);
			response.getRequestId();
			System.out.println(response.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 启动实例
	 */
	public void startInstance(){
		//设置参数
		StartInstanceRequest startInstance = new StartInstanceRequest();
		startInstance.setInstanceId(EcsInstance.getInstanceId());

		// 发起请求
		try {
			StartInstanceResponse response = client.getAcsResponse(startInstance);
			response.getRequestId();
			System.out.println(response.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 实例关机
	 */
	public void stopInstance(){
		//设置参数
		StopInstanceRequest stopInstance = new StopInstanceRequest();
		stopInstance.setInstanceId(EcsInstance.getInstanceId());
		stopInstance.setConfirmStop(true);
		stopInstance.setForceStop(true);

		// 发起请求
		try {
			StopInstanceResponse response = client.getAcsResponse(stopInstance);
			System.out.println(response.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
			new EcsCreateDeleteService().runInstances(1);
		System.out.println(
			new EcsCreateDeleteService().getDateString(1)
		);

	}
}
