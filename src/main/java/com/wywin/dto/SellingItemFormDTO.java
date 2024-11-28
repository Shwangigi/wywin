package com.wywin.dto;

import com.wywin.constant.ItemStatus;
import com.wywin.entity.SellingItem;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SellingItemFormDTO { // 프론트에서 넘어오는 객체 처리용

    private Long sid;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String sitemNm;

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Integer sprice;

    @NotBlank(message = "설명은 필수 입력 값입니다.")
    private String itemDetail;

    @NotNull(message = "재고는 필수 입력 값입니다.")
    private Integer stockNumbers;

    private String seller;

    private ItemStatus itemStatus;


    private List<SellingItemImgDTO> itemImgDtoList = new ArrayList<>();    // 상품 저장 후 수정할 때 상품 이미지 정보를 저장하는 리스트

    private List<Long> itemImgIds = new ArrayList<>();  // 상품의 이미지 아이디를 저장하는 리스트.

    private static ModelMapper modelMapper = new ModelMapper();

    // 엔티티 객체 생성 메서드
    public SellingItem createItem() {
        return modelMapper.map(this, SellingItem.class);
    }

    // 엔티티 -> DTO 변환 메서드
    public static SellingItemFormDTO of(SellingItem sellingItem) {
        return modelMapper.map(sellingItem, SellingItemFormDTO.class);
    }
}
