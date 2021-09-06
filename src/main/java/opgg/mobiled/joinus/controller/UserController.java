//package opgg.mobiled.joinus.controller;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.v3.oas.annotations.Parameter;
//import opgg.mobiled.joinus.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "/api/user") // 해당 주소로 들어오면 아래의 함수를 메소드와 함께 이용 가능, 더 자원을 표시하고 싶다면 더 표시 가능
//public class UserController {
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/firebase")
//    @ApiOperation(value = "firebaseToken 조회", notes = "target유저의 토큰을 이용하여 해당 유저의 firebase_token을 리턴합니다.")
//    public String selectFirebaseTokenWithTargetToken(@Parameter(description = "타겟 유저 토큰 값", required = true, example = "2") @RequestParam String token){
//        String firebaseToken = userService.selectFirebaseTokenWithTargetToken(token);
//        return firebaseToken;
//    }
//}
