package opgg.mobiled.joinus.controller;

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
    public List<User> selectAllUserInRoomWithRoomPk(@Parameter(description = "해당 방의 유저 목록을 줍니다", required = true) @RequestParam int room_pk) {
        List<User> resultUserList = roomUserService.selectAllUserInRoomWithRooPk(room_pk);
        return resultUserList;
    }

    @PostMapping
    public int insertUserInRoomWithRoomPkAndUserPk(@Parameter(description = "들어갈 방에 대한 pk값을 주시면 됩니다", required = true) @RequestParam int room_pk,@Parameter(description = "들어갈 유저의 pk값을 주시면 됩니다.", required = true) @RequestParam int user_pk) {
        int resultInsert = roomUserService.insertUserInRoomWithRoomPkAndUserPk(room_pk,user_pk);
        return resultInsert;
    }

    @DeleteMapping
    public int deleteUserInRoomWithRoomUserPk(@Parameter(description = "삭제할 pk값을 주시면 제거 됩니다.", required = true) @RequestParam int room_user_pk) {
        int resultDelete = roomUserService.deleteUserInRoomWithRoomUserPk(room_user_pk);
        return resultDelete;
    }
}
