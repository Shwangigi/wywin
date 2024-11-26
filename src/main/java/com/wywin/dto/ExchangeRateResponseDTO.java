package com.wywin.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class ExchangeRateResponseDTO {

    private String result;  // API 응답 상태 (예: "success")

    private Map<String, BigDecimal> conversionRates;  // 환율 정보 (USD -> KRW, JPY -> KRW 등)

    // 객체를 잘 출력하기 위한 toString() 오버라이드
    @Override
    public String toString() {
        return "ExchangeRateResponseDTO{" +
                "result='" + result + '\'' +
                ", conversionRates=" + conversionRates +
                '}';
    }
}
