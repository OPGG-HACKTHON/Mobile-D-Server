package opgg.mobiled.joinus.service;

import opgg.mobiled.joinus.dto.User;

import java.util.List;

public interface RoomUserService {
    public List<User> selectAllUserInRoomWithRooPk(int room_pk);
    public int insertUserInRoomWithRoomPkAndUserPk(int room_pk, int user_pk);
}
