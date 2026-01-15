package com.task.controller;

import com.task.model.Qna.dto.CommentRequestDTO;
import com.task.model.Qna.service.CommentService;
import com.task.model.Qna.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    private final QnaService qnaService;

    @PostMapping("/add/{qna_id}")
    public ResponseEntity<String> addComment(@PathVariable int qna_id, @RequestBody CommentRequestDTO commentRequestDTO) {
        commentService.addComment(commentRequestDTO, qna_id);
        qnaService.updateStatus(qna_id);
        return new ResponseEntity<>("생성 완료", HttpStatus.CREATED);
    }

    @PutMapping("/update/{comment_id}")
    public ResponseEntity<String> updateComment(@PathVariable int comment_id, @RequestBody CommentRequestDTO commentRequestDTO) {
        commentService.updateComment(comment_id, commentRequestDTO);
        return ResponseEntity.ok("수정완료");
    }
}
