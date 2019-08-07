package org.hello.dao;
import java.util.List;
import org.hello.domain.ReplyVO;
import javax.inject.Inject;
import org.hello.domain.Criteria;
import org.hello.domain.SearchCriteria;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class ReplyDAOImpl implements ReplyDAO {
	 @Inject
	    private SqlSession sqlSession;
	    
	    private static String namespace = "org.hello.mappers.replyMapper";
	    @Override
	    public List<ReplyVO> readReply(int b_no) throws Exception {
	    	sqlSession.selectList(namespace + ".readReply", b_no);
	    	return sqlSession.selectList(namespace + ".readReply", b_no);
	    }
	    @Override
	    public void writeReply(ReplyVO vo) throws Exception {
	    	sqlSession.insert(namespace + ".writeReply", vo);
	    }
}
