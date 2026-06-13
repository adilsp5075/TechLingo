package com.techlingo.modules.admin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseRequest {
    @NotBlank
    private String name;
    private String description;
    private String iconUrl;
}
