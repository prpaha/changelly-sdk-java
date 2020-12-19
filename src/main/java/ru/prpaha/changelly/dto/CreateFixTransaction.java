package ru.prpaha.changelly.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateFixTransaction {

    private Currency from;
    private Currency to;
    private String address;
    private BigDecimal amountFrom;
    private BigDecimal amountTo;
    private String rateId;
    private String refundAddress;
    private String extraId;
    private String refundExtraId;

    private CreateFixTransaction(Currency from, Currency to, String address, BigDecimal amountFrom,
                                 BigDecimal amountTo, String refundAddress, String rateId) {
        this.from = from;
        this.to = to;
        this.address = address;
        this.amountFrom = amountFrom;
        this.amountTo = amountTo;
        this.refundAddress = refundAddress;
        this.rateId = rateId;
    }

    public static Builder createWithAmountFrom(final Currency from, final Currency to, final String address,
                                               final BigDecimal amountFrom, final String refundAddress,
                                               final String rateId) {
        if (from == null || to == null || StringUtils.isEmpty(address) || amountFrom == null
                || StringUtils.isEmpty(rateId) || StringUtils.isEmpty(refundAddress)) {
            throw new IllegalArgumentException("One of arguments is blank");
        }
        return new Builder()
                .withFrom(from)
                .withTo(to)
                .withAddress(address)
                .withAmountFrom(amountFrom)
                .withRefundAddress(refundAddress)
                .withRateId(rateId);
    }

    public static Builder createWithAmountTo(final Currency from, final Currency to, final String address,
                                             final BigDecimal amountTo, final String refundAddress,
                                             final String rateId) {
        if (from == null || to == null || StringUtils.isEmpty(address) || amountTo == null
                || StringUtils.isEmpty(rateId) || StringUtils.isEmpty(refundAddress)) {
            throw new IllegalArgumentException("One of arguments is blank");
        }
        return new Builder()
                .withFrom(from)
                .withTo(to)
                .withAddress(address)
                .withAmountTo(amountTo)
                .withRefundAddress(refundAddress)
                .withRateId(rateId);
    }

    public static class Builder {

        private Currency from;
        private Currency to;
        private String address;
        private BigDecimal amountFrom;
        private BigDecimal amountTo;
        private String rateId;
        private String refundAddress;
        private String extraId;
        private String refundExtraId;

        public Builder withFrom(final Currency from) {
            this.from = from;
            return this;
        }

        public Builder withTo(final Currency to) {
            this.to = to;
            return this;
        }

        public Builder withAddress(final String address) {
            this.address = address;
            return this;
        }

        public Builder withAmountFrom(final BigDecimal amountFrom) {
            this.amountFrom = amountFrom;
            return this;
        }

        public Builder withAmountTo(final BigDecimal amountTo) {
            this.amountTo = amountTo;
            return this;
        }

        public Builder withRateId(final String rateId) {
            this.rateId = rateId;
            return this;
        }

        public Builder withRefundAddress(final String refundAddress) {
            this.refundAddress = refundAddress;
            return this;
        }

        public Builder withExtraId(final String extraId) {
            this.extraId = extraId;
            return this;
        }

        public Builder withRefundExtraId(final String refundExtraId) {
            this.refundExtraId = refundExtraId;
            return this;
        }

        public CreateFixTransaction build() {
            if (amountFrom == null && amountTo == null) {
                throw new IllegalArgumentException("Amount can`t be NULL");
            }
            if ((amountFrom != null && amountFrom.compareTo(BigDecimal.ZERO) <= 0)
                    && (amountTo != null && amountTo.compareTo(BigDecimal.ZERO) <= 0)) {
                throw new IllegalArgumentException("Amount can`t be 0");
            }

            CreateFixTransaction transaction = new CreateFixTransaction(from, to, address, amountFrom,
                    amountTo, refundAddress, rateId);
            transaction.extraId = extraId;
            transaction.refundAddress = refundAddress;
            transaction.refundExtraId = refundExtraId;
            return transaction;
        }

    }

}
