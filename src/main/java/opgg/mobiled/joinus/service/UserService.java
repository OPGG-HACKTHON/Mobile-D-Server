package opgg.mobiled.joinus.service;

import opgg.mobiled.joinus.dto.Manner;

public interface UserService {
    String selectFirebaseTokenWithTargetToken(String target_token);
}
