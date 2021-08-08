package opgg.mobiled.joinus.dao;

import opgg.mobiled.joinus.dto.Room;
import opgg.mobiled.joinus.dto.RoomAndRoomUserVO;
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
public class RoomDao {
    private static NamedParameterJdbcTemplate jdbc;
    private static RowMapper<Room> roomRowMapper = BeanPropertyRowMapper.newInstance(Room.class);

    public RoomDao(DataSource dataSource) {this.jdbc = new NamedParameterJdbcTemplate(dataSource);}

    public static List<Room> selectAllRoom() {
        Map<String, Integer> params = new HashMap<>();
        return jdbc.query(RoomDaoSqls.SELECT_ALL_ROOM,params,roomRowMapper);
    }

    public static int insertRoomWithRoomData(RoomAndRoomUserVO roomAndRoomUserVO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(roomAndRoomUserVO);
        jdbc.update(RoomDaoSqls.INSERT_ROOM_WITH_ROOM_DATA,sqlParameterSource,keyHolder);
        return keyHolder.getKey().intValue();
    }

    public static int insertRoomUserWithRoomPkAndUserPk(int room_pk, int user_pk, int is_leader) {
        Map<String, Integer> params = new HashMap<>();
        params.put("room_pk",room_pk);
        params.put("user_pk",user_pk);
        params.put("is_leader",is_leader);
        return jdbc.update(RoomDaoSqls.INSERT_ROOM_USER_WITH_ROOM_PK_AND_USER_PK,params);
    }

    public static int updateRoomWithRoomData(Room room) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(room);
        jdbc.update(RoomDaoSqls.UPDATE_ROOM_DATA_WITH_ROOM_PK,sqlParameterSource,keyHolder);
        return keyHolder.getKey().intValue();
    }
}
