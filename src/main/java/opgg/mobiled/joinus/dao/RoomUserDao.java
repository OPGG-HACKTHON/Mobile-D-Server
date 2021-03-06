package opgg.mobiled.joinus.dao;

import io.swagger.models.auth.In;
import opgg.mobiled.joinus.dto.Room;
import opgg.mobiled.joinus.dto.RoomUserInformationVO;
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
    private static RowMapper<RoomUserInformationVO> roomUserInformationVORowMapper = BeanPropertyRowMapper.newInstance(RoomUserInformationVO.class);

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

    public int selectLeaderInRoomWithRoomPk(int room_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("room_pk",room_pk);
        return jdbc.queryForObject(RoomUserDaoSqls.SELECT_LEADER_IN_ROOM_WITH_ROOM_PK,params,Integer.class);
    }

    public int selectRoomUserCountInRoomWithRoomPk(int room_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("room_pk",room_pk);
        return jdbc.queryForObject(RoomUserDaoSqls.SELECT_ROOM_USER_COUNT_IN_ROOM_WITH_ROOM_PK,params,Integer.class);
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

    public List<RoomUserInformationVO> selectUserListWithRoomPk (int room_pk) {
        Map<String, Integer> params = new HashMap<>();
        params.put("room_pk",room_pk);
        return jdbc.query(RoomUserDaoSqls.SELECT_USER_LIST_WITH_ROOM_PK,params,roomUserInformationVORowMapper);
    }

    public String selectGameIdWithUserPkAndGameName (int user_pk, String game_name) {
        Map<String, String> params = new HashMap<>();
        params.put("user_pk",Integer.toString(user_pk));
        params.put("game_name",game_name);
        return jdbc.queryForObject(RoomUserDaoSqls.SELECT_GAME_ID_WITH_USER_PK_AND_GAME_NAME,params,String.class);
    }

    public List<Integer> selectRoomPkListWithUserSubAndIsLeader(String sub, int myroom) {
        Map<String, String> params = new HashMap<>();
        params.put("sub",sub);
        params.put("is_leader",Integer.toString(myroom));
        return jdbc.queryForList(RoomUserDaoSqls.SELECT_ROOM_PK_LIST_WITH_USER_SUB_AND_IS_LEADER,params,Integer.class);
    }
}
