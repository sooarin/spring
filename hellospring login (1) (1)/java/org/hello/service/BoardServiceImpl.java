package org.hello.service;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.hello.dao.BoardDAO;
import org.hello.domain.BoardVO;
import org.hello.domain.Criteria;
import org.hello.domain.SearchCriteria;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
 
@Service
public class BoardServiceImpl implements BoardService {
 
    @Inject
    private BoardDAO dao;
    
    

    
    
    
    
    
    @Override
    public void create(BoardVO vo) throws Exception {
    	dao.create(vo);
    }
    
   
 
  
    @Override
    public BoardVO read(Integer b_no) throws Exception {
    	dao.updateViewCnt(b_no);
    	
        return dao.read(b_no);
    }
 
    @Override
    public void delete(Integer b_no) throws Exception {
        dao.delete(b_no);
 
    }
 
    @Override
    public void update(BoardVO vo) throws Exception {
        
        dao.update(vo);
 
    }
    @Override
    public List<BoardVO> listAll(Criteria cri) throws Exception {
    	dao.listAll(cri);
    	return dao.listAll(cri);
    }
    @Override
    public int listCount() throws Exception {
    	dao.listCount();
    	return dao.listCount();
    }
    @Override
    public List<BoardVO> listSearch(SearchCriteria scri) throws Exception {
    	dao.listSearch(scri);
    	return dao.listSearch(scri);
    }
    @Override
    public int countSearch(SearchCriteria scri) throws Exception{
    	dao.countSearch(scri);
    	return dao.countSearch(scri);
    }
}

