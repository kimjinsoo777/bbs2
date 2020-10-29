package com.example.bbs.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MemberList {
    private long mno;
    private String name;
    private String type;
    private Date regDate;
}
