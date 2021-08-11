package opgg.mobiled.joinus.dao;

import opgg.mobiled.joinus.dto.Game;
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
}
