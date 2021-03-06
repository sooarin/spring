package org.hello.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hello.domain.BoardVO;
import org.hello.domain.Criteria;
import org.hello.domain.SearchCriteria;


 
public interface BoardService {
    
    
    public void create(BoardVO vo) throws Exception;
    public BoardVO read(Integer b_no) throws Exception;
    
    public void delete(Integer b_no) throws Exception;
    
    public void update(BoardVO vo) throws Exception;

    public List<BoardVO> listAll(Criteria cri) throws Exception;
    
    public int listCount() throws Exception;
    
    public List<BoardVO> listSearch(SearchCriteria scri) throws Exception;
    
    public int countSearch(SearchCriteria scri) throws Exception; 
}

