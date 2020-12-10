package ru.prpaha.changelly.dto;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
public class FixedRate {

    private String id;
    private BigDecimal result;
    private Currency from;
    private Currency to;
    private BigDecimal maxFrom;
    private BigDecimal maxTo;
    private BigDecimal minFrom;
    private BigDecimal minTo;

}
