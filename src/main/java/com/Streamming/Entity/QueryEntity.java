package com.Streamming.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryEntity {
    private int type;
    private String pillName;
    //private String pillNum;


    // 출력 결과수 5개로 제한하기
    private final String numOfRows = "5";
}
