package opgg.mobiled.joinus.dto;

public class Game {
    private int pk;
    private int user_pk;
    private String name;
    private String game_id;
    private int tier;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getUser_pk() {
        return user_pk;
    }

    public void setUser_pk(int user_pk) {
        this.user_pk = user_pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}
