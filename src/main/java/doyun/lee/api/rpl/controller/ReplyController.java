package doyun.lee.api.rpl.controller;


import doyun.lee.api.brd.domain.Board;
import doyun.lee.api.brd.service.BoardServiceImpl;
import doyun.lee.api.rpl.domain.Reply;
import doyun.lee.api.rpl.domain.ReplyDto;
import doyun.lee.api.rpl.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/replies")
public class ReplyController {
    private final ReplyService service;

    private  final BoardServiceImpl boardService;
    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody Reply t) {
        return ResponseEntity.ok(service.save(t));
    }

    @DeleteMapping("/delete/{rplNo}")
    public ResponseEntity<Long> delete(@PathVariable Reply rplNo) {
        System.out.println("삭제");
        return ResponseEntity.ok(service.delete(rplNo));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Reply> getOne(@PathVariable long id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Reply>> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id) {
        return ResponseEntity.ok(service.existsById(id));
    }

    @GetMapping("/replyAll")
    public ResponseEntity<List<Reply>> replyListAll() {
        return ResponseEntity.ok(service.replyListAll());
    }

    @PutMapping("/update/{rplNo}")
    public ResponseEntity<Long> update(@PathVariable long rplNo,@RequestBody ReplyDto t) {
        System.out.println("업데이트"+t.toString());
        return ResponseEntity.ok(service.update(t));

    }
    @GetMapping("/select/{rplNo}")
    public ResponseEntity<Reply> findByRpl(@PathVariable Reply rplNo){
        System.out.println("댓글 페이지");
        return ResponseEntity.ok(service.findByRpl(rplNo));
    }

}
