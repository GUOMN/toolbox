package com.guomn.toolbox.controller.admin;

import com.guomn.toolbox.alicom.ecs.EcsCreateDeleteService;
import com.guomn.toolbox.alicom.ecs.EcsQuerreyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GuoMengnan on 2018/7/9.
 */
@RestController
@Slf4j
public class EcsController {
	@Autowired
	EcsCreateDeleteService ecsCreateDeleteService;
	@Autowired
	EcsQuerreyService ecsQuerreyService;

	@PostMapping("/createEcsInstance")
	public String createEcsInstance(@RequestParam(value="destory_dely_in_hour", required=false, defaultValue = "1") int hours) {
//		ecsCreateDeleteService.createEcsInstance();
		ecsCreateDeleteService.runInstances(hours);
		return "";
	}

	@PostMapping("/deleteEcsInstance")
	public String deleteEcsInstance() {
		ecsCreateDeleteService.deletteInstance();
		return "";
	}

	@PostMapping("/startEcsInstance")
	public String startEcsInstance() {
		ecsCreateDeleteService.startInstance();
		return "";
	}

	@PostMapping("/stopEcsInstance")
	public String stopEcsInstance() {
		ecsCreateDeleteService.stopInstance();
		return "";
	}
}
