package com.testsber.sber.controller;

import com.testsber.sber.mappers.GoodsMapper;
import com.testsber.sber.model.dto.ErrorDTO;
import com.testsber.sber.model.dto.GoodDTO;
import com.testsber.sber.model.dto.ResponseDTO;
import com.testsber.sber.service.GoodsService;
import com.testsber.sber.util.Status;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

// TODO
//  /* Перенести все DTO в сервис

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor()
@RequestMapping("/goods")
public class MainController {

    private final GoodsService employeeService;
    private final GoodsMapper goodsMapper;

    @ExceptionHandler(Exception.class)
    public ResponseEntity processIncorrectJson(Exception e) {
        log.warn("Server error", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(ErrorDTO.builder()
                        .message("Server Error")
                        .build());
    }

    /**
     * Post good Controller
     * Принимает валидный DTO, завернет запрос если поля неверны
     * Делает новую запись в базу данных.
     *
     * @param goodDTO
     * @return результат выполнения
     */

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> postField(
            @Valid @RequestBody GoodDTO goodDTO) {

        log.info("Start Post request");
        System.out.println(goodDTO);
        GoodDTO goodDTOResult = employeeService
                .saveGood(goodDTO);

        ResponseDTO responseDTO = ResponseDTO
                .builder()
                .id(goodDTOResult.getId())
                .message("Ok").build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDTO);

    }


    /**
     * Delete good Controller
     * Удалает запись в базе данных по ID
     *
     * @param id
     * @return результат выполнения
     */
    @DeleteMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> deleteGood(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseDTO.builder()
                        .id(id)
                        .message("Delete Success")
                        .build());
    }

    /**
     * Put good Controller
     * Обновляет запись контроллера, если во входящем DTO есть id
     *
     * @param goodDTO
     * @return результат выполнения
     */
    @PutMapping
    public ResponseEntity<ResponseDTO> updateGood(@Valid @RequestBody GoodDTO goodDTO) {

        if (Objects.nonNull(goodDTO) && Objects.nonNull(goodDTO.getId())) {
            var entity = employeeService.getById(goodDTO.getId());
            if (Objects.nonNull(entity)) {
                var newEntity = goodsMapper.toEntity(goodDTO);
                newEntity.setId(entity.getId());
                employeeService.update(newEntity);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(ResponseDTO.builder()
                                .id(goodDTO.getId())
                                .message(Status.SUCCESS)
                                .build());
            }
        }
        return ResponseEntity.badRequest()
                .body(ResponseDTO.builder()
                        .id(0L).message(Status.ERROR).build());
    }

    /**
     * Get good Controller
     * Геттер по запросу по id. Один запрос - один товар
     *
     * @param id
     * @return результат выполнения
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<GoodDTO> showGood(@PathVariable Long id) {
        GoodDTO goodDTO = goodsMapper.toDto(employeeService.getById(id));
        if (Objects.nonNull(goodDTO)) {
            return ResponseEntity.ok(goodDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}


