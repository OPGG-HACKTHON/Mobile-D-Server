package opgg.mobiled.joinus.controller;

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
    public List<User> selectAllUserInRoomWithRoomPk(@RequestParam int room_pk) {
        List<User> resultUserList = roomUserService.selectAllUserInRoomWithRooPk(room_pk);
        return resultUserList;
    }

    @PostMapping
    public int insertUserInRoomWithRoomPkAndUserPk(@RequestParam int room_pk, @RequestParam int user_pk) {
        int resultInsert = roomUserService.insertUserInRoomWithRoomPkAndUserPk(room_pk,user_pk);
        return resultInsert;
    }

    @DeleteMapping
    public int deleteUserInRoomWithRoomUserPk(@RequestParam int room_user_pk) {
        int resultDelete = roomUserService.deleteUserInRoomWithRoomUserPk(room_user_pk);
        return resultDelete;
    }
}
