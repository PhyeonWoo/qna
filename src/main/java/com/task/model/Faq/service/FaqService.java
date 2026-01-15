package com.task.model.Faq.service;

import com.task.model.Faq.dao.FaqDAO;
import com.task.model.Faq.dto.FaqRequestDTO;
import com.task.model.Faq.vo.FaqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqService {
    private final FaqDAO faqDAO;

    public void insertFaq(FaqRequestDTO faqRequestDTO) {
        FaqVO faqVO = FaqVO.builder()
                .sort_order(faqRequestDTO.getSort_order())
                .answer(faqRequestDTO.getAnswer())
                .created_by(faqRequestDTO.getCreated_by())
                .published(faqRequestDTO.isPublished())
                .question(faqRequestDTO.getQuestion())
                .build();
        faqDAO.insertFaq(faqVO);
    }

    public List<FaqVO> findAll() {
        return faqDAO.findAll();
    }

    public List<FaqVO> findById(int faq_id) {
        return faqDAO.findById(faq_id);
    }

    public List<FaqVO> findPublished() {
        return faqDAO.findPublished();
    }


    public void updateFaq(FaqRequestDTO faqRequestDTO, int faq_id) {
        FaqVO faqVO = FaqVO.builder()
                .faq_id(faq_id)
                .sort_order(faqRequestDTO.getSort_order())
                .answer(faqRequestDTO.getAnswer())
                .created_by(faqRequestDTO.getCreated_by())
                .published(faqRequestDTO.isPublished())
                .question(faqRequestDTO.getQuestion())
                .build();
        faqDAO.updateFaq(faqVO);
    }

}
