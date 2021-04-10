package doyun.lee.api.rpl.service;

import doyun.lee.api.rpl.domain.Reply;
import doyun.lee.api.rpl.domain.ReplyDto;

import java.util.List;
import java.util.Optional;

public interface ReplyService {

    long save(Reply t);

    long delete(Reply rplNo);

    long count();

    Reply getOne(long id);

    Optional<Reply> findById(long id);

    Boolean existsById(long id);

    long update(ReplyDto t);

    List<Reply> replyListAll();

    Reply findByRpl(Reply rplNo);
}
