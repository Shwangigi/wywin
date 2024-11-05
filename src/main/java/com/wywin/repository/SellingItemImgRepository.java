package com.wywin.repository;

import com.wywin.entity.SellingItem;
import com.wywin.entity.SellingItemImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface SellingItemImgRepository extends JpaRepository<SellingItemImg, Long> {

    // 'id' 대신 'sid' 사용
    List<SellingItemImg> findBySellingItem_SidOrderBySidAsc(Long sellingId); // Sid를 기준으로 정렬


}
