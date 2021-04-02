package doyun.lee.api.usr.service;

import doyun.lee.api.usr.domain.UserVo;
import doyun.lee.api.usr.domain.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserService {
	
	public boolean checkDuplicateId(String userId);
	public boolean checkDuplicateEmail(String userId);
	public List<UserVo> findUsersByName(String name);
	public List<UserVo> findAllUser();
	public String findIdByEmail(String userEmail);
	public UserDto create(UserDto user);


	public Optional<UserVo> updateProfile(UserVo user);

	public boolean emailCheck(UserVo user);
	public boolean idCheck(UserVo user);
	public boolean swearFilter(String keyword);


	public void updatePassword(String str, String userEmail);
	public String createTempPassword();
	
}