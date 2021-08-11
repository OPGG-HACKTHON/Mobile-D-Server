package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dao.GameDao;
import opgg.mobiled.joinus.dao.MannerDao;
import opgg.mobiled.joinus.dto.Manner;
import opgg.mobiled.joinus.service.MannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MannerServiceImpl implements MannerService {
    private MannerDao mannerDao;

    @Autowired
    public MannerServiceImpl(MannerDao mannerDao) {
        this.mannerDao = mannerDao;
    }

    @Override
    public int insertMannerWithUserPkAndTargetPkAndManner(Manner manner_data) {
        int resultInsert = mannerDao.insertMannerWithUserPkAndTargetPkAndManner(manner_data);
        return resultInsert;
    }
}
