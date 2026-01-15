package axl.itmo;

import axl.itmo.item.food.Vine;
import axl.itmo.place.Vineyard;
import axl.itmo.player.Player;
import axl.itmo.rule.actions.CollectVineAction;
import axl.itmo.rule.actions.EatAction;
import axl.itmo.rule.ending.HealthEnding;
import axl.itmo.rule.ending.PurveyanceEnding;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            GameMachine game = new GameMachine(
                    new Player(new ArrayList<>(), 3),
                    new ArrayList<>() {{
                        Vineyard vineyard = new Vineyard(new ArrayList<>() {{
                            final int count = (int) ((Math.random() + 0.5) * 400);
                            for (int i = 0; i < count; i++) {
                                add(new Vine(Vine.GrapeType.GRAPE));
                            }
                        }});
                        add(vineyard);
                    }},
                    new ArrayList<>() {{
                        add(new EatAction());

                        add(new HealthEnding());
                        add(new PurveyanceEnding());

                        add(new CollectVineAction());
                    }}
            );

            //noinspection StatementWithEmptyBody
            while (game.processDay());
        } catch (IllegalGameInitialization illegalGameInitialization) {
            System.err.println(illegalGameInitialization.getMessage());
        }
    }
}