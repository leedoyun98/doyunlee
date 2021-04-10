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
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;

@Entity @Data
public class Reply   {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rpl_no")
	private long rplNo;
	
	@Column(name = "rpl_content")
	private String rplContent;
	@Column(name="rpl_wrt_date")
	private String rplWrtDate;
	@Column(name="usr_name")
	private String usrName;
	@Column(name="usr_no")
	private String usrNo;
	private String boardNo;

	@ManyToOne
	@JoinColumn(name = "brd_no")
	private Board board;

	public void setRplWrtDate(String rplWrtDate) {
		this.rplWrtDate = rplWrtDate;
	}
	public void setRplContent(String rplContent) {
		this.rplContent = rplContent;
	}

}