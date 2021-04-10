package doyun.lee.api.usr.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.util.List;

@Component
@Data
public class UserDto {

    private static final long serialVersionUID = 1L;

    private Long usrNo;


    private String username;    // 아이디


    private String usrName;     // 이름



    private String usrEmail;    // 이메일



    private String password;    // 비밀번호



    private String usrPhone;    // 전화번호


    private String usrNickname; // 닉네임


    //	@ApiModelProperty(position = 3)
    List<Role> roles;       // 레벨

    private String usrAges;
    private String usrCity;
    private String usrGender;
    private String usrAddr;


    public UserVo toEntity() {
        return UserVo.builder()
                .usrName(usrName)
                .username(username)
                .usrNickname(usrNickname)
                .usrEmail(usrEmail)
                .usrPhone(usrPhone)
                .build();
    }

/*
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDto that = (UserDto) o;
		return Objects.equals(usrNo, that.usrNo);
	}
	@Override
	public int hashCode() {
		return Objects.hash(usrNo);
	}
*/


}