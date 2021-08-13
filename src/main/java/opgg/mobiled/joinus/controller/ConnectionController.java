package opgg.mobiled.joinus.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import opgg.mobiled.joinus.dto.Connections;
import opgg.mobiled.joinus.dto.User;
import opgg.mobiled.joinus.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/connection") // 해당 주소로 들어오면 아래의 함수를 메소드와 함께 이용 가능, 더 자원을 표시하고 싶다면 더 표시 가능
public class ConnectionController {
    private ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @PostMapping
    @ApiOperation(value = "친구/블랙리스트 등록", notes = "start_id 회원이 end_id 회원에 connection을 등록합니다. friend_or_black의 값이 true면 친구, false면 블랙리스트로 등록됩니다.")
    public int insertConnectionWithStartAndEndAndIsFriend(@RequestBody Connections connection_data) {
        int insertResult = connectionService.insertConnectionWithStartAndEndAndIsFriend(connection_data);

        return insertResult;
    }

    @GetMapping
    @ApiOperation(value = "친구/블랙리스트 조회", notes = "start_id 회원이 등록한 친구(true)/블랙(false)를 조회합니다. 해당하는 사용자들의 user정보 리스트가 리턴됩니다.")
    public List<User> selectConnectionWithStartAndIsFriend(@RequestParam int start_id, @RequestParam boolean friend_or_black){
        List<User> connectionResult = connectionService.selectConnectionWithStartAndIsFriend(start_id,friend_or_black);
        return connectionResult;
    }
}
