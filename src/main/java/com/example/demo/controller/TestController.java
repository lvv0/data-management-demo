package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.UserService;
import com.example.demo.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;


/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 0:02
 */

@RestController
@RequestMapping("api")
@Slf4j
public class TestController {

    private UserService userService;

    @Autowired
    public TestController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping("/addB")
    public ResultB addUsersB(@RequestParam("file") MultipartFile file) {
//        for (row : Row) {
//
//            res = checke(Userb)
//                    if (res.getIsOk()) {
//                        userService.addUserB(UserB);
//                    } else {
//                        List<> list = res.getCols
//                    }
//        }
//        UserB userB = new UserB();
//        userB.setUser_id("123234");
//        userB.setSUENAME("23435345345");
//        List<UserB> list1 = new ArrayList<>();
//        list1.add(userB);
//
//        List<Integer> ids = new ArrayList<>();
//        for (int i = 2; i <= 15; i++) {
//            ids.add(i);
//        }
//        List<List<Integer>> list2 = new ArrayList<>();
//        list2.add(ids);
//        Result result = new Result();
//        result.setList1(list1);
//        result.setList2(list2);


        String fileName = file.getOriginalFilename();
        ResultB resultB = new ResultB();
        if (fileName == null) {
            return resultB;
        }

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = createWorkbook(inputStream, fileName)) {

            Sheet sheet = workbook.getSheetAt(0); // 读取第一个工作表
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) {
                rows.next(); // 跳过第一行（列名）
            }
            Set<String> uniqueUser = new HashSet<>();
            List<UserB> wrongUsers = new ArrayList<>();
            List<List<Integer>> colList = new ArrayList<>();
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                UserB userB = new UserB();
                userB.setUser_id(getCellValueAsString(currentRow.getCell(0)).trim());
                userB.setSUENAME(getCellValueAsString(currentRow.getCell(1)).trim());
                userB.setPHONE_NUMBER(getCellValueAsString(currentRow.getCell(2)).trim());
                userB.setAGE(getCellValueAsInteger(currentRow.getCell(3)));
                userB.setSEX(getCellValueAsInteger(currentRow.getCell(4)));
                userB.setNANL(getCellValueAsString(currentRow.getCell(5)).trim());
                userB.setMAGE_STATUS(getCellValueAsString(currentRow.getCell(6)).trim());
                userB.setIDTY_CNTY(getCellValueAsString(currentRow.getCell(7)).trim());
                userB.setOPEN_CNTY(getCellValueAsString(currentRow.getCell(8)).trim());
                userB.setUSER_STATUS(getCellValueAsString(currentRow.getCell(9)).trim());
                userB.setMSISDN_BRAND(getCellValueAsString(currentRow.getCell(10)).trim());
                userB.setUSER_TYPE(getCellValueAsString(currentRow.getCell(11)).trim());
                userB.setBELO_AREA(getCellValueAsString(currentRow.getCell(12)).trim());
                userB.setPAY_TYP(getCellValueAsString(currentRow.getCell(13)).trim());
                userB.setSTAR(getCellValueAsInteger(currentRow.getCell(14)));
                userB.setIS_CM_NADD(getCellValueAsInteger(currentRow.getCell(15)));
                //去重操作，数据校验
                Utils utils = new Utils();
                if (!uniqueUser.contains(userB.getUser_id())) {
                    List<Integer> checkB = utils.checkB(userB);
                    if (checkB.isEmpty()) {
                        uniqueUser.add(userB.getUser_id());
                        userService.addUserB(userB);
                    } else {
                        wrongUsers.add(userB);
                        colList.add(checkB);
                    }

                }


            }

//            if (!wrongUsers.isEmpty()) {
//
//            }

            resultB.setList1(wrongUsers);
            resultB.setList2(colList);
