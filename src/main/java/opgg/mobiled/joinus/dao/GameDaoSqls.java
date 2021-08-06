package opgg.mobiled.joinus.dao;

public class GameDaoSqls {
    public static final String SELECT_GAME_WITH_USER_PK = "SELECT * FROM game WHERE user_pk = :user_pk";
    public static final String INSERT_GAME_WITH_USER_PK_AND_GAME_DATA = "INSERT INTO game (user_pk,name,game_id,tier) VALUES (:user_pk, :name, :game_id, :tier)";
}
