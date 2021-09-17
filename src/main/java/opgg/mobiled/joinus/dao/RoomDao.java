package opgg.mobiled.joinus.dao;

import opgg.mobiled.joinus.dto.OnlyRoom;
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

    public static int updateRoomWithRoomData(OnlyRoom room) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(room);
        try {
            jdbc.update(RoomDaoSqls.UPDATE_ROOM_DATA_WITH_ROOM_PK,sqlParameterSource,keyHolder);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int deleteRoomWithRoomPk(int room_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("pk",room_pk);
        return jdbc.update(RoomDaoSqls.DELETE_ROOM_WITH_ROOM_PK,params);
    }

    public static Room selectRoomDetailWithRoomPk(int room_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("pk",room_pk);
        return jdbc.queryForObject(RoomDaoSqls.SELECT_ROOM_DETAIL_WITH_ROOM_PK,params,roomRowMapper);
    }
}
