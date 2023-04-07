package com.insper.partida.aposta;

import com.insper.partida.game.Game;
import com.insper.partida.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService {

    @Autowired
    private BetRespository betRespository;

    @Autowired
    private GameService gameService;

    public Bet saveBet(Bet bet) {
        return betRespository.save(bet);
    }

    public List<Bet> listBets() {
        return betRespository.findAll();
    }

    public Bet verifyBet(Integer betId) {
        Bet bet = betRespository.findById(betId).orElse(null);
        if (bet == null) {
            throw new RuntimeException("Bet not found");
        }
        return bet;
    }
}
