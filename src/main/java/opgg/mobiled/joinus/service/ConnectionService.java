package opgg.mobiled.joinus.service;

import opgg.mobiled.joinus.dto.Connections;
import opgg.mobiled.joinus.dto.Manner;
import opgg.mobiled.joinus.dto.User;

import java.util.List;

public interface ConnectionService {
    public int insertConnectionWithStartAndEndAndIsFriend(Connections connection_data);

    public List<User> selectConnectionWithStartAndIsFriend(int start_id, boolean friend_or_black);
}

