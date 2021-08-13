package opgg.mobiled.joinus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Connections {
    private int pk;
    private int start_id;
    private int end_id;
    private boolean friend_or_black;
}
