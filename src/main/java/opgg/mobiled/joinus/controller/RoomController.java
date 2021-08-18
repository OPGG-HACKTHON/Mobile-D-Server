package opgg.mobiled.joinus.controller;

import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "방 목록 조회", notes = "모든 방에 대한 정보를 드립니다.")
    public List<Room> selectAllRoom() {
        List<Room> resultRoomList = roomService.selectAllRoom();

        return resultRoomList;
    }

    @PostMapping
    @ApiOperation(value = "방 생성", notes = "만들 방에 대한 정보와 방장의 pk(user_pk) 값을 한번에 넘겨주시면 됩니다. pk값은 안넘겨주셔도 괜찮습니다")
    public int insertRoomAndRoomUserWithRoomDataAndUserPk(@Parameter(description = "만들 방에 대한 정보와 방장pk값을 주시면 됩니다.", required = true) @RequestBody RoomAndRoomUserVO roomAndRoomUserVO) {
        int resultRoomPk = roomService.insertRoomAndRoomUserWithRoomDataAndUserPk(roomAndRoomUserVO);

        return resultRoomPk;
    }

    @PutMapping
    @ApiOperation(value = "방 수정", notes = "수정할 방에 대한 정보 넘겨주시면 됩니다. pk값으로 해당 방을 찾습니다.")
    public int updateRoomWithRoomData(@Parameter(description = "수정할 방에 대한 정보를 주시면 됩니다. pk값으로 수정할 대상을 찾습니다", required = true) @RequestBody Room room) {
        int updateResult = roomService.updateRoomWithRoomData(room);

        return updateResult;
    }

    @DeleteMapping
    @ApiOperation(value = "방 삭제", notes = "삭제할 방에 대한 pk값을 주시면 됩니다.")
    public int deleteRoomWithRoomPk(@Parameter(description = "삭제할 방에 대한 pk값을 주시면 됩니다.", required = true) @RequestParam int room_pk) {
        int deleteResult = roomService.deleteRoomWithRoomPk(room_pk);

        return deleteResult;
    }

    @GetMapping(path = "/{room_pk}")
    @ApiOperation(value = "방 세부정보 조회", notes = "조회할 방에 대한 pk값을 주시면 방에 대한 정보를 반환합니다.")
    public Room selectRoomDetailWithRoomPk(@Parameter(description = "조회할 방에대한 pk값을 주시면 방에 대한 상세정보를 드립니다.", required = true) @PathVariable(name = "room_pk") int room_pk) {
        Room resultRoom = roomService.selectRoomDetailWithRoomPk(room_pk);

        return resultRoom;
    }
}
