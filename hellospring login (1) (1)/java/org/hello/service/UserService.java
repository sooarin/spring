package org.hello.service;

import org.hello.domain.UserVO;



public interface UserService {

	public void createUser(UserVO vo) throws Exception;
	public void createUserencrpyt(UserVO vo)throws Exception;
	 public UserVO login(UserVO dto) throws Exception;
	public UserVO idCheck(String id) throws Exception;
	public void user(UserVO vo) throws Exception;
	public void withdrawal(UserVO vo) throws Exception;
	
}
