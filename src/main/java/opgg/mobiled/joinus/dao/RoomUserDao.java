package opgg.mobiled.joinus.dao;

import opgg.mobiled.joinus.dto.Room;
import opgg.mobiled.joinus.dto.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomUserDao {
    private static NamedParameterJdbcTemplate jdbc;
    private static RowMapper<Room> roomRowMapper = BeanPropertyRowMapper.newInstance(Room.class);
    private static RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public RoomUserDao(DataSource dataSource) {this.jdbc = new NamedParameterJdbcTemplate(dataSource);}

    public static int insertRoomUserWithRoomPkAndUserPk(int room_pk, int user_pk, int is_leader) {
        Map<String, Integer> params = new HashMap<>();
        params.put("room_pk",room_pk);
        params.put("user_pk",user_pk);
        params.put("is_leader",is_leader);
        return jdbc.update(RoomUserDaoSqls.INSERT_ROOM_USER_WITH_ROOM_PK_AND_USER_PK,params);
    }

    public List<Integer> selectAllUserPkInRoomWithRoomPk(int room_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("room_pk",room_pk);
        return jdbc.queryForList(RoomUserDaoSqls.SELECT_ALL_USER_IN_ROOM_WITH_ROOM_PK,params,Integer.class);
    }

    public User selectUserDetailWithUserPk(int user_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("user_pk",user_pk);
        return jdbc.queryForObject(RoomUserDaoSqls.SELECT_USER_DETAIL_WITH_USER_PK,params,userRowMapper);
    }

    public int deleteUserInRoomWithRoomUserPk(int room_user_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("pk",room_user_pk);
        return jdbc.update(RoomUserDaoSqls.DELETE_ROOM_USER_WITH_ROOM_USER_PK,params);
    }

    public boolean checkIsFullRoomWithRoomPk(int room_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("room_pk",room_pk);
        return 1 == jdbc.queryForObject(RoomUserDaoSqls.SELECT_IS_SAME_USER_COUNT_WITH_ROOM_PEOPLE_NUMBER, params,Integer.class);
    }

    public int deleteUserInRoomWithRoomPk(int room_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("room_pk",room_pk);
        return jdbc.update(RoomUserDaoSqls.DELETE_ROOM_USER_WITH_ROOM_PK,params);
    }
}
