package doyun.lee.api.rpl.domain;

import lombok.ToString;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Lazy @Component @ToString
public class ReplyDto {
	private long rplNo;
	private String rplContent;
	long brdNo;
	private String boardNo;
}
