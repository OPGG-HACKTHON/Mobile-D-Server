package opgg.mobiled.joinus.dao;

public class UserDaoSqls {
    public static final String SELECT_USER_WITH_TOKEN = "SELECT * FROM user WHERE token = :token";
}
