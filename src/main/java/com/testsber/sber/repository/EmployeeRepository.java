package com.testsber.sber.repository;

import com.testsber.sber.model.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<GoodEntity, Long> {
}
