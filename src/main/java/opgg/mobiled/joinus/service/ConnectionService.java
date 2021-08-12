package opgg.mobiled.joinus.service;

import opgg.mobiled.joinus.dto.Connections;
import opgg.mobiled.joinus.dto.Manner;

import java.util.List;

public interface ConnectionService {
    public int insertConnectionWithStartAndEndAndIsFriend(Connections connection_data);

    public List<Connections> selectConnectionWithStartAndIsFriend(int start_id, boolean friend_or_black);
}
