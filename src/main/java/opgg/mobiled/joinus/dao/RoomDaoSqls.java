package opgg.mobiled.joinus.dao;

public class RoomDaoSqls {
    public static final String SELECT_ALL_ROOM = "SELECT * FROM room";
    public static final String INSERT_ROOM_WITH_ROOM_DATA = "INSERT INTO room (room_name, game_name, people_number, start_date, voice_chat, lowest_tier, highest_tier)"
            + " VALUES (:room_name, :game_name, :people_number, :start_date, :voice_chat, :lowest_tier, :highest_tier)";
    public static final String UPDATE_ROOM_DATA_WITH_ROOM_PK = "UPDATE room " +
            "SET room_name = :room_name, game_name = :game_name, people_number = :people_number, start_date = :start_date, voice_chat = :voice_chat, lowest_tier = :lowest_tier, highest_tier = :highest_tier " +
            "WHERE pk = :pk";
    public static final String DELETE_ROOM_WITH_ROOM_PK = "DELETE FROM room WHERE pk = :pk";
    public static final String SELECT_ROOM_DETAIL_WITH_ROOM_PK = "SELECT * FROM room WHERE pk = :pk";
}
