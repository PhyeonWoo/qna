package com.task.model.Qna.service;

import com.task.model.Qna.dao.QnaDAO;
import com.task.model.Qna.dto.CommentRequestDTO;
import com.task.model.Qna.vo.CommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final QnaDAO qnaDAO;

    //추가
    public void addComment(CommentRequestDTO commentRequestDTO,int qna_id) {
        CommentVO commentVO = CommentVO.builder()
                .qna_id(qna_id)
                .content(commentRequestDTO.getContent())
                .writer(commentRequestDTO.getWriter())
                .build();
        qnaDAO.insertComment(commentVO);
    }

    //수정
    public void updateComment(int comment_id, CommentRequestDTO commentRequestDTO) {
        CommentVO commentVO = CommentVO.builder()
                .comment_id(comment_id)
                .writer(commentRequestDTO.getWriter())
                .content(commentRequestDTO.getContent())
                .build();
        qnaDAO.updateComment(commentVO);
    }

}
