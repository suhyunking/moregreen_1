package site.moregreen.basic.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadDto {

	private Integer upload_no; //pk
	private String name;
	private String path;
	private String uuid;
	private Integer f_num; //fk
}
