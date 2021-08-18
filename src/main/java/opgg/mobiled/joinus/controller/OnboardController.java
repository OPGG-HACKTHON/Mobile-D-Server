package opgg.mobiled.joinus.controller;

import io.swagger.annotations.ApiOperation;
import opgg.mobiled.joinus.dto.Onboard;
import opgg.mobiled.joinus.service.OnboardService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public int insertOnboardDataWithSubAndGenderAndAgeAndImageAndNickName(@RequestBody Onboard onboard_data) {
        int insertResult = onboardService.updateOnboardWithOnboardData(onboard_data);
        return insertResult;
    }
}
