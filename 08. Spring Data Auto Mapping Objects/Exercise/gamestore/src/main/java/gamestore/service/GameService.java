package gamestore.service;

import gamestore.domain.dtos.GameAddDto;

public interface GameService {

    String addGame(GameAddDto gameAddDto);

}
