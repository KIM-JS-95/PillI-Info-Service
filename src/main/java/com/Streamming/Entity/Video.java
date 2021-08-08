package com.Streamming.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String path;

    private String like;


}
