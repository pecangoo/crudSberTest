package com.testsber.sber.model.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * GoodDTO
 * Data object good
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodDTO {

    private Long id;

    @NotBlank(message = "Category Empty")
    private String category;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date yearOfIssue;

    @Min(1)
    @NotNull
    @NotBlank
    private Long price;

    @NotNull
    @NotBlank
    private String description;

}