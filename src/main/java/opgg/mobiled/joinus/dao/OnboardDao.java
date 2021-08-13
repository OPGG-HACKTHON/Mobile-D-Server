package opgg.mobiled.joinus.dao;

import opgg.mobiled.joinus.dto.Game;
import opgg.mobiled.joinus.dto.Onboard;
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
public class OnboardDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Onboard> onboardRowMapper = BeanPropertyRowMapper.newInstance(Onboard.class);

    public OnboardDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public int updateOnboardWithOnboardData(Onboard onboard_data) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(onboard_data);
        int updateResult = jdbc.update(OnboardDaoSqls.UPDATE_ONBOARD_WITH_ONBOARD_DATA,sqlParameterSource,keyHolder);
        return updateResult;
    }
}
