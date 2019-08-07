package org.hello.service;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.hello.domain.ReplyVO;
import org.hello.dao.ReplyDAO;
@Repository
public class ReplyServiceImpl implements ReplyService {
	@Inject
	private ReplyDAO dao;
	@Override
	public List<ReplyVO> readReply(int b_no) throws Exception {
		dao.readReply(b_no);
		return dao.readReply(b_no);
	}
	@Override
	public void writeReply(ReplyVO vo) throws Exception{
		dao.writeReply(vo);
	}
}
