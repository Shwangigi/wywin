package com.wywin.controller;

import com.wywin.dto.SellingItemDTO;
import com.wywin.dto.SellingItemFormDTO;
import com.wywin.service.SellingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SellingController {

    private final SellingService sellingService;


    // 판매 등록 폼 이동
    @GetMapping("/sellings/new")
    public String createSellingForm(Model model) {
        model.addAttribute("sellingItemFormDTO", new SellingItemFormDTO()); // SellingItemFormDTO로 수정
        return "sellings/sellingNew";
    }


    // 판매 등록
    @PostMapping("/sellings/new")
    public String createSelling(@Valid SellingItemFormDTO sellingItemFormDTO, BindingResult bindingResult,
                                Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList) {

        // 입력 검증 오류가 있는 경우 다시 폼을 반환
        if (bindingResult.hasErrors()) {
            return "sellings/sellingNew"; // 수정된 경로
        }

        // 첫 번째 이미지가 비어 있는 경우 오류 메시지 추가 후 폼 반환
        if (itemImgFileList.get(0).isEmpty()) {
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값 입니다.");
            return "sellings/sellingNew"; // 수정된 경로
        }

        try {
            // 상품 및 이미지 저장 처리
            sellingService.saveSellingItem(sellingItemFormDTO, itemImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
            return "sellings/sellingNew"; // 수정된 경로
        }

        // 성공적으로 등록된 경우 상품 목록 페이지로 리다이렉트
        return "redirect:/sellings/sellingList";
    }


}
