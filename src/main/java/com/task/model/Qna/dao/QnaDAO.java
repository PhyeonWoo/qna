package com.task.model.Qna.dao;

import com.task.model.Qna.vo.CommentVO;
import com.task.model.Qna.vo.QnaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaDAO {

    //추가
    void insertQna(QnaVO qnaVO);
    void insertComment(CommentVO commentVO);


    //전체 조회
    List<QnaVO> findAll();
    //ID별로 Qna 조회
    List<QnaVO> findById(int qna_id); // Comment 까지 같이 출력
    // 답변 완료된 질문만 조회
    List<QnaVO> findComplete();


    //수정
    void updateQna(QnaVO qnaVO);
    void updateComment(CommentVO commentVO);

    //답변 상태 변경
    void updateStatus(int qna_id);
    //조회수 증가
    void updateCnt(int qna_id);

    //Qna Id로 삭제
    void deleteQna(int qna_id);
}
