package site.moregreen.basic.alarm;

import java.util.List;

import site.moregreen.basic.command.AlarmDto;

public interface AlarmService {

	public int saveAlarm(AlarmDto dto);				//알람 저장
		
	public List<AlarmDto> retrieveAlarmList(); 	//알람 목록 가져오기
}
