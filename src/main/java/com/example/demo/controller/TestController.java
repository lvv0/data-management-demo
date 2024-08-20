package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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

    @GetMapping("test")
    public String categoryList(){
        return "123";
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
                String username = getCellValueAsString(currentRow.getCell(1));
                Cell cell = currentRow.getCell(2);
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

    @GetMapping("/get")
    public List<User> getUsers() {
        return userService.getAllUsers();
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
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        }
        return null;
    }
}
