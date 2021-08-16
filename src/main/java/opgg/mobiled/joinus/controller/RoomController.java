package opgg.mobiled.joinus.controller;

import io.swagger.v3.oas.annotations.Parameter;
import opgg.mobiled.joinus.dto.RoomAndRoomUserVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import opgg.mobiled.joinus.service.RoomService;
import opgg.mobiled.joinus.dto.Room;

@RestController
@RequestMapping(path = "/api/room")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {this.roomService = roomService;}

    @GetMapping
    public List<Room> selectAllRoom() {
        List<Room> resultRoomList = roomService.selectAllRoom();

        return resultRoomList;
    }

    @PostMapping
    public int insertRoomAndRoomUserWithRoomDataAndUserPk(@Parameter(description = "만들 방에 대한 정보와 방장pk값을 주시면 됩니다.", required = true) @RequestBody RoomAndRoomUserVO roomAndRoomUserVO) {
        int resultRoomPk = roomService.insertRoomAndRoomUserWithRoomDataAndUserPk(roomAndRoomUserVO);

        return resultRoomPk;
    }

    @PutMapping
    public int updateRoomWithRoomData(@Parameter(description = "수정할 방에 대한 정보를 주시면 됩니다.", required = true) @RequestBody Room room) {
        int updateResult = roomService.updateRoomWithRoomData(room);

        return updateResult;
    }

    @DeleteMapping
    public int deleteRoomWithRoomPk(@Parameter(description = "삭제할 방에 대한 정보를 주시면 됩니다.", required = true) @RequestParam int room_pk) {
        int deleteResult = roomService.deleteRoomWithRoomPk(room_pk);

        return deleteResult;
    }

    @GetMapping(path = "/{room_pk}")
    public Room selectRoomDetailWithRoomPk(@Parameter(description = "조회할 방에대한 pk값을 주시면 방에 대한 상세정보를 드립니다.", required = true) @PathVariable(name = "room_pk") int room_pk) {
        Room resultRoom = roomService.selectRoomDetailWithRoomPk(room_pk);

        return resultRoom;
    }
}
