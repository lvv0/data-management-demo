package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 0:41
 */

@Data
public class UserB {

    @JsonProperty("user_id")
    private String user_id;

    @JsonProperty("suename")
    private String SUENAME;

    @JsonProperty("phone_NUMBER")
    private String PHONE_NUMBER;

    @JsonProperty("age")
    private Integer AGE;

    @JsonProperty("sex")
    private Integer SEX;

    @JsonProperty("nanl")
    private String NANL;

    @JsonProperty("mage_STATUS")
    private String MAGE_STATUS;

    @JsonProperty("idty_CNTY")
    private String IDTY_CNTY;

    @JsonProperty("open_CNTY")
    private String OPEN_CNTY;

    @JsonProperty("user_STATUS")
    private String USER_STATUS;

    @JsonProperty("msisdn_BRAND")
    private String MSISDN_BRAND;

    @JsonProperty("user_TYPE")
    private String USER_TYPE;

    @JsonProperty("belo_AREA")
    private String BELO_AREA;

    @JsonProperty("pay_TYP")
    private String PAY_TYP;

    @JsonProperty("star")
    private Integer STAR;

    @JsonProperty("is_CM_NADD")
    private Integer IS_CM_NADD;

}
