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
        String[] urls = {"a", "b", "c", "d", "e"};
        onboard_data.setImage_address(urls[(int)(Math.random()*5)]);

        int resultUpdate = onboardDao.updateOnboardWithOnboardData(onboard_data);
        return resultUpdate;
    }
}
