package opgg.mobiled.joinus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Room {
    private int pk;
    private String room_name;
    private String game_name;
    private int people_number;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Seoul")
    private Timestamp start_date;
    private boolean voice_chat;
    private int lowest_tier;
    private int highest_tier;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public int getPeople_number() {
        return people_number;
    }

    public void setPeople_number(int people_number) {
        this.people_number = people_number;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public boolean isVoice_chat() {
        return voice_chat;
    }

    public void setVoice_chat(boolean voice_chat) {
        this.voice_chat = voice_chat;
    }

    public int getLowest_tier() {
        return lowest_tier;
    }

    public void setLowest_tier(int lowest_tier) {
        this.lowest_tier = lowest_tier;
    }

    public int getHighest_tier() {
        return highest_tier;
    }

    public void setHighest_tier(int highest_tier) {
        this.highest_tier = highest_tier;
    }
}
