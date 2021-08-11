package opgg.mobiled.joinus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private int pk;
    private int user_pk;
    private String name;
    private String game_id;
    private int tier;
}
