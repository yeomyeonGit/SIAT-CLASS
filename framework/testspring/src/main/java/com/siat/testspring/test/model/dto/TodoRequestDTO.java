package com.siat.testspring.test.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
// @Schema
public class TodoRequestDTO {
    /*
    Validation 할 수 있는 Annotation
    @NotNull, @NotEmpty, @NotBlank, @Past, @PastOrPresent
    @Size, @Min, @Max, @Pattern(정규식)
     */

    @NotBlank(message = "타이틀은 필수입력 요청")
    private String title ;

    @NotBlank(message = "내용은 필수입력 요청")
    private String content ;

    @Pattern(regexp = "^\\d{2,3}-\\d{4}-\\d{4}$", message = "핸드폰 번호 형식에 맞게 입력하세요")
    private String phone ;

    private String startDate ;
    private String endDate ;
    private String status ;
    
    @Min(value = 1, message = "1~10 사이의 값을 입력하세요.")
    @Max(value = 10, message = "1~10 사이의 값을 입력하세요.")
    private int    priority ;
    
}
