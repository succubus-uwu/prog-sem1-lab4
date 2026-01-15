package axl.itmo.rule.ending;

public final class PurveyanceEnding extends Ending {

    public PurveyanceEnding() {
        super(game -> {
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
        });
    }
}
