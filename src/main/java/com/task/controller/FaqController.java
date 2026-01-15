package com.task.controller;

import com.task.common.response.ApiResponse;
import com.task.model.Faq.dto.FaqRequestDTO;
import com.task.model.Faq.service.FaqService;
import com.task.model.Faq.vo.FaqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faq")
public class FaqController {
    private final FaqService faqService;

    @PostMapping("/add")
    public ResponseEntity<String> addFaq(@RequestBody FaqRequestDTO faqRequestDTO) {
        faqService.insertFaq(faqRequestDTO);
        return new ResponseEntity<>("생성 완료", HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<ApiResponse<List<FaqVO>>> findAll() {
        List<FaqVO> list = faqService.findAll();
        return ResponseEntity.ok(ApiResponse.createSuccess(list));
    }


    @GetMapping("/find/{faq_id}")
    public ResponseEntity<ApiResponse<List<FaqVO>>> findById(@PathVariable int faq_id) {
        List<FaqVO> list = faqService.findById(faq_id);
        return ResponseEntity.ok(ApiResponse.createSuccess(list));
    }

    @GetMapping("/findPublished")
    public ResponseEntity<ApiResponse<List<FaqVO>>> findPublished() {
        List<FaqVO> published = faqService.findPublished();
        return ResponseEntity.ok(ApiResponse.createSuccess(published));
    }



    @PutMapping("/update/{faq_id}")
    public ResponseEntity<String> updateFaq(@PathVariable int faq_id, @RequestBody FaqRequestDTO faqRequestDTO) {
        faqService.updateFaq(faqRequestDTO, faq_id);
        return new ResponseEntity<>("수정 완료",HttpStatus.OK);
    }

}
