package com.task.controller;

import com.task.common.response.ApiResponse;
import com.task.model.Qna.dto.QnaRequestDTO;
import com.task.model.Qna.service.QnaService;
import com.task.model.Qna.vo.QnaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnaController {
    private final QnaService qnaService;

    @PostMapping("/add")
    public ResponseEntity<String> addQna(@RequestBody QnaRequestDTO qnaRequestDTO) {
        qnaService.addQna(qnaRequestDTO);
        return new ResponseEntity<>("생성 완료", HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<ApiResponse<List<QnaVO>>> findAll() {
        List<QnaVO> all = qnaService.findAll();
        return ResponseEntity.ok(ApiResponse.createSuccess(all));
    }


    @GetMapping("/find/{qna_id}")
    public ResponseEntity<ApiResponse<List<QnaVO>>> findById(@PathVariable int qna_id) {
        List<QnaVO> list = qnaService.findById(qna_id);
        return ResponseEntity.ok(ApiResponse.createSuccess(list));
    }


    @GetMapping("/findComplete")
    public ResponseEntity<ApiResponse<List<QnaVO>>> findComplete() {
        List<QnaVO> completeList = qnaService.findComplete();
        return ResponseEntity.ok(ApiResponse.createSuccess(completeList));
    }



    @PutMapping("/update/{qna_id}")
    public ResponseEntity<String> updateQna(@PathVariable int qna_id, @RequestBody QnaRequestDTO qnaRequestDTO) {
        qnaService.updateQna(qnaRequestDTO, qna_id);
        return new ResponseEntity<>("수정 완료",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{qna_id}")
    public ResponseEntity<String> deleteQna(@PathVariable int qna_id) {
        qnaService.deleteQna(qna_id);
        return new ResponseEntity<>("삭제 완료",HttpStatus.OK);
    }

}
