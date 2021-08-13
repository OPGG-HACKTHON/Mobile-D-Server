package opgg.mobiled.joinus.dao;

public class LoginDaoSqls {
    public static final String SELECT_USER_WITH_LOGIN_TOKEN = "SELECT * FROM user WHERE token = :token";
    public static final String INSERT_USER_WITH_ONLY_LOGIN_TOKEN = "INSERT INTO user (token,gender,age) VALUES (:token,0,0)";
}
