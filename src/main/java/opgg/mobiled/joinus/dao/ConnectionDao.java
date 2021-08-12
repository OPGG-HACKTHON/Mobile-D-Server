package opgg.mobiled.joinus.dao;

import opgg.mobiled.joinus.dto.Connections;
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
public class ConnectionDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Connections> connectionsRowMapper = BeanPropertyRowMapper.newInstance(Connections.class);

    public ConnectionDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public int insertConnectionWithStartAndEndAndIsFriend(Connections connection_data) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(connection_data);
        jdbc.update(ConnectionDaoSqls.INSERT_CONNECTION_WITH_START_AND_END_AND_ISFRIEND,sqlParameterSource,keyHolder);
        return keyHolder.getKey().intValue();
    }

    public List<Connections> selectConnectionWithStartAndIsFriend(int start_id, boolean friend_or_black) {
        Map<String, Object> params = new HashMap<>();
        params.put("start_id",start_id);
        params.put("friend_or_black",friend_or_black);
        return jdbc.query(ConnectionDaoSqls.SELECT_CONNECTION_WITH_START_AND_ISFRIEND, params, connectionsRowMapper);
    }
}
