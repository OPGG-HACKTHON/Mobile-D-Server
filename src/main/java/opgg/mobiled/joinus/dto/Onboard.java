package opgg.mobiled.joinus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Onboard {
    @Schema(description = "front 로부터 전달 받는 token 값")
    private String sub; //front 로부터 전달 받는 token 값 (user 테이블에 존재하는지 확인 후 해당 컬럼에 값을 업데이트한다.)
    private int gender;
    private int age;
    private String image_address;
    private String nickname;
}
