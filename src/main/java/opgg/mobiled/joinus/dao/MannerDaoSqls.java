package opgg.mobiled.joinus.dao;

public class MannerDaoSqls {
    public static final String INSERT_MANNER_WITH_USER_PK_AND_TARET_PK_AND_MANNER = "INSERT INTO manner (user_pk,target_pk,manner) VALUES (:user_pk, :target_pk, :manner)";
    public static final String SELECT_MANNER_WITH_TARGET_PK = "SELECT * FROM manner WHERE target_pk = :target_pk";
}
