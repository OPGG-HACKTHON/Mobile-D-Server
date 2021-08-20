package opgg.mobiled.joinus.dao.firebase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PushNotificationResponse {
    private int status;
    private String message;


    public PushNotificationResponse() {
    }

    public PushNotificationResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}