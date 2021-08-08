package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dto.RoomAndRoomUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opgg.mobiled.joinus.service.RoomService;
import opgg.mobiled.joinus.dao.RoomDao;
import opgg.mobiled.joinus.dto.Room;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) { this.roomDao = roomDao; }

    @Override
    public List<Room> selectAllRoom() {
        List<Room> resultRoomList = roomDao.selectAllRoom();

        return resultRoomList;
    }

    @Override
    public int insertRoomAndRoomUserWithRoomDataAndUserPk(RoomAndRoomUserVO roomAndRoomUserVO) {
        int resultRoomPk = roomDao.insertRoomWithRoomData(roomAndRoomUserVO);
        int resultRoomUserPk = roomDao.insertRoomUserWithRoomPkAndUserPk(resultRoomPk,roomAndRoomUserVO.getUser_pk(),1);
        return resultRoomPk;
    }

    @Override
    public int updateRoomWithRoomData(Room room) {
        int resultUpdate = roomDao.updateRoomWithRoomData(room);

        return resultUpdate;
    }
}
