package com.example.demo.entity;


import lombok.Data;

/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 0:41
 */

@Data
public class UserC {


    private String user_id;
    private String PHONE_NUMBER;
    private String USER_STATUS;
    private String PAY_TYP;
    private Integer STAR;
    private String PRI_PACKAGE_CODE;
    private Double PRI_PACKAGE_PRC;
    private Integer CM_IS_SILENT;
    private Double CM_IS_VOICE_OVER;
    private Integer CM_OWE_CNT;
    private Integer CM_CALLING_CNT;
    private Integer IS_ORD_5G_PACKAGE;
    private String IMEI;
    private String TERM_TYP;


}
