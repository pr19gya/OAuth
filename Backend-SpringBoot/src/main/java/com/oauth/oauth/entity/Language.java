package com.oauth.oauth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String languageId;
    String language;
    String founder;
    Integer year_founder;
    @Column(columnDefinition = "TEXT")
    String description;
    String code_syntax;
    String website;
    //    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "languageId")
    @ElementCollection(targetClass = String.class)
    List<String> pros;
    //    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "languageId")
    @ElementCollection(targetClass = String.class)
    List<String> cons;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "languageId")
    List<Framework> popular_frameworks;
}
