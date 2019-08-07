package org.hello.dao;
 
import java.util.List;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.hello.domain.BoardVO;
import org.hello.domain.Criteria;
import org.hello.domain.SearchCriteria;
import org.springframework.stereotype.Repository;
 
@Repository
public class BoardDAOImp implements BoardDAO {
    
    @Inject
    private SqlSession sqlSession;
    
    private static String namespace = "org.hello.mapper.BoardMapper";
 
    //�Խ����߰�
    @Override
    public void create(BoardVO vo) throws Exception {
        
        sqlSession.insert(namespace+".insertBoard", vo);
 
    }
    
  
    
    //�Խ��� ��
    @Override
    public BoardVO read(Integer b_no) throws Exception {
        sqlSession.selectOne(namespace+".detailBoard", b_no);
        return  sqlSession.selectOne(namespace+".detailBoard", b_no);
    }
 
    //�Խ��� ����
    @Override
    public void delete(Integer b_no) throws Exception {
        sqlSession.delete(namespace+".deleteBoard", b_no);
 
    }
 
    //�Խ��� ����
    @Override
    public void update(BoardVO vo) throws Exception {
        sqlSession.update(namespace+".updateBoard", vo);
 
    }

	@Override
	public void updateViewCnt(Integer b_no) throws Exception {
		sqlSession.update(namespace + ".updateViewCnt",b_no);
	}
	@Override
	public List<BoardVO> listAll(Criteria cri) throws Exception {
		sqlSession.selectList(namespace + ".listAll",cri);
		return sqlSession.selectList(namespace + ".listAll", cri);
	}
	@Override
	public int listCount() throws Exception {
		sqlSession.selectOne(namespace + ".listCount");
		return sqlSession.selectOne(namespace + ".listCount");
	}
	@Override
	public List<BoardVO> listSearch(SearchCriteria scri) throws Exception {
		sqlSession.selectList(namespace + ".listSearch", scri);
		return sqlSession.selectList(namespace + ".countSearch", scri);
	}
	@Override
	public int countSearch(SearchCriteria scri) throws Exception {
		sqlSession.selectOne(namespace + ".countSearch", scri);
		return sqlSession.selectOne(namespace + ".countSearch", scri);
	}
	
}

