package ru.prpaha.changelly.dto;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
public class Transaction {

    private String id;
    private BigDecimal apiExtraFee;
    private BigDecimal changellyFee;
    private String payinExtraId;
    private String payoutExtraId;
    private String refundAddress;
    private BigDecimal amountExpectedFrom;
    private BigDecimal amountExpectedTo;
    private String payTill;
    private TransactionStatus status;
    private Currency currencyFrom;
    private Currency currencyTo;
    private BigDecimal amountTo;
    private String payinAddress;
    private String payoutAddress;
    private String createdAt;

}
