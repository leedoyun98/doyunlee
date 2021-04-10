package doyun.lee.api.usr.service;

import doyun.lee.api.brd.domain.Board;
import doyun.lee.api.cmm.service.AbstractService;
import doyun.lee.api.security.domain.SecurityProvider;
import doyun.lee.api.security.exception.SecurityRuntimeException;
import doyun.lee.api.usr.domain.Role;
import doyun.lee.api.usr.domain.UserVo;
import doyun.lee.api.usr.repository.UserRepository;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

import org.h2.engine.User;
import org.springframework.http.HttpStatus;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Getter
public class UserServiceImpl extends AbstractService<UserVo> implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;



    // Read(One)
    @Override
    public UserVo search(String username) {
        UserVo user = userRepository.findByUsername(username);
        if (user == null) {
            throw new SecurityRuntimeException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }


    // Read(List)
    @Override
    public List<UserVo> findUsersByName(String name) {
        return userRepository.findUserByName(name);
    }

    // Read(All)
    @Override
    public List<UserVo> findAllUser() {
        return userRepository.findAllUser();
    }

    // Read(All)
    @Override
    public List<UserVo> findAll() {
        return userRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(UserVo::getUsrName).reversed())
                .collect(Collectors.toList());
    }


    // Read
    @Override
    public Optional<UserVo> updateProfile(UserVo userVo) {
        return userRepository.updateProfile(userVo.getUsrEmail(), userVo.getPassword());
    }

    @Override
    public void sendMail(String to, String sub, String text) {

    }


    // Update
    @Override
    public long save(UserVo userVo) {
        return userRepository.save(userVo) != null ? 1 : 0;
    }

    // Delete
    @Override
    public long delete(UserVo userVo) {
        System.out.println(userVo.toString() + "회원 삭제.");
        userRepository.delete(userVo);
        return findById(userVo.getUsrNo()).isPresent() ? 1 : 0;
    }



    @Override
    public Map<String,Object> signin(String username, String password) {
        try {
            Map<String, Object> map = new HashMap<>();
            //	manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("ID: " + username);
            UserVo user = userRepository.findByUsername(username);
            List<Role> roles = user.getRoles();
            String tok = provider.createToken(username, roles);
            map.put("token",provider.createToken(username, roles));
            map.put("user",user);
            System.out.println("token :: " + tok);
            return map;
        } catch (AuthenticationException e) {
            throw new SecurityRuntimeException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public String signup(UserVo user) {

        boolean nickname;

        if (!userRepository.existsByUsername(user.getUsername())) {
            // 아이디, 비밀번호, 닉네임, 이메일, 전화번호, 레벨

            // 닉네임
            checkDuplicateNickname(user.getUsrNickname());
            user.setUsrNickname(user.getUsrNickname());

            // 이메일
            user.setUsrEmail(user.getUsrEmail());

            // 전화번호
            user.setUsrPhone(user.getUsrPhone());

            // 비밀번호
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            // 권한
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            user.setRoles(list);
            userRepository.save(user);
            return provider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }










    @Override
    public boolean checkDuplicateId(String userId) {
        if (userId != null) {
            return userRepository.checkDuplicateId(userId);
        }
        return false;
    }

    @Override
    public boolean checkDuplicateNickname(String userNickname) {
        if (userNickname != null) {
            return userRepository.checkDuplicateNickname(userNickname);
        }
        return false;
    }



    @Override public void delete(String username) { userRepository.deleteByUsername(username); }
    @Override public long count() { return 0; }
    @Override public Optional<UserVo> findById(long id) { return null; }
    @Override public boolean existsById(long id) { return false; }



    @Override public UserVo getOne(long id) { return userRepository.getOne(id); }

    @Override
    public UserVo whoami(HttpServletRequest req) {
        return userRepository.findByUsername(provider.getUsername(provider.resolveToken(req)));
    }

    @Override
    public String refresh(String username) {
        return provider.createToken(username, userRepository.findByUsername(username).getRoles());
    }
    public UserVo all(UserVo user) {
        return userRepository.findByAll(user);
    }


}