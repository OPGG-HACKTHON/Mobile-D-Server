package opgg.mobiled.joinus.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import opgg.mobiled.joinus.dto.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LoginDao {
    private static RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);;
    private static NamedParameterJdbcTemplate jdbc;

    public LoginDao(DataSource dataSource) {this.jdbc = new NamedParameterJdbcTemplate(dataSource);}

    public static User Login(String token) {
        Map<String, String> params = new HashMap<>();
        params.put("token",token);
        return jdbc.queryForObject(LoginDaoSqls.SELECT_USER_WITH_LOGIN_TOKEN,params,userRowMapper);
    }

    public static int SignupWithOnlyToken(String token) {
        Map<String, String> params = new HashMap<>();
        params.put("token",token);
        return jdbc.update(LoginDaoSqls.INSERT_USER_WITH_ONLY_LOGIN_TOKEN,params);
    }
}
