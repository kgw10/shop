package com.shop.Dto;


import com.shop.constant.ItemCategory;
import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemForm {

    private Long id;

    @NotBlank(message = "상품명은 필수 입니다.")
    private String itemName;

    @NotBlank(message = "가격은 필수 입력 입니다.")
    private Integer price;

    @NotBlank(message="재고는 필수 입력입니다.")
    private Integer itemDetail;

    private ItemCategory itemCategory;
    private ItemSellStatus itemSellStatus;

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();
    private LocalDateTime regTime;  // 최초 등록일
    private LocalDateTime updateTiem;   // 수정 일

}
