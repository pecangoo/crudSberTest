package com.testsber.sber.repository;

import com.testsber.sber.model.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<GoodEntity, Long> {
}
