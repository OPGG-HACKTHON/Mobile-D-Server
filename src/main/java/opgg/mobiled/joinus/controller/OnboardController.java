package opgg.mobiled.joinus.controller;

import io.swagger.annotations.ApiOperation;
import opgg.mobiled.joinus.dao.response.BasicResponse;
import opgg.mobiled.joinus.dao.response.ErrorResponse;
import opgg.mobiled.joinus.dao.response.SuccessResponse;
import opgg.mobiled.joinus.dto.Onboard;
import opgg.mobiled.joinus.service.OnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/onboard") // 해당 주소로 들어오면 아래의 함수를 메소드와 함께 이용 가능, 더 자원을 표시하고 싶다면 더 표시 가능

public class OnboardController {
    private OnboardService onboardService;

    @Autowired
    public OnboardController(OnboardService onboardService) {
        this.onboardService = onboardService;
    }

    @PutMapping
    @ApiOperation(value = "온보딩 정보 등록", notes = "sub(token)을 이용하여 온보딩 정보를 등록합니다.")
    public ResponseEntity<? extends BasicResponse> insertOnboardDataWithSubAndGenderAndAgeAndImageAndNickName(@RequestBody Onboard onboard_data) {
        int insertResult = onboardService.updateOnboardWithOnboardData(onboard_data);
        if(insertResult == 99999){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("해당 토큰을 가진 user가 존재하지 않습니다. token이 맞는지 확인해주세요")); //실패 response
        }
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,"온보딩 정보 저장 성공")); //성공 response
    }
}
