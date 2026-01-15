package com.task.model.Qna.service;

import com.task.model.Qna.dao.QnaDAO;
import com.task.model.Qna.dto.QnaRequestDTO;
import com.task.model.Qna.vo.QnaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaService {

    private final QnaDAO qnaDAO;

    //추가
    public void addQna(QnaRequestDTO qnaRequestDTO) {
        QnaVO qnaVO = QnaVO.builder()
                .title(qnaRequestDTO.getTitle())
                .content(qnaRequestDTO.getContent())
                .writer(qnaRequestDTO.getWriter())
                .build();
        qnaDAO.insertQna(qnaVO);
    }


    //전체 조회
    public List<QnaVO> findAll() {
        return qnaDAO.findAll();
    }

    //Id로 조회
    public List<QnaVO> findById(int qna_id) {
        return qnaDAO.findById(qna_id);
    }

    //답변 완료된 qna만 조회
    public List<QnaVO> findComplete() {
        return qnaDAO.findComplete();
    }


    //수정
    public void updateQna(QnaRequestDTO qnaRequestDTO,int qna_id) {
        QnaVO qnaVO = QnaVO.builder()
                .qna_id(qna_id)
                .title(qnaRequestDTO.getTitle())
                .writer(qnaRequestDTO.getWriter())
                .content(qnaRequestDTO.getContent())
                .build();
        qnaDAO.updateQna(qnaVO);
    }

    //삭제
    public void deleteQna(int qna_id) {
        qnaDAO.deleteQna(qna_id);
    }

    // 증가
    public void updateCnt(int qna_id) {
        qnaDAO.updateCnt(qna_id);
    }

    public void updateStatus(int qna_id) {
        qnaDAO.updateStatus(qna_id);
    }
}
