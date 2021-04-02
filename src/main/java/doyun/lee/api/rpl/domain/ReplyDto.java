package doyun.lee.api.rpl.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Lazy @Component
public class ReplyDto {
	private int rplNo;
	private String rplContent;

}
