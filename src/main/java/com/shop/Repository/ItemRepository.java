package com.shop.Repository;

import com.shop.Entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value="SELECT * FROM item ORDER By RAND() LIMIT :limit", nativeQuery = true)
    List<Item> findRandomItem(@Param("limit") int limit);

    List<Item> findAllByOrderByRegTimeDesc(Pageable pageable);
}
