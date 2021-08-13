package opgg.mobiled.joinus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int pk;
    private String token;
    private String firebase_token;
    private int gender;
    private int age;
    private String image_address;
    private String nickname;
}
