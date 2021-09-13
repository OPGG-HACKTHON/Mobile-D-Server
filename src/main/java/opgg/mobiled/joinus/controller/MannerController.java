package opgg.mobiled.joinus.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import opgg.mobiled.joinus.dao.response.BasicResponse;
import opgg.mobiled.joinus.dao.response.CommonResponse;
import opgg.mobiled.joinus.dao.response.ErrorResponse;
import opgg.mobiled.joinus.dao.response.SuccessResponse;
import opgg.mobiled.joinus.dto.Manner;
import opgg.mobiled.joinus.dto.User;
import opgg.mobiled.joinus.service.MannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<? extends BasicResponse> insertMannerWithUserPkAndTargetPkAndManner(@RequestBody Manner manner_data) {
        int insertResult = mannerService.insertMannerWithUserPkAndTargetPkAndManner(manner_data);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,"매너도 평가 성공")); //성공 response
    }

    @GetMapping
    @ApiOperation(value = "매너도 조회", notes = "target_pk의 매너 점수를 계산하여 리턴합니다. 없는 user를 조회하면 에러 코드를 리턴합니다.")
    public ResponseEntity<? extends BasicResponse> selectMannerWithTargetPK(@Parameter(description = "타겟 유저 pk 값", required = true, example = "2") @RequestParam int target_pk){
        int mannerResult = mannerService.selectAndCalculateManner(target_pk);
        if(mannerResult == 99999){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("매너도 평가를 받지 않았거나, 존재하지 않는 user입니다. target_pk를 확인해주세요")); //실패 response
        }
        return ResponseEntity.ok().body(new CommonResponse<Integer>(mannerResult)); //성공 data response
    }
}
