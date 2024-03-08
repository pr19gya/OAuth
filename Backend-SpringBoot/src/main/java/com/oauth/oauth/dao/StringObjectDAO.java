package com.oauth.oauth.dao;

import com.oauth.oauth.entity.StringObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StringObjectDAO extends JpaRepository<StringObject,Integer> {
}
