package com.wywin.repository;

import com.wywin.entity.SellingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SellingRepository extends JpaRepository<SellingItem, Long>{

}
