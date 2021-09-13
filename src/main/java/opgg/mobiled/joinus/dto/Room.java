package opgg.mobiled.joinus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class Room {
    private int pk;
    private String room_name;
    private String game_name;
    private int people_number;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Seoul")
    private Timestamp start_date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Seoul")
    private Timestamp created_at;
    private boolean voice_chat;
    private int lowest_tier;
    private int highest_tier;

    private int is_start;
    private int now_people_cnt;

    private int leader_pk;
    private List<User> user_list;

    private int room_manner;
}
