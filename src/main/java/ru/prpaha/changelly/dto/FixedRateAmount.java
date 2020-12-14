package ru.prpaha.changelly.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
@NoArgsConstructor
public class FixedRateAmount {

    private String id;
    private BigDecimal rate;
    private Currency from;
    private Currency to;
    private BigDecimal amountFrom;
    private BigDecimal amountTo;

    public FixedRateAmount(Currency from, Currency to, BigDecimal amountFrom) {
        this.from = from;
        this.to = to;
        this.amountFrom = amountFrom;
    }

}
