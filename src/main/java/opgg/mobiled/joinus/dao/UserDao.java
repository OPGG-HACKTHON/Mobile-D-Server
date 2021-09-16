package opgg.mobiled.joinus.dao;

import opgg.mobiled.joinus.dto.Manner;
import opgg.mobiled.joinus.dto.User;
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
public class UserDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<User> selectUserWithToken(String token) {
        Map<String, String> params = new HashMap<>();
        params.put("token",token);
        return jdbc.query(UserDaoSqls.SELECT_USER_WITH_TOKEN, params, userRowMapper);
    }

    public List<User> selectUserWithPk(int pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("pk",pk);
        return jdbc.query(UserDaoSqls.SELECT_USER_WITH_PK, params, userRowMapper);
    }
}
