package com.testsber.sber.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Good Entity
 * Data object good
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "EmplayeesCards", schema = "public")
public class GoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category Empty")
    private String category;

    @NotNull
    private String name;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date yearOfIssue;

    @NotNull
    private Long price;

    @NotNull
    private String description;


}


/*
Имя
Фамилия
Дата Рождения  Должность
 */


