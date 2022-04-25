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
    private String pillNum;
}
