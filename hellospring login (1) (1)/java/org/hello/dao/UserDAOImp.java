package org.hello.dao;

import javax.inject.Inject;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.hello.domain.UserVO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //DAO占쏙옙占� 占쏙옙占� (DAO占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占싸식쏙옙占쏙옙占쏙옙)
public class UserDAOImp implements UserDAO {

    @Inject // 占쏙옙占쏙옙占쏙옙占썼를 占쌘듸옙占쏙옙占쏙옙 占쏙옙占쏙옙(JAVA占쏙옙占쏙옙 占쏙옙占쏙옙) ==@autowired (Spring占쏙옙占쏙옙 占쏙옙占쏙옙)
    private SqlSession sqlSession; 
    
    
    private static final String namespace = "org.hello.mapper.userMapper"; 
                                            //memberMapper.xml占쏙옙 namespace占쏙옙
    
    @Override
    public void createUser(UserVO vo)throws Exception {
        sqlSession.insert(namespace+".insertUser", vo);
    }
    
    
    /** 

     *  login占쏙옙 占쏙옙占쏙옙占싹몌옙, 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쌍댐옙 UserVO 占쏙옙체占쏙옙 占쏙옙환占싼댐옙.

     * */

    @Override

    public UserVO login(UserVO dto) {

      
        return sqlSession.selectOne(namespace+".login", dto);
    }
    @Override
    public UserVO idCheck(String id) throws Exception {
    	return sqlSession.selectOne(namespace + ".idCheck", id);
    }
    @Override
    public void user(UserVO vo) throws Exception {
    	sqlSession.update(namespace + ".user", vo);
    }
	@Override
	public void withdrawal(UserVO vo) throws Exception {
		sqlSession.delete(namespace + ".withdrawal", vo);
	}
	




}
