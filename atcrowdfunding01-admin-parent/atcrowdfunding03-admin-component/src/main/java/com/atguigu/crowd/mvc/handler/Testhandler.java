package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Testhandler {

    @Autowired
    AdminService adminService;

    @RequestMapping("test/ssm.html")
    String testSSM(ModelMap map) {
        List<Admin> admins = adminService.getAll();

        map.addAttribute("adminList", admins);
        return "target";
    }



}
