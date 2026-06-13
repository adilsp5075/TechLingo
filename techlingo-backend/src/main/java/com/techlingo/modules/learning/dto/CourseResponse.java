package com.techlingo.modules.learning.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourseResponse {
    private String id;
    private String name;
    private String description;
    private String iconUrl;
}
