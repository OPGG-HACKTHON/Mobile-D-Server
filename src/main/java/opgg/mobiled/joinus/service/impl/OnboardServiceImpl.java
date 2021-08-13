package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dao.GameDao;
import opgg.mobiled.joinus.dao.OnboardDao;
import opgg.mobiled.joinus.dto.Game;
import opgg.mobiled.joinus.dto.Onboard;
import opgg.mobiled.joinus.service.GameService;
import opgg.mobiled.joinus.service.OnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnboardServiceImpl implements OnboardService {
    private OnboardDao onboardDao;

    @Autowired
    public OnboardServiceImpl(OnboardDao onboardDao) {
        this.onboardDao = onboardDao;
    }


    @Override
    public int updateOnboardWithOnboardData(Onboard onboard_data) {
        int resultUpdate = onboardDao.updateOnboardWithOnboardData(onboard_data);
        return resultUpdate;
    }
}
