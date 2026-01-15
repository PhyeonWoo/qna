package com.task.model.Faq.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class FaqRequestDTO {
    private int faq_id;
    private int sort_order;
    private String question;
    private String answer;
    private boolean published;
    private String created_by;
}
