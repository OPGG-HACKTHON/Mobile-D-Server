package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dao.ConnectionDao;
import opgg.mobiled.joinus.dto.Connections;
import opgg.mobiled.joinus.dto.User;
import opgg.mobiled.joinus.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {
    private ConnectionDao connectionDao;

    @Autowired
    public ConnectionServiceImpl(ConnectionDao connectionDao) {
        this.connectionDao = connectionDao;
    }

    @Override
    public int insertConnectionWithStartAndEndAndIsFriend(Connections connection_data) {
        int resultInsert = connectionDao.insertConnectionWithStartAndEndAndIsFriend(connection_data);
        return resultInsert;
    }

    @Override
    public List<User> selectConnectionWithStartAndIsFriend(int start_id, boolean friend_or_black) {
        List<User> users = connectionDao.selectUserWithStartAndFriendOrBlack(start_id,friend_or_black);
        return users;
    }
}
