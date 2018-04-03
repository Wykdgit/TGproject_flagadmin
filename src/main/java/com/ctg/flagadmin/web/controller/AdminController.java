package com.ctg.flagadmin.web.controller;

import com.ctg.flagadmin.pojo.dto.ResponseDto;
import com.ctg.flagadmin.pojo.entity.Admin;
import com.ctg.flagadmin.service.AdminService;
import com.ctg.flagadmin.utils.JWTUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class AdminController {
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseDto login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpServletResponse response) {
        Admin admin =adminService.getByUsername(username);
        if (admin == null) {
            return ResponseDto.failed("username is wrong.");
        }

        if (!admin.getPassword().equals(password)) {
            return ResponseDto.failed("password is wrong");
        }

        String token = JWTUtil.createToken(admin.getId(), admin.getKind());
        JWTUtil.setToken(response, token);

        return ResponseDto.succeed();
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ResponseDto logout(HttpServletResponse response) {
        JWTUtil.setToken(response, null);
        return ResponseDto.succeed();
    }
}
