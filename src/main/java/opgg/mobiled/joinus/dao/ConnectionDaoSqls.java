package opgg.mobiled.joinus.dao;

public class ConnectionDaoSqls {
    public static final String INSERT_CONNECTION_WITH_START_AND_END_AND_ISFRIEND = "INSERT INTO connections (start_id,end_id,friend_or_black) VALUES (:start_id, :end_id, :friend_or_black)";
    public static final String SELECT_CONNECTION_WITH_START_AND_ISFRIEND = "SELECT * FROM connections WHERE start_id = :start_id AND friend_or_black = :friend_or_black";
}
