package opgg.mobiled.joinus.dao;

public class RoomUserDaoSqls {
    public static final String INSERT_ROOM_USER_WITH_ROOM_PK_AND_USER_PK = "INSERT INTO roomuser (user_pk, room_pk, is_leader)"
            + " VALUES (:user_pk, :room_pk, :is_leader)";
    public static final String SELECT_ALL_USER_IN_ROOM_WITH_ROOM_PK = "SELECT user_pk FROM roomuser WHERE room_pk = :room_pk";
    public static final String SELECT_LEADER_IN_ROOM_WITH_ROOM_PK = "SELECT user_pk FROM roomuser WHERE room_pk = :room_pk and is_leader = 1";
    public static final String SELECT_ROOM_USER_COUNT_IN_ROOM_WITH_ROOM_PK = "SELECT count(*) FROM roomuser where room_pk = :room_pk";
    public static final String SELECT_USER_DETAIL_WITH_USER_PK = "SELECT * FROM user WHERE pk = :user_pk";
    public static final String DELETE_ROOM_USER_WITH_ROOM_USER_PK = "DELETE FROM roomuser WHERE pk = :pk";
    public static final String SELECT_IS_SAME_USER_COUNT_WITH_ROOM_PEOPLE_NUMBER = "select count(*) = room.people_number " +
            "from roomuser as RU " +
            "INNER JOIN room " +
            "ON room.pk = RU.room_pk " +
            "WHERE room.pk = :room_pk " +
            "group by room.pk ";
    public static final String DELETE_ROOM_USER_WITH_ROOM_PK = "DELETE FROM roomuser WHERE room_pk = :room_pk";
    public static final String SELECT_USER_LIST_WITH_ROOM_PK = "select us.pk,us.firebase_token,us.token,us.gender,us.age,ga.game_id " +
            "from roomuser as ru " +
            "inner join user as us on ru.user_pk = us.pk " +
            "inner join game as ga on ga.user_pk = us.pk " +
            "where ru.room_pk = :room_pk group by us.pk;";
}
