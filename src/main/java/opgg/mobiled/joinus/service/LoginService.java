package opgg.mobiled.joinus.service;

import opgg.mobiled.joinus.dto.User;

public interface LoginService {
    public User OAuthCheck(String token);
    public User acccessCheck(String token);
}
