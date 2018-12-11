package com.guomn.toolbox.alicom.acm;

import com.alibaba.edas.acm.ConfigService;
import com.alibaba.edas.acm.exception.ConfigException;
import com.alibaba.edas.acm.listener.ConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ByteArrayResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by GuoMengnan on 2018/8/20.
 */
@PropertySource("application")
@Slf4j
public class ACMProperties {

	private static Properties acmProperties = null;
	private static String config = "";

	/**
	 * 外部调用初始化
	 */
	public static void init(){
		log.info("Start fetching configures from ACM...");
		fetchConfigures();
		log.info("fetch configures from ACM success");
		log.info("convert configures...");
		convert();
		log.info("convert configures success");
		save();
	}


	/**
	 * 初始化ACM参数
	 */
	private static Properties initACMProperties(){
		// Initialize configuration service and the console will retrieve the following parameters through the sample code. Input parameters include endpoint, namespace, accessKey, and secretKey(The secrectKey of ACM. Do not use the secrectKey of your Alibaba acount.).
		Properties properties = new Properties();
		properties.put("endpoint", "acm.aliyun.com");
		properties.put("namespace", "f471b4fb-f02c-472c-af17-064b21c9c660");
		// Access ACM with instance RAM role: https://help.aliyun.com/document_detail/72013.html
		// properties.put("ramRoleName", "$ramRoleName");
		properties.put("accessKey", "5c8cd07478cd4a499acd7b7acca51bee");
		properties.put("secretKey", "kh1jof5hsp690Ec1YiaDxcD7MFU=");

		return properties;
	}

	/**
	 * 从远程服务器获取ACM配置内容
	 */
	private static void fetchConfigures(){
		ConfigService.init(initACMProperties());

		// Get configuration proactively
		try {
			config = ConfigService.getConfig("ToolBox", "DEFAULT_GROUP", 6000);
			save();
			// YAML转换有问题，自己实现
//			acmProperties = ConfigService.getConfig2Properties("toolbox", "DEFAULT_GROUP", 6000);
		} catch (ConfigException e) {
			e.printStackTrace();
		}
		// Add listener for the configuration during initialization, so that configuration changes will trigger callback notifications.
		ConfigService.addListener("toolbox", "DEFAULT_GROUP", new ConfigChangeListener() {
			public void receiveConfigInfo(String configInfo) {
				// When the configuration is updated, the callback function will send the new value to the user.
				// Note that you should not perform any block operations in the callback function. Otherwise the thread will be blocked.
				config = configInfo;
				save();
				convert();
			}
		});
	}

	/**
	 * 将获得的String数据按照YAML格式装载
	 */
	private static void convert(){
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(new ByteArrayResource(config.getBytes(), "application"));
		acmProperties = yaml.getObject();
	}

//	/**
//	 * 将配置公开为Spring环境中的属性
//	 */
//	private static void loadProperties2Spring(){
////		YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
//
//
//		SpringApplication springApplication = new SpringApplication(ToolboxApplication.class);
////		ConfigurableApplicationContext configurableApplicationContext = springApplication.run();
////		ACMProperties customerDataSourceConfig = configurableApplicationContext.getBean(ACMProperties.class);
//
//		springApplication.setAdditionalProfiles();
//
//	}

	/**
	 * 文件写到本地
	 */
	private static void save(){
		try {
//			URL url = ACMProperties.class.getResource("/");
			URL url = ACMProperties.class.getResource("/");
			FileOutputStream out = new FileOutputStream(new File(url + "application.yaml"));
			out.write(config.getBytes());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	/**
	 * 获取配置
	 */
	public static Object get(String key){
		return acmProperties.get(key);
	}

	public static void main(String[] args) {
		fetchConfigures();
		convert();
		System.out.println(get("spring.redis.host"));
	}

}
