package com.task.model.Qna.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class QnaRequestDTO {
    private int qna_id;
    private String title;
    private String content;
    private String writer;
}
