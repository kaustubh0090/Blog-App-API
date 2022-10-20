package com.blog.app.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty
    private String categoryName;

    @NotEmpty
    private String categoryDescription;


}
