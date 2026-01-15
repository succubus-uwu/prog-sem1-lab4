package axl.itmo.rule.ending;

import axl.itmo.GameMachine;
import org.jetbrains.annotations.NotNull;

public final class HealthEnding extends Ending {

    @Override
    public boolean effect(@NotNull GameMachine game) {
        if (game.getPlayer().getHealth() < 0) {
            System.out.print("К сожалению, вы умерли от изнеможения.");
            return true;
        }

        return false;
    }
}
