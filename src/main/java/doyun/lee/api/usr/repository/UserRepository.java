package doyun.lee.api.usr.repository;

import doyun.lee.api.brd.domain.Board;
import doyun.lee.api.usr.domain.UserVo;
import org.h2.engine.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jdo.annotations.Transactional;
import java.util.List;
import java.util.Optional;

interface IUserRepository {
	List<UserVo> findUserByName(String name);
	boolean checkDuplicateId(String userId);
	boolean checkDuplicateNickname(String userNickname);
	boolean findUserByEmail(String email);
	String findIdByEmail(String email);

	Optional<UserVo> findUserById(String email);
	Optional<UserVo> updateProfile(String email, String password);
	List<UserVo> findAllUser();

	UserVo findByAll(UserVo user);
}


public interface UserRepository extends JpaRepository<UserVo, Long>, IUserRepository {
	boolean existsByUsername(String username);
	UserVo findByUsername(String username);
	@Transactional
	void deleteByUsername(String username);
}