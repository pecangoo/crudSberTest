package com.testsber.sber.service;


import com.testsber.sber.model.entity.GoodEntity;
import com.testsber.sber.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {

    EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Service save good
     *
     * @param employeeModel
     * @throws Exception
     */
    public Long saveGood(GoodEntity employeeModel) throws Exception {
        log.info("Service save good");
        return employeeRepository.save(employeeModel).getId();
    }

    /**
     * Service delete good
     *
     * @param id
     * @throws Exception
     */
    public void deleteById(Long id) throws Exception {
        // Todo: Can check existing in database, and delete if exist.
        log.info("Service delete good");
        employeeRepository.deleteById(id);
    }

    /**
     * Service update good
     *
     * @param goodEntity
     * @throws Exception
     */
    @Transactional
    public void update(GoodEntity goodEntity) throws Exception {
        log.info("Service update good");
        employeeRepository.save(goodEntity);
    }

    /**
     * Service getById good
     *
     * @param id
     * @throws Exception
     */
    public GoodEntity getById(Long id) throws Exception {
        log.info("Service getById good");
        return employeeRepository.getReferenceById(id);
    }

}
