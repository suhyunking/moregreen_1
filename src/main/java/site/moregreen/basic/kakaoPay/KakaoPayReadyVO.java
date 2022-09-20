package site.moregreen.basic.kakaoPay;

import java.util.Date;

import lombok.Data;

@Data
public class KakaoPayReadyVO {
	//response
    private String tid;
    private String userId;
    private String next_redirect_pc_url;
    private Date created_at;
}
