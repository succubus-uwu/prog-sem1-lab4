package axl.itmo.rule.ending;

import axl.itmo.GameMachine;
import axl.itmo.rule.Rule;
import org.jetbrains.annotations.NotNull;

public abstract class Ending implements Rule {

    @Override
    public abstract boolean effect(@NotNull GameMachine game);
}
