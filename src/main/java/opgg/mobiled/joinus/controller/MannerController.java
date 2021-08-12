package opgg.mobiled.joinus.controller;

import io.swagger.v3.oas.annotations.Parameter;
import opgg.mobiled.joinus.dto.Game;
import opgg.mobiled.joinus.dto.Manner;
import opgg.mobiled.joinus.service.MannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/manner") // 해당 주소로 들어오면 아래의 함수를 메소드와 함께 이용 가능, 더 자원을 표시하고 싶다면 더 표시 가능
public class MannerController {
    private MannerService mannerService;

    @Autowired
    public MannerController(MannerService mannerService) {
        this.mannerService = mannerService;
    }

    @PostMapping
    public int insertMannerWithUserPkAndTargetPkAndManner(@RequestBody Manner manner_data) {
        int insertResult = mannerService.insertMannerWithUserPkAndTargetPkAndManner(manner_data);

        return insertResult;
    }

    @GetMapping
    public int selectMannerWithTargetPK(@Parameter(description = "타겟 유저 pk 값", required = true, example = "2") @RequestParam int target_pk){
        int mannerResult = mannerService.selectAndCalculateManner(target_pk);
        return mannerResult;
    }


//    @GetMapping
//    public List<Game> selectGameListWithUserPk(@Parameter(description = "유저 pk 값", required = true, example = "4") @RequestParam int user_pk) {
//        List<Game> resultGame = gameService.selectGame(user_pk);
//
//        return resultGame;
//    }
}
