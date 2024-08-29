package com.shop.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainSlideImg {
    private Long id;    // 해당 상품의 id
    private String imgUrl;  // 해당 상품 대표 이미지 주소
    private String itemName;    // 해당 상품명
}
