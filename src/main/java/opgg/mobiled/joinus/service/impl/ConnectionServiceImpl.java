package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dao.ConnectionDao;
import opgg.mobiled.joinus.dao.MannerDao;
import opgg.mobiled.joinus.dto.Connections;
import opgg.mobiled.joinus.dto.Manner;
import opgg.mobiled.joinus.service.ConnectionService;
import opgg.mobiled.joinus.service.MannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Connections> selectConnectionWithStartAndIsFriend(int start_id, boolean friend_or_black) {
        List<Connections> connections = connectionDao.selectConnectionWithStartAndIsFriend(start_id,friend_or_black);
        return connections;
    }
}
