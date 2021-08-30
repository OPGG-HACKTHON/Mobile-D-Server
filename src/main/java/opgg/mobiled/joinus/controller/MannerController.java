package opgg.mobiled.joinus.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import opgg.mobiled.joinus.dto.Manner;
import opgg.mobiled.joinus.service.MannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/manner") // 해당 주소로 들어오면 아래의 함수를 메소드와 함께 이용 가능, 더 자원을 표시하고 싶다면 더 표시 가능
public class MannerController {
    private MannerService mannerService;

    @Autowired
    public MannerController(MannerService mannerService) {
        this.mannerService = mannerService;
    }

    @PostMapping
    @ApiOperation(value = "매너도 평가", notes = "user_pk가 target_pk를 평가합니다. 매너점수는 manner(0:good, 1:bad)로 입력됩니다. pk값은 안주셔도 괜찮습니다.")
    public int insertMannerWithUserPkAndTargetPkAndManner(@RequestBody Manner manner_data) {
        int insertResult = mannerService.insertMannerWithUserPkAndTargetPkAndManner(manner_data);

        return insertResult;
    }

    @GetMapping
    @ApiOperation(value = "매너도 조회", notes = "target_pk의 매너 점수를 계산하여 리턴합니다. 없는 user를 조회하면 99999를 리턴합니다. (** 추후에 에러 코드로 변환 예정)")
    public int selectMannerWithTargetPK(@Parameter(description = "타겟 유저 pk 값", required = true, example = "2") @RequestParam int target_pk){
        int mannerResult = mannerService.selectAndCalculateManner(target_pk);
        return mannerResult;
    }
}
