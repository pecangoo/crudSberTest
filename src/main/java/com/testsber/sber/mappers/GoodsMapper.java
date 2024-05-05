package com.testsber.sber.mappers;

import com.testsber.sber.model.dto.GoodDTO;
import com.testsber.sber.model.entity.GoodEntity;
import org.springframework.stereotype.Service;

/**
 * Dto/Entity DTO Сдфыы
 * Геттер по запросу по id. Один запрос - один товар
 */

@Service
public class GoodsMapper implements Mapper<GoodEntity, GoodDTO> {
    @Override
    public GoodDTO toDto(GoodEntity good) {
        GoodDTO goodDTO =
                GoodDTO.builder()
                        .name(good.getName())
                        .category(good.getCategory())
                        .description(good.getDescription())
                        .yearOfIssue(good.getYearOfIssue())
                        .price(good.getPrice())
                        .id(good.getId()).build();
        return goodDTO;
    }

    @Override
    public GoodEntity toEntity(GoodDTO goodDTO) {
        GoodEntity good = GoodEntity.builder()
                .name(goodDTO.getName())
                .category(goodDTO.getCategory())
                .description(goodDTO.getDescription())
                .yearOfIssue(goodDTO.getYearOfIssue())
                .price(goodDTO.getPrice())
                .build();
        return good;
    }


}
