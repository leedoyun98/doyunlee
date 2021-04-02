package doyun.lee.api.rpl.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import doyun.lee.api.brd.domain.Board;
import doyun.lee.api.usr.domain.UserVo;
import lombok.Getter;

@Entity
@Getter
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rpl_no")
	private int rplNo;
	
	@Column(name = "rpl_content")
	private String rplContent;

	@ManyToOne
	@JoinColumn(name = "brd_no")
	private Board board;

	@ManyToOne
	@JoinColumn(name = "usr_no")
	private UserVo user;
}