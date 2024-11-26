package com.wywin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ExchangeRate extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동으로 ID가 증가하도록 설정
    private Long id;  // 고정된 id 값

    // KRW를 기준으로 한 USD -> 원화 환율
    @Column(nullable = false)
    private BigDecimal usdToKrw;

    // KRW를 기준으로 한 JPY -> 원화 환율
    @Column(nullable = false)
    private BigDecimal jpyToKrw;

}
