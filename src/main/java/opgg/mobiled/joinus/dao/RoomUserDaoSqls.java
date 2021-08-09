package opgg.mobiled.joinus.dao;

public class RoomUserDaoSqls {
    public static final String INSERT_ROOM_USER_WITH_ROOM_PK_AND_USER_PK = "INSERT INTO ROOMUSER (user_pk, room_pk, is_leader)"
            + " VALUES (:user_pk, :room_pk, :is_leader)";
    public static final String SELECT_ALL_USER_IN_ROOM_WITH_ROOM_PK = "SELECT user_pk FROM roomuser WHERE room_pk = :room_pk";
    public static final String SELECT_USER_DETAIL_WITH_USER_PK = "SELECT * FROM user WHERE pk = :user_pk";
}
