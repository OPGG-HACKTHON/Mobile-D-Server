package opgg.mobiled.joinus.dao.firebase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PushNotificationRequest {
    private String title;
    private String message;
    private String topic;
    private String token;


    public PushNotificationRequest() {
        super();
    }

    public PushNotificationRequest(String title, String message, String topic, String token) {
        super();
        this.title = title;
        this.message = message;
        this.topic = topic;
        this.token = token;
    }
}
