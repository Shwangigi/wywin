package com.wywin.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ExchangeRateDTO {

    private Long id;

    private BigDecimal usdToKrw;

    private BigDecimal jpyToKrw;

    private LocalDateTime regTime;  // 생성 시간

    private LocalDateTime updateTime;  // 수정 시간

    // 생성자
    public ExchangeRateDTO(Long id, BigDecimal usdToKrw, BigDecimal jpyToKrw, LocalDateTime regTime, LocalDateTime updateTime) {
        this.id = id;
        this.usdToKrw = usdToKrw;
        this.jpyToKrw = jpyToKrw;
        this.regTime = regTime;
        this.updateTime = updateTime;
    }

    // Entity -> DTO 변환
    public static ExchangeRateDTO fromEntity(ExchangeRateDTO exchangeRate) {
        return new ExchangeRateDTO(
                exchangeRate.getId(),
                exchangeRate.getUsdToKrw(),
                exchangeRate.getJpyToKrw(),
                exchangeRate.getRegTime(),
                exchangeRate.getUpdateTime()
        );
    }

}