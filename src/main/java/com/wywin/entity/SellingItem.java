package com.wywin.entity;

import com.wywin.constrant.ItemStatus;
import com.wywin.dto.SellingItemFormDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sellingItem")
@Getter
@Setter
@ToString
public class SellingItem extends BaseEntity{

    @Id
    @Column(name="sellingItem_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid; // 판매코드

    @Column(nullable = false, length = 50)
    private String sitemNm; // 판매 아이템 이름

    @Column(name = "price", nullable = false)
    private int sprice; // 판매 가격

    @Lob
    @Column(nullable = false)
    private String itemDetail;  // 상품 상세 설명

    @Column(nullable = false)
    private int stockNumbers;   // 재고수량

    private String seller; // 판매자

    private String buyer; // 구매자

    private int quantity; // 구매 수량

    private LocalDateTime sellingDate; // 판매일

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus; // 판매 상태

    @OneToMany(mappedBy = "sellingItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SellingItemImg> sellingImgs = new ArrayList<>();


    // 상품 업데이트
    public void updateItem(SellingItemFormDTO sellingItemFormDTO){
        // 엔티티 클래스에 비즈니스 로직을 추가하면 조금 더 객체지향적으로 코딩할 수 있고, 코드 재활용 가능
        this.sitemNm = sellingItemFormDTO.getSitemNm();
        this.sprice = sellingItemFormDTO.getSprice();
        this.stockNumbers = sellingItemFormDTO.getStockNumbers();
        this.itemDetail = sellingItemFormDTO.getItemDetail();
        this.itemStatus = sellingItemFormDTO.getItemStatus();
    }
}
