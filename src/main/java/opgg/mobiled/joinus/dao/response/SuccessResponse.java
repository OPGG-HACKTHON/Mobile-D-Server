package opgg.mobiled.joinus.dao.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse extends BasicResponse{
    private int status;
    private String message;


    public SuccessResponse() {
    }

    public SuccessResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
