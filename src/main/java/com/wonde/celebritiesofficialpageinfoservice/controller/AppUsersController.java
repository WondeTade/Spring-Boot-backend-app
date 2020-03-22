package com.wonde.celebritiesofficialpageinfoservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("secured")
public class AppUsersController {

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminDetail() {
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String getUserDetail() {
        return ("Welcome User");
    }

    @GetMapping("/")
    public String getPermission() {
        return "home.jsp";
    }
}
