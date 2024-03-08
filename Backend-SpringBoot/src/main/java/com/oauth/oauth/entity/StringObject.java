package com.oauth.oauth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StringObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer Id;
    String description;
}
