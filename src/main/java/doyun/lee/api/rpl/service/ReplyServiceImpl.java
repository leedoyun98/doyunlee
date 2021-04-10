package doyun.lee.api.rpl.service;

import doyun.lee.api.brd.domain.Board;
import doyun.lee.api.brd.domain.BoardDto;
import doyun.lee.api.brd.repository.BoardRepository;
import doyun.lee.api.rpl.domain.Reply;
import doyun.lee.api.rpl.domain.ReplyDto;
import doyun.lee.api.rpl.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
    private final ReplyRepository repository;

    @Override public long save(Reply t) {
        String date = String.format("%s %s", LocalDate.now(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("a HH시 mm분")));
        t.setRplWrtDate(date);
        return (repository.save(t)!=null) ? 1:0;

    }
    @Override public long count() {return (long)repository.count();}
    @Override public Reply getOne(long id) {return repository.getOne(id);}
    @Override public Optional<Reply> findById(long id){return repository.findById(id);}

    @Override
    public Boolean existsById(long id) {
         return repository.existsById(id);
    }


    @Override
    public long delete(Reply t) {
        repository.delete(t);
        return (getOne(t.getRplNo())==null)? 1:0;
    }



    public List<Reply> replyListAll() {
        return repository.findAll().stream().sorted(Comparator.comparing(Reply::getRplWrtDate).reversed()).collect(Collectors.toList());
    }

    @Override
    public Reply findByRpl(Reply rplNo) {
        return repository.findByRpl(rplNo);
    }


    public long update(ReplyDto dto) {
        Reply map = findById(dto.getRplNo()).get();
        map.setRplContent(dto.getRplContent());
        return repository.save(map)==null? 1:0;
    }
    public long replyBrdNo(){
//        return repository.replyBrdNo();
        return 1;
    }
}
