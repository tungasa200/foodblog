package com.__project01.foodBlog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MagazineFileDTO {

    private Long id;
    private Long articleId;
    private int sectionNum;
    private String originalFileName;
    private String storedFileName;
}
