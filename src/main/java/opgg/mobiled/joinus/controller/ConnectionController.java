package opgg.mobiled.joinus.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import opgg.mobiled.joinus.dao.response.BasicResponse;
import opgg.mobiled.joinus.dao.response.CommonResponse;
import opgg.mobiled.joinus.dao.response.ErrorResponse;
import opgg.mobiled.joinus.dao.response.SuccessResponse;
import opgg.mobiled.joinus.dto.Connections;
import opgg.mobiled.joinus.dto.User;
import opgg.mobiled.joinus.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/connection") // 해당 주소로 들어오면 아래의 함수를 메소드와 함께 이용 가능, 더 자원을 표시하고 싶다면 더 표시 가능
public class ConnectionController {
    private ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @PostMapping
    @ApiOperation(value = "친구/블랙리스트 등록", notes = "start_id 회원이 end_id 회원에 connection을 등록합니다. friend_or_black의 값이 true면 친구, false면 블랙리스트로 등록됩니다. pk값은 안주셔도 괜찮습니다.")
    public ResponseEntity<? extends BasicResponse> insertConnectionWithStartAndEndAndIsFriend(@RequestBody Connections connection_data) {
        int insertResult = connectionService.insertConnectionWithStartAndEndAndIsFriend(connection_data);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(200,"connection 등록 성공")); //성공 response
    }

    @GetMapping
    @ApiOperation(value = "친구/블랙리스트 조회", notes = "조회를 원하는 회원이 등록한 친구/블랙을 조회합니다. 해당하는 사용자들의 user정보 리스트가 리턴됩니다.")
    public ResponseEntity<? extends BasicResponse> selectConnectionWithStartAndIsFriend(@RequestParam @ApiParam(value = "관계를 등록한 사람", required = true) int start_id, @RequestParam @ApiParam(value = "친구(true)/블랙(false)", required = true) boolean friend_or_black){
        List<User> connectionResult = connectionService.selectConnectionWithStartAndIsFriend(start_id,friend_or_black);
        if(connectionResult.size() < 1){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("조회 정보가 존재하지 않습니다. 사용자 id를 확인해주세요")); //실패 response
        }
        return ResponseEntity.ok().body(new CommonResponse<List<User>>(connectionResult)); //성공 data response
    }
}
