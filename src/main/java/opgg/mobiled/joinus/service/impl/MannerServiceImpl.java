package opgg.mobiled.joinus.service.impl;

import opgg.mobiled.joinus.dao.MannerDao;
import opgg.mobiled.joinus.dto.Manner;
import opgg.mobiled.joinus.service.MannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int selectAndCalculateManner(int target_pk) {
        List<Manner> manners = mannerDao.selectManner(target_pk);
        //TODO : 매너도 계산 로직 전개
        //good이면 +1, bad이면 -1로 계산해서 결과 값 return

        int resultManner = 0;
        for (Manner m : manners) {
            switch (m.getManner()){
                case 1: //manner good
                    resultManner++;
                    break;
                case 0: //manner bad
                    resultManner--;
                    break;
            }
        }
        return resultManner;
    }
}
