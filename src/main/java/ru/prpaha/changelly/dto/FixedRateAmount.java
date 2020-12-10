package ru.prpaha.changelly.dto;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
public class FixedRateAmount {

    private String id;
    private BigDecimal rate;
    private Currency from;
    private Currency to;
    private BigDecimal amountFrom;
    private BigDecimal amountTo;

}
