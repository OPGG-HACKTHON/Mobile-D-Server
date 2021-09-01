package opgg.mobiled.joinus.dao;

public class UserDaoSqls {
    public static final String SELECT_FIREBASE_TOKEN_WITH_TARGET_TOKEN = "SELECT * FROM user WHERE token = :target_token";
}
