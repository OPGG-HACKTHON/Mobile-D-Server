package opgg.mobiled.joinus.service;

import opgg.mobiled.joinus.dto.Room;
import opgg.mobiled.joinus.dto.RoomAndRoomUserVO;

import java.util.List;

public interface RoomService {
    public List<Room> selectAllRoom();
    public int insertRoomAndRoomUserWithRoomDataAndUserPk(RoomAndRoomUserVO roomAndRoomUserVO);
    public int updateRoomWithRoomData(Room room);
    public int deleteRoomWithRoomPk(int room_pk);
    public Room selectRoomDetailWithRoomPk(int room_pk);
    public List<Room> selectRoomListWithUserSub(String sub, int myroom);
}
