package opgg.mobiled.joinus.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @ApiOperation(value = "로그인!",notes = "google access token을 주시면 로그인과 회원가입을 해드립니다")
    public User OAuthCheck(@Parameter(description = "로그인할 유저의 google oauth 토큰값을 주시면 됩니다. 로그인과 가입이 동시에 가능합니다.", required = true) @RequestParam String code) {
        User user = loginService.OAuthCheck(code);
        return user;
    }
}
