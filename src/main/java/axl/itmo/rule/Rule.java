package axl.itmo.rule;

import axl.itmo.GameMachine;
import org.jetbrains.annotations.NotNull;

public interface Rule {

    /**
     * @param game current gaming machine
     * @return true - if the game is over
     */
    boolean effect(@NotNull GameMachine game);
}
