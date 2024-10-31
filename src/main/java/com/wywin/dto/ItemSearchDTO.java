package com.wywin.dto;

import com.wywin.constrant.ItemStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchDTO {

    private String searchDateType;

    private ItemStatus  searchSellStatus;

    private String searchBy;

    private String searchQuery = "";
}
