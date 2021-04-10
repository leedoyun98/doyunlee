package doyun.lee.api.rpl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import doyun.lee.api.rpl.domain.Reply;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import static doyun.lee.api.rpl.domain.QReply.reply;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static doyun.lee.api.brd.domain.QBoard.board;

@Repository
public class ReplyRepositoryImpl extends QuerydslRepositorySupport implements IReplyRepository {
    private final JPAQueryFactory qf;
    private final EntityManager em;
    public ReplyRepositoryImpl(EntityManager em,JPAQueryFactory qf) {
        super(Reply.class);
        this.qf = qf;
        this.em = em;

    }

    @Override
    public Reply findByRpl(Reply rpl) {
        return qf.selectFrom(reply).where(reply.rplNo.eq(rpl.getRplNo())).fetchOne();
    }

//    @Override
//    public long replyBrdNo(long num) {
//        return qf.select(board.brdNo)
//                .from(reply)
//                .join(reply.board, board)
//                .where(board.brdNo.eq(num)).fetchOne();
//    }


//    @Override
//    public List<Long> replyListAll(){
////        return  qf.select(board.brdNo)
////                .from(board)
////                .join(board.replies, reply)
////                .where(reply.rBoard.brdNo.eq(board.brdNo)).fetch();
//        return null;
//
//    }

}
