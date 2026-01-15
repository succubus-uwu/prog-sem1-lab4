package axl.itmo.rule.ending;

import axl.itmo.GameMachine;
import axl.itmo.rule.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public abstract class Ending implements Rule {

    private final @NotNull Function<GameMachine, Boolean> condition;

    public Ending(@NotNull Function<GameMachine, Boolean> condition) {
        this.condition = condition;
    }

    @Override
    public boolean effect(@NotNull GameMachine game) {
        return condition.apply(game);
    }
}
