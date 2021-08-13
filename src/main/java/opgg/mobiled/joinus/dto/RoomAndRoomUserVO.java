package opgg.mobiled.joinus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RoomAndRoomUserVO {
    private String room_name;
    private String game_name;
    private int people_number;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Seoul")
    private Timestamp start_date;
    private boolean voice_chat;
    private int lowest_tier;
    private int highest_tier;

    private int user_pk;
}
