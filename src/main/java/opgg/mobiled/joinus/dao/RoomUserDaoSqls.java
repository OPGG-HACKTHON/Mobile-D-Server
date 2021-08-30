package opgg.mobiled.joinus.dao;

public class RoomUserDaoSqls {
    public static final String INSERT_ROOM_USER_WITH_ROOM_PK_AND_USER_PK = "INSERT INTO roomuser (user_pk, room_pk, is_leader)"
            + " VALUES (:user_pk, :room_pk, :is_leader)";
    public static final String SELECT_ALL_USER_IN_ROOM_WITH_ROOM_PK = "SELECT user_pk FROM roomuser WHERE room_pk = :room_pk";
    public static final String SELECT_USER_DETAIL_WITH_USER_PK = "SELECT * FROM user WHERE pk = :user_pk";
    public static final String DELETE_ROOM_USER_WITH_ROOM_USER_PK = "DELETE FROM roomuser WHERE pk = :pk";
    public static final String SELECT_IS_SAME_USER_COUNT_WITH_ROOM_PEOPLE_NUMBER = "select count(*) = room.people_number " +
            "from roomuser as RU " +
            "INNER JOIN room " +
            "ON room.pk = RU.room_pk " +
            "WHERE room.pk = :room_pk " +
            "group by room.pk ";
    public static final String DELETE_ROOM_USER_WITH_ROOM_PK = "DELETE FROM roomuser WHERE room_pk = :room_pk";
}
