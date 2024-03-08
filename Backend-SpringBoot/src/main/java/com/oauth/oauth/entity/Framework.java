package com.oauth.oauth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Framework {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer frameworkId;
    String name;
    @Column(columnDefinition = "TEXT")
    String description;
    String popularity;
    String learning_curve;
    String community_support;
    String performance;
}
