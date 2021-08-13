package opgg.mobiled.joinus.controller;

import opgg.mobiled.joinus.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;

import opgg.mobiled.joinus.service.LoginService;

import java.util.LinkedHashMap;

@RestController
@RequestMapping(path = "/api/login")
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) { this.loginService = loginService; }

    @GetMapping
    public User OAuthCheck(@RequestParam String code) {
        User user = loginService.OAuthCheck(code);
        return user;
    }
}
