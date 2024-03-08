package com.oauth.oauth.dao;

import com.oauth.oauth.entity.Framework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrameworksDAO extends JpaRepository<Framework, Integer> {
}
