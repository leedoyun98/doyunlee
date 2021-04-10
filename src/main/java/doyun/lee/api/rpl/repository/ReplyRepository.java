package doyun.lee.api.rpl.repository;

import doyun.lee.api.brd.domain.Board;
import doyun.lee.api.rpl.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface IReplyRepository{
    Reply findByRpl(Reply rplNo);
//    long replyBrdNo();

    //List<Long> replyListAll();

}

public interface ReplyRepository extends JpaRepository<Reply, Long>, IReplyRepository {

}
