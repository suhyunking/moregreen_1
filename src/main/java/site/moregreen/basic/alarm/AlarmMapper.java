package site.moregreen.basic.alarm;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import site.moregreen.basic.command.AlarmDto;

@Mapper
public interface AlarmMapper {

	public void saveAlarm(AlarmDto dto); 		//알람 저장
	
	public List<AlarmDto> selectAlarmList();	//알람 목록 조회
}
