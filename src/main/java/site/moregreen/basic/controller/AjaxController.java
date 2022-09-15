package site.moregreen.basic.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.moregreen.basic.funding.FundingService;

@RestController
public class AjaxController {

	@Autowired
	FundingService fundingService;
	
	@Value("${project.upload.path}")
	private String uploadPath;
	
	//이미지 처리
	@GetMapping("/display")
	public byte[] display(@RequestParam("filename") String filename,
						  @RequestParam("filepath") String filepath,
						  @RequestParam("uuid") String uuid) {
		
		System.out.println(filename);
		System.out.println(filepath);
		System.out.println(uuid);
		
		//업로드경로
		String saveName = uploadPath + "\\"+ filepath  +"\\"+ uuid + "_" + filename;
		//썸네일경로
		String thumbnailName = uploadPath + "\\"+ filepath  +"\\thumb_"+ uuid + "_" + filename;
		
		byte[] result = null;
		
		try {
			File file = new File(thumbnailName);
			result = FileCopyUtils.copyToByteArray(file);
		} catch (IOException e) {
			System.out.println("이미지 경로 참조에러");
			e.printStackTrace();
		}
		
		return result;
	}
	
}
