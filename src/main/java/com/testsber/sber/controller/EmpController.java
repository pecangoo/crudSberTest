package com.testsber.sber.controller;

import com.testsber.sber.mappers.GoodsMapper;
import com.testsber.sber.model.dto.GoodDTO;
import com.testsber.sber.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
@Slf4j
@Validated
@RequestMapping("/goods")
public class EmpController {

    private final EmployeeService employeeService;

    public EmpController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * Post good Controller
     * Принимает валидный DTO, завернет запрос если поля неверны
     * Делает новую запись в базу данных.
     *
     * @param goodDTO
     * @return результат выполнения
     */

    @PostMapping
    public ResponseEntity<Map<String, String>> postField(
            @Valid @RequestBody GoodDTO goodDTO) {
        log.info("Start Post request");
        Map<String, String> response = new HashMap<>();
        try {
            Long id = employeeService.saveGood(GoodsMapper.toEntity(goodDTO));
            response.put("message", "Save Success");
            response.put("id", id.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            response.put("message", "Save Failed: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Delete good Controller
     * Удалает запись в базе данных по ID
     *
     * @param id
     * @return результат выполнения
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGood(@PathVariable Long id) {
        try {
            employeeService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Ok");
        } catch (Exception ex) {
            log.error("Failed to delete good with id: {}", id, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete good with id: " + id);
        }
    }

    /**
     * Put good Controller
     * Обновляет запись контроллера, если во входящем DTO есть id
     *
     * @param goodDTO
     * @return результат выполнения
     */
    @PutMapping
    public ResponseEntity<String> updateGood(@Valid @RequestBody GoodDTO goodDTO) {

        // TODO: Уделить особое внимание этому пункту и возвращаемым ответам в тестах

        try {
            if (goodDTO.getId() != null) {
                var entity = employeeService.getById(goodDTO.getId());
                if (entity != null) {
                    var newEntity = GoodsMapper.toEntity(goodDTO);
                    newEntity.setId(entity.getId());
                    employeeService.update(newEntity);
                    return ResponseEntity.ok("Update Success");
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Good not found");
                }
            } else {
                return ResponseEntity.badRequest().body("ID is required for update");
            }
        } catch (Exception e) {
            log.error("Error updating good", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Error");
        }
    }

    /**
     * Get good Controller
     * Геттер по запросу по id. Один запрос - один товар
     *
     * @param id
     * @return результат выполнения
     */
    @GetMapping("/{id}")
    public ResponseEntity<GoodDTO> showGood(@PathVariable Long id) {
        try {
            GoodDTO goodDTO = GoodsMapper.toDto(employeeService.getById(id));
            if (goodDTO != null) {
                return ResponseEntity.ok(goodDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            log.error("Error occurred while retrieving Good with id: {}", id, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
