package doyun.lee.api.lvl.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import doyun.lee.api.usr.domain.UserVo;
import lombok.Getter;

@Entity @Getter
public class Level {
	@Id @Column(name="level") private int level;
	
	@OneToMany(mappedBy = "level")
	private List<UserVo> users = new ArrayList<>();
}
