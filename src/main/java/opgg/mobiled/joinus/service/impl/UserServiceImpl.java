package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dao.OnboardDao;
import opgg.mobiled.joinus.dao.UserDao;
import opgg.mobiled.joinus.dto.Manner;
import opgg.mobiled.joinus.dto.Onboard;
import opgg.mobiled.joinus.dto.User;
import opgg.mobiled.joinus.service.OnboardService;
import opgg.mobiled.joinus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

}
