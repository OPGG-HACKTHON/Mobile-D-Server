package opgg.mobiled.joinus.dao;

import opgg.mobiled.joinus.dto.Manner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MannerDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Manner> mannerRowMapper = BeanPropertyRowMapper.newInstance(Manner.class);

    public MannerDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public int insertMannerWithUserPkAndTargetPkAndManner(Manner manner_data) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(manner_data);
        jdbc.update(MannerDaoSqls.INSERT_MANNER_WITH_USER_PK_AND_TARET_PK_AND_MANNER,sqlParameterSource,keyHolder);
        return keyHolder.getKey().intValue();
    }

    public List<Manner> selectManner(int target_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("target_pk",target_pk);
        return jdbc.query(MannerDaoSqls.SELECT_MANNER_WITH_TARGET_PK, params, mannerRowMapper);
    }

//    public List<Game> selectGame(int user_pk) {
//        Map<String, Integer> params = new HashMap<>();
//        params.put("user_pk",user_pk);
//        return jdbc.query(GameDaoSqls.SELECT_GAME_WITH_USER_PK,params,gameRowMapper);
//    }
}
