package opgg.mobiled.joinus.dao;

public class OnboardDaoSqls {
    public static final String UPDATE_ONBOARD_WITH_ONBOARD_DATA = "UPDATE user SET gender = :gender , age = :age " +
            ", image_address = :image_address, nickname = :nickname WHERE token = :sub";
}
