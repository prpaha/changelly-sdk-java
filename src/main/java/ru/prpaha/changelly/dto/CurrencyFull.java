package ru.prpaha.changelly.dto;

import lombok.Getter;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
public class CurrencyFull {

    private String name;
    private String ticker;
    private String fullName;
    private boolean enabled;
    private boolean enabledFrom;
    private boolean enabledTo;
    private boolean fixRateEnabled;
    private int payinConfirmations;
    private String extraIdName;
    private String addressUrl;
    private String transactionUrl;
    private String image;
    private long fixedTime;

}
