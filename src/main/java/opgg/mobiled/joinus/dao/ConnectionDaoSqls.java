package opgg.mobiled.joinus.dao;

public class ConnectionDaoSqls {
    public static final String INSERT_CONNECTION_WITH_START_AND_END_AND_FRIEND_OR_BLACK = "INSERT INTO connections (start_id,end_id,friend_or_black) VALUES (:start_id, :end_id, :friend_or_black)";
    public static final String SELECT_USER_WITH_START_AND_FRIEND_OR_BLACK = "SELECT * FROM user WHERE pk IN (SELECT end_id FROM connections WHERE start_id = :start_id and friend_or_black = :friend_or_black)";
}
