package com.example.demo.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 21:29
 */
@Data
public class ResultC {

    private List<UserC> list1;
    private List<List<Integer>> list2;
}
