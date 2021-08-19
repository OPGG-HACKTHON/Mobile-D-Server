package opgg.mobiled.joinus.controller;

import opgg.mobiled.joinus.dto.SocketVO;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

    @MessageMapping("/socket/receive/{room_pk}")
    @SendTo("/socket/send/{room_pk}")
    public SocketVO SocketHandler(@DestinationVariable int room_pk, SocketVO socketVO) {
        return new SocketVO(socketVO.getUser_name(),socketVO.getContent(),socketVO.getRoom_pk(),socketVO.getIs_ban(),socketVO.getTarget_name());
    }
}
