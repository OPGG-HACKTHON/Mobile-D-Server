package opgg.mobiled.joinus.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import opgg.mobiled.joinus.dto.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import opgg.mobiled.joinus.service.RoomUserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/roomuser")
public class RoomUserController {
    private RoomUserService roomUserService;

    @Autowired
    public RoomUserController(RoomUserService roomUserService) {this.roomUserService = roomUserService;}

    @GetMapping
    @ApiOperation(value = "방에 소속된 유저 정보 조회", notes = "방의 pk값을 주시면 유저 목록을 반환해드립니다.")
    public List<User> selectAllUserInRoomWithRoomPk(@Parameter(description = "해당 방의 유저 목록을 줍니다", required = true) @RequestParam int room_pk) {
        List<User> resultUserList = roomUserService.selectAllUserInRoomWithRooPk(room_pk);
        return resultUserList;
    }

    @PostMapping
    @ApiOperation(value = "방에 소속된 유저 생성", notes = "방장이 아닌 유저를 만드는 기능입니다. 방의 pk와 유저의 pk를 주시면 만들어서 성공시 1 실패시 0을 반환합니다.")
    public int insertUserInRoomWithRoomPkAndUserPk(@Parameter(description = "들어갈 방에 대한 pk값을 주시면 됩니다", required = true) @RequestParam int room_pk,@Parameter(description = "들어갈 유저의 pk값을 주시면 됩니다.", required = true) @RequestParam int user_pk) {
        int resultInsert = roomUserService.insertUserInRoomWithRoomPkAndUserPk(room_pk,user_pk);
        return resultInsert;
    }

    @DeleteMapping
    @ApiOperation(value = "방에 소속된 유저 제거", notes = "해당 관계 pk값을 주시면 삭제합니다.")
    public int deleteUserInRoomWithRoomUserPk(@Parameter(description = "삭제할 pk값을 주시면 제거 됩니다.", required = true) @RequestParam int room_user_pk) {
        int resultDelete = roomUserService.deleteUserInRoomWithRoomUserPk(room_user_pk);
        return resultDelete;
    }
}
