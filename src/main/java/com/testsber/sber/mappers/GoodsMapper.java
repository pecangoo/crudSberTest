package com.testsber.sber.mappers;

import com.testsber.sber.model.dto.GoodDTO;
import com.testsber.sber.model.entity.GoodEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * Dto/Entity DTO Сдфыы
 * Геттер по запросу по id. Один запрос - один товар
 */
@Slf4j
public class GoodsMapper {

    public static GoodDTO toDto(GoodEntity good) {
        log.info("to Dto Mapping");
        GoodDTO goodDTO = new GoodDTO();
        goodDTO.setName(good.getName());
        goodDTO.setCategory(good.getCategory());
        goodDTO.setDescription(good.getDescription());
        goodDTO.setYearOfIssue(good.getYearOfIssue());
        goodDTO.setPrice(good.getPrice());
        goodDTO.setId(good.getId());
        return goodDTO;
    }

    public static GoodEntity toEntity(GoodDTO goodDTO) {
        log.info("to Entity Mapping");
        GoodEntity good = new GoodEntity();
        good.setName(goodDTO.getName());
        good.setCategory(goodDTO.getCategory());
        good.setDescription(goodDTO.getDescription());
        good.setYearOfIssue(goodDTO.getYearOfIssue());
        good.setPrice(goodDTO.getPrice());
        good.setId(goodDTO.getId());
        return good;
    }

}
