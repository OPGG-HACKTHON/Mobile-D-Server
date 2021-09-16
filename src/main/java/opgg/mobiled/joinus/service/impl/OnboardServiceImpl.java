package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dao.GameDao;
import opgg.mobiled.joinus.dao.OnboardDao;
import opgg.mobiled.joinus.dao.UserDao;
import opgg.mobiled.joinus.dto.Game;
import opgg.mobiled.joinus.dto.Onboard;
import opgg.mobiled.joinus.dto.User;
import opgg.mobiled.joinus.service.GameService;
import opgg.mobiled.joinus.service.OnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnboardServiceImpl implements OnboardService {
    private OnboardDao onboardDao;
    private UserDao userDao;

    private static String PROFILE_BLUE = "https://raw.githubusercontent.com/OPGG-HACKTHON/Mobile-D-Server/master/storage/profile_blue.png";
    private static String PROFILE_GREEN = "https://raw.githubusercontent.com/OPGG-HACKTHON/Mobile-D-Server/master/storage/profile_green.png";
    private static String PROFILE_PURPLE = "https://raw.githubusercontent.com/OPGG-HACKTHON/Mobile-D-Server/master/storage/profile_purple.png";
    private static String PROFILE_ORANGE = "https://raw.githubusercontent.com/OPGG-HACKTHON/Mobile-D-Server/master/storage/profile_orange.png";
    private static String PROFILE_YELLOW = "https://raw.githubusercontent.com/OPGG-HACKTHON/Mobile-D-Server/master/storage/profile_yellow.png";

    @Autowired
    public OnboardServiceImpl(OnboardDao onboardDao, UserDao userDao) {
        this.onboardDao = onboardDao;
        this.userDao = userDao;
    }


    @Override
    public int updateOnboardWithOnboardData(Onboard onboard_data) {
        //조회 후 있으면 업데이트 진행 , 없으면 99999반환
        if(userDao.selectUserWithToken(onboard_data.getSub()).size() < 1){
            return 99999;
        }
        //random으로 지정하기
        String[] urls = { PROFILE_BLUE, PROFILE_GREEN, PROFILE_PURPLE, PROFILE_ORANGE, PROFILE_YELLOW };
        onboard_data.setImage_address(urls[(int)(Math.random()*5)]);

        int resultUpdate = onboardDao.updateOnboardWithOnboardData(onboard_data);
        return resultUpdate;
    }
}
