package opgg.mobiled.joinus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 필요한 dao와 dto, service 임포트
import opgg.mobiled.joinus.service.GameService;
import opgg.mobiled.joinus.dao.GameDao;
import opgg.mobiled.joinus.dto.Game;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private GameDao gameDao;

    @Autowired
    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }
    
    @Override
    public List<Game> selectGame(int user_pk) {
        List<Game> game = gameDao.selectGame(user_pk);
        return game;
    }

    @Override
    public int insertGameListWithUserPkAndGameInformation(Game game_data) {
        int resultInsert = gameDao.insertGameListWithUserPkAndGameInformation(game_data);

        return  resultInsert;
    }

    @Override
    public int updateGameDataWithGameData(Game game_data) {
        int resultUpdate = gameDao.updateGameDataWithGameData(game_data);

        return resultUpdate;
    }
}
