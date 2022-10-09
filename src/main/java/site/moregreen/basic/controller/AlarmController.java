package site.moregreen.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import site.moregreen.basic.alarm.AlarmService;
import site.moregreen.basic.command.AlarmDto;

@Slf4j
@Controller
@RequestMapping("/alarm")
public class AlarmController {

	@Autowired
	@Qualifier("alarmService")
	AlarmService alarmService;
	
	@RequestMapping(value="saveAlarm",method=RequestMethod.POST)
	public @ResponseBody int heart(@RequestBody AlarmDto alarmDto) throws Exception{
		log.debug("==============test1============="+ alarmDto.getA_message());
		log.debug("==============test============"+ alarmDto.getFunding_f_num());
		int result = alarmService.saveAlarm(alarmDto); 
		
		return 1;
	}
	
}
