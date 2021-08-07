package opgg.mobiled.joinus.controller;

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
}
