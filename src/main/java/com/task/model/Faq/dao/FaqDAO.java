package com.task.model.Faq.dao;

import com.task.model.Faq.vo.FaqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqDAO {
    void insertFaq(FaqVO faqVO); //faq 등록

    List<FaqVO> findAll(); //faq 전체 조회
    List<FaqVO> findById(int faq_id); //faq id로 개별 조회
    List<FaqVO> findPublished(); //faq 공개가능한거만 조회


    void updateFaq(FaqVO faqVO); //faq 수정

}
