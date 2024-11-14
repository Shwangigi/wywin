package com.wywin.service;

import com.wywin.dto.OrderDTO;
import com.wywin.dto.OrderHistDTO;
import com.wywin.entity.Member;
import com.wywin.entity.Order;
import com.wywin.entity.OrderItem;
import com.wywin.entity.SellingItem;
import com.wywin.repository.MemberRepository;
import com.wywin.repository.OrderRepository;
import com.wywin.repository.SellingItemImgRepository;
import com.wywin.repository.SellingRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final SellingRepository sellingRepository;

    private final MemberRepository memberRepository;

    private final OrderRepository orderRepository;

    private final SellingItemImgRepository sellingItemImgRepository;

    public Long order(OrderDTO orderDTO, String email){
        SellingItem sellingItem = sellingRepository.findById(orderDTO.getSellingId()).orElseThrow(EntityExistsException::new);
        // 주문할 상품을 조회
        Member member = memberRepository.findByEmail(email); // 현재 로그인한 회원의 이메일 정보를 이용해서 회원정보를 조회

        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = OrderItem.createOrderItem(sellingItem, orderDTO.getCont()); // 주문할 상품 엔티티와 주문 수량을 이용하여 주문상품 엔티티를 생성
        orderItemList.add(orderItem);

        Order order = Order.createOrder(member, orderItemList); // 회원정보와 주문할 상품 리스트 정보를 이용하여 주문 엔티티를 생성
        orderRepository.save(order); // 생성한 주문 엔티티를 저장

        return order.getId();
    }

    @Transactional(readOnly = true)
    public Page<OrderHistDTO> getOrder
}
