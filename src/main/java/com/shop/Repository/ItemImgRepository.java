package com.shop.Repository;


import com.shop.Entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

    static List<ItemImg> findByItemIdOrderByIdAsc(Long id) {
    }

    ItemImg findByitemIdAndRepImgYn(Long id, String y);
}
