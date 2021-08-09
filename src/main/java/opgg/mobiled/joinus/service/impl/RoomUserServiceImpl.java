package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dao.RoomUserDao;
import opgg.mobiled.joinus.dto.User;
import opgg.mobiled.joinus.service.RoomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomUserServiceImpl implements RoomUserService {
    private RoomUserDao roomUserDao;

    @Autowired
    public RoomUserServiceImpl(RoomUserDao roomUserDao) {this.roomUserDao = roomUserDao;}

    @Override
    public List<User> selectAllUserInRoomWithRooPk(int room_pk) {
        List<Integer> roomUserPkList = roomUserDao.selectAllUserPkInRoomWithRoomPk(room_pk);
        List<User> resultUserList = new ArrayList<User>();
        for(int i = 0; i<roomUserPkList.size(); i++) {
            resultUserList.add(roomUserDao.selectUserDetailWithUserPk(roomUserPkList.get(i)));
        }
        return resultUserList;
    }

    @Override
    public int insertUserInRoomWithRoomPkAndUserPk(int room_pk, int user_pk) {
        int resultInsert = roomUserDao.insertRoomUserWithRoomPkAndUserPk(room_pk,user_pk,0);
        return resultInsert;
    }
}