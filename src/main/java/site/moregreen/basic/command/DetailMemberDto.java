package site.moregreen.basic.command;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailMemberDto {
	private Integer m_num;
	private String m_id;
	private String m_email;
	
	private char m_exit;
	
	private String d_addr;
	
}