//            return "数据入湖成功";
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
        return resultB; // TODO
    }

    @PostMapping("/addC")
    public ResultC addUsersC(@RequestParam("file") MultipartFile file) {

        String fileName = file.getOriginalFilename();
        ResultC resultC = new ResultC();
        if (fileName == null) {
            return resultC;
        }

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = createWorkbook(inputStream, fileName)) {

            Sheet sheet = workbook.getSheetAt(0); // 读取第一个工作表
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) {
                rows.next(); // 跳过第一行（列名）
            }
            Set<String> uniqueUser = new HashSet<>();
            List<UserC> wrongUsers = new ArrayList<>();
            List<List<Integer>> colList = new ArrayList<>();
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                UserC userC = new UserC();
                userC.setUser_id(getCellValueAsString(currentRow.getCell(0)).trim());
                userC.setPHONE_NUMBER(getCellValueAsString(currentRow.getCell(1)).trim());
                userC.setUSER_STATUS(getCellValueAsString(currentRow.getCell(2)).trim());
                userC.setPAY_TYP(getCellValueAsString(currentRow.getCell(3)).trim());
                userC.setSTAR(getCellValueAsInteger(currentRow.getCell(4)));
                userC.setPRI_PACKAGE_CODE(getCellValueAsString(currentRow.getCell(5)).trim());
                userC.setPRI_PACKAGE_PRC(getCellValueAsDouble(currentRow.getCell(6)));
                userC.setCM_IS_SILENT(getCellValueAsInteger(currentRow.getCell(7)));

                String cellValueAsString = getCellValueAsString(currentRow.getCell(8)).trim();
                if (cellValueAsString != null && cellValueAsString.endsWith("G")) {
                    cellValueAsString =  cellValueAsString.substring(0, cellValueAsString.length() - 1);
                }
                userC.setCM_IS_VOICE_OVER(Double.valueOf(cellValueAsString));
                userC.setCM_OWE_CNT(getCellValueAsInteger(currentRow.getCell(9)));
                userC.setCM_CALLING_CNT(getCellValueAsInteger(currentRow.getCell(10)));
                userC.setIS_ORD_5G_PACKAGE(getCellValueAsInteger(currentRow.getCell(11)));
                userC.setIMEI(getCellValueAsString(currentRow.getCell(12)).trim());
                userC.setTERM_TYP(getCellValueAsString(currentRow.getCell(13)).trim());

                //去重操作，数据校验
                Utils utils = new Utils();
                if (!uniqueUser.contains(userC.getUser_id())) {
                    List<Integer> checkC = utils.checkC(userC);
                    if (checkC.isEmpty()) {
                        uniqueUser.add(userC.getUser_id());
                        userService.addUserC(userC);
                    } else {
                        wrongUsers.add(userC);
                        colList.add(checkC);
                    }
                }


            }

//            if (!wrongUsers.isEmpty()) {
//
//            }

            resultC.setList1(wrongUsers);
            resultC.setList2(colList);
//            return "数据入湖成功";
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
        return resultC; // TODO
    }

    @PostMapping("/add")
    public String addUsers(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            return "Invalid file";
        }

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = createWorkbook(inputStream, fileName)) {

            Sheet sheet = workbook.getSheetAt(0); // 读取第一个工作表
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) {
                rows.next(); // 跳过第一行（列名）
            }

            List<User> users = new ArrayList<>();

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                Integer id = getCellValueAsInteger(currentRow.getCell(0));
                if (id == null) {
                    continue;
                }
                String username = getCellValueAsString(currentRow.getCell(1));
                String phone = getCellValueAsString(currentRow.getCell(2));

                User user = new User();
                user.setId(id);
                user.setUsername(username);
                user.setPhone(phone);
                users.add(user);
                userService.addUser(user);
            }

            return "File processed successfully";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing file";
        }
    }

    @GetMapping("/getA")
    public List<UserA> getUsersA() {
        return userService.getAllUsersA();
    }


    @GetMapping("/getB")
    public List<UserB> getUsersB() {
        return userService.getAllUsersB();
    }

    @GetMapping("/getC")
    public List<UserC> getUsersC() {
        return userService.getAllUsersC();
    }

    private Workbook createWorkbook(InputStream inputStream, String fileName) throws Exception {
        if (fileName.endsWith("xlsx")) {
            return new XSSFWorkbook(inputStream);
        } else if (fileName.endsWith("xls")) {
            return new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("Invalid file type: " + fileName);
        }
    }

    /**
     * @Description: 合并B和C表到主表
     * @author: lyz
     * @date: 2024/8/20 20:50
     */
    @PostMapping("/merge")
    public void merge() {
        userService.merge();
    }

    private Integer getCellValueAsInteger(Cell cell) {
        if (cell == null) {
            return null;
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            return (int) cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            try {
                return Integer.parseInt(cell.getStringCellValue());
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }


    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                }
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                // 如果单元格包含公式，可以通过公式计算得到值
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }

    private Double getCellValueAsDouble(Cell cell) {
        if (cell == null) {
            return null;
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            return (Double)cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            try {
                return Double.parseDouble(cell.getStringCellValue());
            } catch (NumberFormatException e) {
                return null;
            }


        }
        return null;
    }

}
