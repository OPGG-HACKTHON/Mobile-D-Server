package opgg.mobiled.joinus.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public List<Game> selectGameListWithUserPk(@Parameter(description = "유저 pk 값", required = true, example = "4") @RequestParam int user_pk) {
        List<Game> resultGame = gameService.selectGame(user_pk);

        return resultGame;
    }

    @PostMapping
    public int insertGameListWithUserPkAndGameInformation(@Parameter(description = "게임에 대한 정보를 넘겨주면 됩니다. pk값은 안넘겨주셔도 괜찮습니다", required = true) @RequestBody Game game_data) {
        int insertResult = gameService.insertGameListWithUserPkAndGameInformation(game_data);

        return insertResult;
    }

    @PutMapping
    public int updateGameDataWithGameData(@Parameter(description = "게임에 대한 정보를 넘겨주면 됩니다. pk값은 안넘겨주셔도 괜찮습니다", required = true) @RequestBody Game game_data) {
        int updateResult = gameService.updateGameDataWithGameData(game_data);

        return updateResult;
    }

    @DeleteMapping
    public int deleteGameDataWithGamePk(@Parameter(description = "삭제할 게임 pk값을 주시면 됩니다.", required = true) @RequestParam int game_pk) {
        int deleteResult = gameService.deleteGameDataWithGamePk(game_pk);

        return deleteResult;
    }
}
