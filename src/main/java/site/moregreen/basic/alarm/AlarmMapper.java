package site.moregreen.basic.alarm;

import org.apache.ibatis.annotations.Mapper;

import site.moregreen.basic.command.AlarmDto;

@Mapper
public interface AlarmMapper {

	public void saveAlarm(AlarmDto dto); //알람 저장
	
}
