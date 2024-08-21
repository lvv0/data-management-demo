package com.example.demo.utils;

import com.example.demo.entity.UserA;
import com.example.demo.entity.UserB;
import com.example.demo.entity.UserC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> convert(List<Boolean> status) {
        List<Integer> columns = new ArrayList<>();
        for (int index = 0; index < status.size(); index += 1) {
            if (status.get(index)) {
                columns.add(index);
            }
        }
        return columns;
    }

    public static List<Integer> checkB(UserB user) {
        List<Boolean> status = new ArrayList<>() {{
            /* 0. 用户id */
            add(!Tools.notNull(user.getUser_id()) || !Tools.regexp(user.getUser_id(), Constants.REG_EXP.UUID));
            /* 1. 姓氏 */
            add(!Tools.notNull(user.getSUENAME()) || !Tools.stringRange(user.getSUENAME(), 1, 255));
            /* 2. 手机号码 */
            add(!Tools.notNull(user.getPHONE_NUMBER()) || !Tools.regexp(user.getPHONE_NUMBER(), Constants.REG_EXP.PHONE_NUMBER));
            /* 3. 年龄 */
            add(Tools.notNull(user.getAGE()) && !Tools.integerRange(user.getAGE(), 1, 150));
            /* 4. 性别 */
            add(Tools.notNull(user.getSEX()) && !Tools.keyIn(Constants.GENDER, user.getSEX()));
            /* 5. 民族 */
            add(Tools.notNull(user.getNANL()) && !Tools.valueIn(Constants.NATION, user.getNANL()));
            /* 6. 婚姻状况 */
            add(Tools.notNull(user.getMAGE_STATUS()) && !Tools.valueIn(Constants.MARRIAGE, user.getMAGE_STATUS()));
            /* 7. 证件区县 */
            add(Tools.notNull(user.getIDTY_CNTY()) &&
                !Tools.regexp(user.getIDTY_CNTY(), Constants.REG_EXP.PROVINCE_CITY_AREA)
            );
            /* 8. 开卡区县 */
            add(Tools.notNull(user.getOPEN_CNTY()) &&
                !Tools.regexp(user.getOPEN_CNTY(), Constants.REG_EXP.PROVINCE_CITY_AREA)
            );
            /* 9. 用户状态 */
            add(Tools.notNull(user.getUSER_STATUS()) && !Tools.valueIn(Constants.USER_STATUS, user.getUSER_STATUS()));
            /* 10. 号码品牌 */
            add(Tools.notNull(user.getMSISDN_BRAND()) && !Tools.valueIn(Constants.MSISDN_BRAND, user.getMSISDN_BRAND()));
            /* 11. 用户类型 */
            add(Tools.notNull(user.getUSER_TYPE()) && !Tools.valueIn(Constants.USER_TYPE, user.getUSER_TYPE()));
            /* 12. 所属区域 */
            add(Tools.notNull(user.getBELO_AREA()) && !Tools.regexp(user.getBELO_AREA(), Constants.REG_EXP.PROVINCE_CITY));
            /* 13. 付费类型 */
            add(Tools.notNull(user.getPAY_TYP()) && !Tools.valueIn(Constants.PAY_TYPE, user.getPAY_TYP()));
            /* 14. 星级 */
            add(Tools.notNull(user.getSTAR()) && !Tools.keyIn(Constants.STAR, user.getSTAR()));
            /* 15. 是否当月新增 */
            add(Tools.notNull(user.getIS_CM_NADD()) && !Tools.keyIn(Constants.IS_CM_NADD, user.getIS_CM_NADD()));
        }};
        return convert(status);
    }

    public static List<Integer> checkC(UserC user) {
        List<Boolean> status = new ArrayList<>() {{
            /* 0. 用户id */
            add(!Tools.notNull(user.getUser_id()) || !Tools.regexp(user.getUser_id(), Constants.REG_EXP.UUID));
            /* 1. 手机号码 */
            add(!Tools.notNull(user.getPHONE_NUMBER()) || !Tools.regexp(user.getPHONE_NUMBER(), Constants.REG_EXP.PHONE_NUMBER));
            /* 2. 用户状态 */
            add(Tools.notNull(user.getUSER_STATUS()) && !Tools.valueIn(Constants.USER_STATUS, user.getUSER_STATUS()));
            /* 3. 付费类型 */
            add(Tools.notNull(user.getPAY_TYP()) && !Tools.valueIn(Constants.PAY_TYPE, user.getPAY_TYP()));
            /* 4. 星级 */
            add(Tools.notNull(user.getSTAR()) && !Tools.keyIn(Constants.STAR, user.getSTAR()));
            /* 5. 主套餐编码 */
            add(Tools.notNull(user.getPRI_PACKAGE_CODE()) && !Tools.startsWith(user.getPRI_PACKAGE_CODE(), "PRIMARY_"));
            /* 6. 主套餐价格 */
            add(Tools.notNull(user.getPRI_PACKAGE_PRC()) && !Tools.floatRange(user.getPRI_PACKAGE_PRC(), 8, 999));
            /* 7. 当月是否沉默 */
            add(Tools.notNull(user.getCM_IS_SILENT()) && !Tools.keyIn(Constants.CM_IS_SILENT, user.getCM_IS_SILENT()));
            /* 8. 当月是否超套额度 */
            add(Tools.notNull(user.getCM_IS_VOICE_OVER()) && !Tools.floatRange(user.getCM_IS_VOICE_OVER(), 0, 102400));
            /* 9. 当月欠费次数 */
            add(Tools.notNull(user.getCM_OWE_CNT()) && !Tools.integerRange(user.getCM_OWE_CNT(), 0, 1024));
            /* 10. 当月主叫次数 */
            add(Tools.notNull(user.getCM_CALLING_CNT()) && !Tools.integerRange(user.getCM_CALLING_CNT(), 0, 999999));
            /* 11. 是否订购5G套餐 */
            add(Tools.notNull(user.getIS_ORD_5G_PACKAGE()) && !Tools.keyIn(Constants.IS_ORD_5G_PACKAGE, user.getIS_ORD_5G_PACKAGE()));
            /* 12. IMEI手机串号 */
            add(Tools.notNull(user.getIMEI()) && !Tools.stringRange(user.getIMEI(), 15, 17));
            /* 13. 终端类型 */
            add(Tools.notNull(user.getTERM_TYP()) && !Tools.valueIn(Constants.TERM_TYPE, user.getTERM_TYP()));
        }};
        return convert(status);
    }

    public static UserA merge(UserB ub, UserC uc) {
        UserA ua = new UserA();
        /* 用户id */
        ua.setUser_id(ub.getUser_id());
        /* 姓氏 */
        ua.setSURNAME(ub.getSUENAME());
        /* 手机号码 */
        ua.setPHONE_NUMBER(ub.getPHONE_NUMBER());
        /* 年龄 */
        ua.setAGE(ub.getAGE());
        /* 性别 */
        if (ub.getSEX() == 0) {
            ua.setSEX0("女");
        } else {
            ua.setSEX0("男");
        }
//        ua.setSEX(ub.getSEX());
        /* 民族 */
        ua.setNANL(ub.getNANL());
        /* 婚姻状况 */
        ua.setMAGE_STATUS(ub.getMAGE_STATUS());
        /* 证件区县 */
        ua.setIDTY_CNTY(ub.getIDTY_CNTY());
        /* 开卡区县 */
        ua.setOPEN_CNTY(ub.getOPEN_CNTY());
        /* 用户状态 */
        ua.setUSER_STATUS(ub.getUSER_STATUS());
        /* 号码品牌 */
        ua.setMSISDN_BRAND(ub.getMSISDN_BRAND());
        /* 用户类型 */
        ua.setUSER_TYPE(ub.getUSER_TYPE());
        /* 所属区域 */
        ua.setBELO_AREA(ub.getBELO_AREA());
        /* 付费类型 */
        ua.setPAY_TYP(ub.getPAY_TYP());
        /* 星级 */
        ua.setSTAR(ub.getSTAR());
        /* 当月是否沉默 */
        if (uc != null) {
            ua.setCM_IS_SILENT(uc.getCM_IS_SILENT());
        }
        /* 是否当月新增 */
        ua.setIS_CM_NADD(ub.getIS_CM_NADD());
        /* 主套餐编码 */
        if (uc != null) {
            ua.setPRI_PACKAGE_CODE(uc.getPRI_PACKAGE_CODE());
        }
        /* 主套餐价格 */
        if (uc != null) {
            ua.setPRI_PACKAGE_PRC(uc.getPRI_PACKAGE_PRC());
        }
        /* 当月是否语音超套 */
        if (uc != null) {
            ua.setCM_IS_VOICE_OVER(uc.getCM_IS_VOICE_OVER() == 0 ? 0 : 1);
        }
        /* 当月超套额度 */
        if (uc != null) {
            ua.setCM_VOICE_OVER(uc.getCM_IS_VOICE_OVER() * 1024.0);
        }
        /* IMEI手机串号 */
        if (uc != null) {
            ua.setIMEI(uc.getIMEI());
        }
        /* 终端类型 */
        if (uc != null) {
            ua.setTERM_TYP(uc.getTERM_TYP());
        }
        return ua;
    }

//    public static List<UserA> merge(List<UserB> ubs, List<UserC> ucs) {
//        List<UserA> uas = new ArrayList<>();
//        /* UserB left join UserC */
//        Map<String, UserC> ucmap = ucs.stream().collect(Collectors.toMap(UserC::getUser_id, user -> user));
//        for (UserB ub : ubs) {
//            uas.add(merge(ub, ucmap.getOrDefault(ub.getUser_id(), null)));
//        }
//        return uas;
//    }
}
