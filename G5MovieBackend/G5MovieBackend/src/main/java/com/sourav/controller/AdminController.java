package com.sourav.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/admin/") // http://localhost:9093/api/admin/
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping(value = "/login")
	public boolean AdminLogin(@RequestBody Map loginData) {
		try {
			String emaiId = (String) loginData.get("emailId");
			String password = (String) loginData.get("password");
			return adminService.AdminLogin(emaiId, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
