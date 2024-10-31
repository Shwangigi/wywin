package com.wywin.service;

import com.wywin.dto.SellingItemFormDTO;
import com.wywin.entity.SellingItem;
import com.wywin.entity.SellingItemImg;
import com.wywin.repository.SellingItemImgRepository;
import com.wywin.repository.SellingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SellingService{

    private final SellingRepository sellingRepository; // 리포지토리 의존성 주입
    private final SellingItemImgService sellingItemImgService;
    private final SellingItemImgRepository sellingItemImgRepository;

    public Long saveSellingItem(SellingItemFormDTO sellingItemFormDTO, List<MultipartFile> itemImgFileList) throws Exception {

        // 상품 등록
        SellingItem sellingItem = sellingItemFormDTO.createItem(); // 등록 폼에서 받은 데이터로 객체 생성
        sellingRepository.save(sellingItem);                               // DB에 저장

        // 이미지 등록
        for (int i = 0; i < itemImgFileList.size(); i++) {
            SellingItemImg sellingItemImg = new SellingItemImg();
            sellingItemImg.setSellingItem(sellingItem);

            if (i == 0)
                sellingItemImg.setSrepimgYn("Y");       // 첫 번째 이미지는 대표 이미지로 설정
            else
                sellingItemImg.setSrepimgYn("N");

            sellingItemImgService.saveItemImg(sellingItemImg, itemImgFileList.get(i)); // 상품 이미지 저장
        }

        return sellingItem.getSid();                    // 저장된 상품 ID 반환
    }


}
