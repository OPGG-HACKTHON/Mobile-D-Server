package opgg.mobiled.joinus.dao;

public class GameDaoSqls {
    public static final String SELECT_GAME_WITH_USER_PK = "SELECT * FROM game WHERE user_pk = :user_pk";
    public static final String INSERT_GAME_WITH_USER_PK_AND_GAME_DATA = "INSERT INTO game (user_pk,name,game_id,tier) VALUES (:user_pk, :name, :game_id, :tier)";
    public static final String UPDATE_GAME_WITH_GAME_DATA = "UPDATE game SET name = :name , game_id = :game_id , tier = :tier WHERE pk = :pk";
    public static final String DELETE_GAME_WITH_GAME_PK = "DELETE FROM game WHERE pk = :pk";
}
