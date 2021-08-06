package opgg.mobiled.joinus.service;

import opgg.mobiled.joinus.dto.Game;

import java.util.List;

public interface GameService {
    public List<Game> selectGame(int user_pk);
    public int insertGameListWithUserPkAndGameInformation(Game game_data);
    public int updateGameDataWithGameData(Game game_data);
}
