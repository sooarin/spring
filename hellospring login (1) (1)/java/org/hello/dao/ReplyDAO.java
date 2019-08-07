package org.hello.dao;
import java.util.List;
import org.hello.domain.ReplyVO;
public interface ReplyDAO {
	public List<ReplyVO> readReply(int b_no) throws Exception;
	public void writeReply(ReplyVO vo) throws Exception;
}
