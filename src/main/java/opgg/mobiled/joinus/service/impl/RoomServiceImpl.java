package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dao.GameDao;
import opgg.mobiled.joinus.dto.RoomAndRoomUserVO;
import opgg.mobiled.joinus.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import opgg.mobiled.joinus.service.RoomService;
import opgg.mobiled.joinus.dao.RoomUserDao;
import opgg.mobiled.joinus.dao.RoomDao;
import opgg.mobiled.joinus.dto.Room;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private RoomDao roomDao;
    private RoomUserDao roomUserDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao, RoomUserDao roomUserDao, GameDao gameDao) {
        this.roomDao = roomDao;
        this.roomUserDao = roomUserDao;
    }

    @Override
    public List<Room> selectAllRoom() {
        List<Room> resultRoomList = roomDao.selectAllRoom();
        for (int i = 0; i<resultRoomList.size(); i++) {
            resultRoomList.get(i).setLeader_pk(roomUserDao.selectLeaderInRoomWithRoomPk(resultRoomList.get(i).getPk()));
            resultRoomList.get(i).setNow_people_cnt(roomUserDao.selectRoomUserCountInRoomWithRoomPk(resultRoomList.get(i).getPk()));
            if (resultRoomList.get(i).getIs_start() == 0) {
                if (resultRoomList.get(i).getPeople_number() == resultRoomList.get(i).getNow_people_cnt()) {
                    resultRoomList.get(i).setIs_start(2);
                }
            }
            List<Integer> user_pk_list = roomUserDao.selectAllUserPkInRoomWithRoomPk(resultRoomList.get(i).getPk());
            List<User> user_list = new ArrayList<>();
            for (int j = 0; j<user_pk_list.size(); j++) {
                user_list.add(roomUserDao.selectUserDetailWithUserPk(user_pk_list.get(j)));
                user_list.get(j).setNickname(roomUserDao.selectGameIdWithUserPkAndGameName(user_pk_list.get(j),resultRoomList.get(i).getGame_name()));
            }
            resultRoomList.get(i).setUser_list(user_list);
        }

        return resultRoomList;
    }

    @Override
    public int insertRoomAndRoomUserWithRoomDataAndUserPk(RoomAndRoomUserVO roomAndRoomUserVO) {
        int resultRoomPk = roomDao.insertRoomWithRoomData(roomAndRoomUserVO);
        int resultRoomUserPk = roomUserDao.insertRoomUserWithRoomPkAndUserPk(resultRoomPk,roomAndRoomUserVO.getUser_pk(),1);
        return resultRoomPk;
    }

    @Override
    public int updateRoomWithRoomData(Room room) {
        int resultUpdate = roomDao.updateRoomWithRoomData(room);

        return resultUpdate;
    }

    @Override
    public int deleteRoomWithRoomPk(int room_pk) {
        int resultDelete = roomDao.deleteRoomWithRoomPk(room_pk);

        return resultDelete;
    }

    @Override
    public Room selectRoomDetailWithRoomPk(int room_pk) {
        Room resultRoom = roomDao.selectRoomDetailWithRoomPk(room_pk);
        resultRoom.setLeader_pk(roomUserDao.selectLeaderInRoomWithRoomPk(resultRoom.getPk()));
        resultRoom.setNow_people_cnt(roomUserDao.selectRoomUserCountInRoomWithRoomPk(resultRoom.getPk()));
        if (resultRoom.getIs_start() == 0) {
            if (resultRoom.getPeople_number() == resultRoom.getNow_people_cnt()) {
                resultRoom.setIs_start(2);
            }
        }
        List<Integer> user_pk_list = roomUserDao.selectAllUserPkInRoomWithRoomPk(resultRoom.getPk());
        List<User> user_list = new ArrayList<>();
        for (int j = 0; j<user_pk_list.size(); j++) {
            user_list.add(roomUserDao.selectUserDetailWithUserPk(user_pk_list.get(j)));
            user_list.get(j).setNickname(roomUserDao.selectGameIdWithUserPkAndGameName(user_pk_list.get(j),resultRoom.getGame_name()));
        }
        resultRoom.setUser_list(user_list);
        return resultRoom;
    }
}
