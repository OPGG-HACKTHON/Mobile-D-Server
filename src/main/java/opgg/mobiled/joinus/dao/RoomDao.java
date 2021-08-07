package opgg.mobiled.joinus.dao;

import opgg.mobiled.joinus.dto.Room;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomDao {
    private static NamedParameterJdbcTemplate jdbc;
    private static RowMapper<Room> roomRowMapper = BeanPropertyRowMapper.newInstance(Room.class);

    public RoomDao(DataSource dataSource) {this.jdbc = new NamedParameterJdbcTemplate(dataSource);}

    public static List<Room> selectAllRoom() {
        Map<String, Integer> params = new HashMap<>();
        return jdbc.query(RoomDaoSqls.SELECT_ALL_ROOM,params,roomRowMapper);
    }
}
