package com.example.demo.utils;

public interface Constants {

    interface REG_EXP {
        String UUID = "[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}";
        String PHONE_NUMBER = "1[34578]\\d{9}";
        String PROVINCE_CITY_AREA = "^[\u4e00-\u9fa5]+(市|省|自治区|自治州|县|自治县|旗|自治旗|区|特区|林区)[\u4e00-\u9fa5]+(市|区|县|旗)+[\u4e00-\u9fa5]+(区|县)?$";
        String PROVINCE_CITY = "^[\u4e00-\u9fa5]+(市|省|自治区|自治州|县|自治县|旗|自治旗|区|特区|林区)[\u4e00-\u9fa5]+(市|区|县|旗)?$";

    }

    BiDirectionalMap<Integer, String> GENDER = new BiDirectionalMap<>() {{
        put(0, "男性");
        put(1, "女性");
        put(2, "其他");
    }};

    BiDirectionalMap<Integer, String> NATION = new BiDirectionalMap<>() {{
        put(0, "汉族");
        put(1, "蒙古族");
        put(2, "回族");
        put(3, "藏族");
        put(4, "维吾尔族");
        put(5, "苗族");
        put(6, "彝族");
        put(7, "壮族");
        put(8, "布依族");
        put(9, "朝鲜族");
        put(10, "满族");
        put(11, "侗族");
        put(12, "瑶族");
        put(13, "白族");
        put(14, "土家族");
        put(15, "哈尼族");
        put(16, "哈萨克族");
        put(17, "傣族");
        put(18, "黎族");
        put(19, "傈僳族");
        put(20, "佤族");
        put(21, "畲族");
        put(22, "高山族");
        put(23, "拉祜族");
        put(24, "水族");
        put(25, "东乡族");
        put(26, "纳西族");
        put(27, "景颇族");
        put(28, "柯尔克孜族");
        put(29, "土族");
        put(30, "达斡尔族");
        put(31, "仫佬族");
        put(32, "羌族");
        put(33, "布朗族");
        put(34, "撒拉族");
        put(35, "毛南族");
        put(36, "仡佬族");
        put(37, "锡伯族");
        put(38, "阿昌族");
        put(39, "普米族");
        put(40, "塔吉克族");
        put(41, "怒族");
        put(42, "乌孜别克族");
        put(43, "俄罗斯族");
        put(44, "鄂温克族");
        put(45, "德昂族");
        put(46, "保安族");
        put(47, "裕固族");
        put(48, "京族");
        put(49, "塔塔尔族");
        put(50, "独龙族");
        put(51, "鄂伦春族");
        put(52, "赫哲族");
        put(53, "门巴族");
        put(54, "珞巴族");
        put(55, "基诺族族");
    }};

    BiDirectionalMap<Integer, String> MARRIAGE = new BiDirectionalMap<>() {{
        put(0, "未婚");
        put(1, "已婚");
        put(2, "离异");
        put(3, "丧偶");
    }};

    BiDirectionalMap<Integer, String> PROVINCE = new BiDirectionalMap<>() {{
        put(0, "河北省");
        put(1, "山西省");
        put(2, "辽宁省");
        put(3, "吉林省");
        put(4, "黑龙江省");
        put(5, "江苏省");
        put(6, "浙江省");
        put(7, "安徽省");
        put(8, "福建省");
        put(9, "江西省");
        put(10, "山东省");
        put(11, "河南省");
        put(12, "湖北省");
        put(13, "湖南省");
        put(14, "广东省");
        put(15, "海南省");
        put(16, "四川省");
        put(17, "贵州省");
        put(18, "云南省");
        put(19, "陕西省");
        put(20, "甘肃省");
        put(21, "青海省");
        put(22, "台湾省");
        put(23, "内蒙古自治区");
        put(24, "宁夏回族自治区");
        put(25, "新疆维吾尔自治区");
        put(26, "西藏自治区");
        put(27, "广西壮族自治区");
        put(28, "北京市");
        put(29, "天津市");
        put(30, "上海市");
        put(31, "重庆市");
        put(32, "香港特别行政区");
        put(33, "澳门特别行政区");
    }};

    BiDirectionalMap<Integer, String> USER_STATUS = new BiDirectionalMap<>() {{
        put(0, "正常");
        put(1, "禁用");
    }};

    BiDirectionalMap<Integer, String> MSISDN_BRAND = new BiDirectionalMap<>() {{
        put(0, "全球通");
        put(1, "神州行");
        put(2, "动感地带");
    }};

    BiDirectionalMap<Integer, String> USER_TYPE = new BiDirectionalMap<>() {{
        put(0, "普通");
        put(1, "黄金");
        put(2, "铂金");
        put(3, "PLUS");
    }};

    BiDirectionalMap<Integer, String> PAY_TYPE = new BiDirectionalMap<>() {{
        put(0, "普通");
        put(1, "月付费");
        put(2, "年付费");
    }};

    BiDirectionalMap<Integer, String> STAR = new BiDirectionalMap<>() {{
        put(1, "一星用户");
        put(2, "二星用户");
        put(3, "三星用户");
        put(4, "四星用户");
        put(5, "五星用户");
    }};

    BiDirectionalMap<Integer, String> CM_IS_SILENT = new BiDirectionalMap<>() {{
        put(0, "沉默");
        put(1, "正常");
    }};

    BiDirectionalMap<Integer, String> IS_CM_NADD = new BiDirectionalMap<>() {{
        put(0, "新增");
        put(1, "非新增");
    }};

    BiDirectionalMap<Integer, String> IS_ORD_5G_PACKAGE = new BiDirectionalMap<>() {{
        put(0, "订购");
        put(1, "无订购");
    }};

    BiDirectionalMap<Integer, String> TERM_TYPE = new BiDirectionalMap<>() {{
        put(0, "移动电话");
        put(1, "平板");
        put(2, "智能手表");
    }};
}
