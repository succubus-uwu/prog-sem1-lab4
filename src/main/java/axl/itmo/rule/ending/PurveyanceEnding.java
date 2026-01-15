package axl.itmo.rule.ending;

import axl.itmo.GameMachine;
import org.jetbrains.annotations.NotNull;

public final class PurveyanceEnding extends Ending {

    @Override
    public boolean effect(@NotNull GameMachine game) {
        if (game.getPlayer().getPurveyance() >= 200) {
            System.out.println("Запасов еды на зиму хватает для проживания. Вы выжили!");
            System.out.println("Собрано " + game.getPlayer().getPurveyance() + " продовольствия.");
            return true;
        }

        if (game.getDate().isLast()) {
            System.out.println("К сожалению, вы не успели собрать запасы на зиму к сезону дождей и погибли.");
            System.out.println("Не хватило " + game.getPlayer().getPurveyance() + " продовольствия.");
            return true;
        }

        return false;
    }
}
