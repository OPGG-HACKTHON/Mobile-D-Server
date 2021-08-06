package opgg.mobiled.joinus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;

// 위는 거의 기본적으로 들어가는 rest backend를 위한 패키지
// 이 아래에는 필요한 dto, service, 기타 쿠키나 세션관련된 패키지를 임포트 할 것
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import opgg.mobiled.joinus.service.GameService;
import opgg.mobiled.joinus.dto.Game;

import java.util.List;

@RestController
@RequestMapping(path = "/api/game") // 해당 주소로 들어오면 아래의 함수를 메소드와 함께 이용 가능, 더 자원을 표시하고 싶다면 더 표시 가능
public class GameController {
    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> selectGameListWithUserPk(@RequestParam int user_pk) {
        List<Game> resultGame = gameService.selectGame(user_pk);

        return resultGame;
    }

    @PostMapping
    public  int insertGameListWithUserPkAndGameInformation(@RequestBody Game game_data) {
        int insertResult = gameService.insertGameListWithUserPkAndGameInformation(game_data);

        return insertResult;
    }
}
