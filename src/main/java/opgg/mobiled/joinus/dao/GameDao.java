package opgg.mobiled.joinus.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

// 위는 보통 가져오는 것들
// 아래에 필요한 Dto와 필요한 java util들을 임포트 한다
import opgg.mobiled.joinus.dto.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GameDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Game> gameRowMapper = BeanPropertyRowMapper.newInstance(Game.class);

    public GameDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Game> selectGame(int user_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("user_pk",user_pk);
        return jdbc.query(GameDaoSqls.SELECT_GAME_WITH_USER_PK,params,gameRowMapper);
    }

    public int insertGameListWithUserPkAndGameInformation(Game game_data) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(game_data);
        jdbc.update(GameDaoSqls.INSERT_GAME_WITH_USER_PK_AND_GAME_DATA,sqlParameterSource,keyHolder);
        return keyHolder.getKey().intValue();
    }

    public int updateGameDataWithGameData(Game game_data) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(game_data);
        jdbc.update(GameDaoSqls.UPDATE_GAME_WITH_GAME_DATA,sqlParameterSource,keyHolder);
        return keyHolder.getKey().intValue();
    }
}
