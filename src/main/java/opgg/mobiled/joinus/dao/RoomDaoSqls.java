package opgg.mobiled.joinus.dao;

public class RoomDaoSqls {
    public static final String SELECT_ALL_ROOM = "SELECT * FROM ROOM";
    public static final String INSERT_ROOM_WITH_ROOM_DATA = "INSERT INTO ROOM (room_name, game_name, people_number, start_date, voice_chat, lowest_tier, highest_tier)"
            + " VALUES (:room_name, :game_name, :people_number, :start_date, :voice_chat, :lowest_tier, :highest_tier)";
    public static final String INSERT_ROOM_USER_WITH_ROOM_PK_AND_USER_PK = "INSERT INTO ROOMUSER (user_pk, room_pk, is_leader)"
            + " VALUES (:user_pk, :room_pk, :is_leader)";
}
