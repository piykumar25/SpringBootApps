package com.coder.coderschool.repository;

import com.coder.coderschool.model.CoderClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoderClassRepository extends JpaRepository<CoderClass, Integer> {
}
