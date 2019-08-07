package org.hello.dao;
import java.util.List;

import org.hello.domain.UserVO;
public interface UserDAO {
	public void createUser(UserVO vo) throws Exception;
	public UserVO login(UserVO dto) throws Exception;  // �α��� 
	public UserVO idCheck(String id) throws Exception;
	public void user(UserVO vo) throws Exception;
	public void withdrawal(UserVO vo) throws Exception;
	
}
