package com.oauth.oauth.dao;

import com.oauth.oauth.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguagesDAO extends JpaRepository<Language,String> {
}
