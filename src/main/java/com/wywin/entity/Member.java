package com.wywin.entity;

import com.wywin.constrant.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member extends  BaseEntity{

    @Id
    @Column(name = "member_id")
    private String email;
    // 이메일(id 역할)

    @Column(nullable = false, length = 16)
    private String pw;
    // 비밀번호

    @Column(nullable = false)
    private String name;
    // 이름

    @Column(nullable = false)
    private String phoneNum;
    // 전화번호

    @Column(unique = true)
    private String nickName;
    // 닉네임

    @Column(nullable = false)
    private String address;

    private Long point;
    // 포인트(캐시로 사용 - 보증금역할)

    @Enumerated(EnumType.STRING)
    private Role role;
    // 권한부여


}
