package axl.itmo.rule.ending;

public final class HealthEnding extends Ending {

    public HealthEnding() {
        super(game -> {
            if (game.getPlayer().getHealth() < 0) {
                System.out.print("К сожалению, вы умерли от изнеможения.");
                return true;
            }

            return false;
        });
    }
}
