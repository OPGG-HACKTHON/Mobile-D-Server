package opgg.mobiled.joinus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SocketVO {
    private String user_name;
    private String content;
    private int room_pk;
    private String is_ban;
    private String target_name;
}
