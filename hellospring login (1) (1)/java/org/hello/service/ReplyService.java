package org.hello.service;
import java.util.List;
import org.hello.domain.ReplyVO;
public interface ReplyService {
	public List<ReplyVO> readReply(int b_no) throws Exception;
	public void writeReply(ReplyVO vo) throws Exception;
}
