package com.techlingo.modules.user.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "userStats")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStats {
    
    @Id
    private String id;
    private String userId;
    private long xp;
    private int currentLevel;
    private int streakCount;
    private int lives;
    private LocalDate lastActiveDate;

}
