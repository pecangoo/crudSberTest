package com.testsber.sber.service;


import com.testsber.sber.mappers.Mapper;
import com.testsber.sber.model.dto.GoodDTO;
import com.testsber.sber.model.entity.GoodEntity;
import com.testsber.sber.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Slf4j
public class GoodsService {

    private final GoodsRepository goodsRepository;
    private final Mapper<GoodEntity, GoodDTO> mapper;

    /**
     * Service save good
     *
     * @param goodDTO
     * @throws Exception
     */
    public GoodDTO saveGood(GoodDTO goodDTO) {
        log.info("Service save good");
        return mapper.toDto(goodsRepository.save(mapper.toEntity(goodDTO)));
    }

    /**
     * Service delete good
     *
     * @param id
     * @throws Exception
     */
    public void deleteById(Long id) {
        // Todo: Can check existing in database, and delete if exist.
        log.info("Service delete good");
        goodsRepository.deleteById(id);
    }

    /**
     * Service update good
     *
     * @param goodEntity
     * @throws Exception
     */

    public void update(GoodEntity goodEntity) {
        log.info("Service update good");
        goodsRepository.save(goodEntity);
    }

    /**
     * Service getById good
     *
     * @param id
     * @throws Exception
     */
    public GoodEntity getById(Long id) {
        log.info("Service getById good");
        return goodsRepository.getReferenceById(id);
    }

    public Page<GoodEntity> findAll(Pageable pageable) {
        log.info("Service getById good");
        return goodsRepository.findAll(pageable);
    }


}
