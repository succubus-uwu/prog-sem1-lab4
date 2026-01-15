package axl.itmo.rule.actions;

import axl.itmo.GameMachine;
import axl.itmo.Weather;
import axl.itmo.item.food.Vine;
import axl.itmo.place.Place;
import axl.itmo.place.Vineyard;
import axl.itmo.player.Player;
import axl.itmo.rule.Rule;
import org.jetbrains.annotations.NotNull;

public final class CollectVineAction implements Rule {

    @Override
    public boolean effect(@NotNull GameMachine game) {
        Player player = game.getPlayer();

        if (game.getDate().day() < 3) {
            return false;
        }

        Vineyard vineyard = findVineyard(game);
        if (vineyard == null) {
            return false;
        }

        if (vineyard.vines().isEmpty()) {
            return false;
        }

        if (game.getWeather() == Weather.RAINY) {
            return false;
        }

        player.setHealth((int) (player.getHealth() - (Math.random() * 2 + 1)));

        while (!vineyard.vines().isEmpty() && Math.random() < 0.96) {
            Vine vine = vineyard.vines().remove(0);
            vine.pick();
            player.getItems().add(vine);
        }

        return false;
    }

    private Vineyard findVineyard(@NotNull GameMachine game) {
        for (Place place : game.getPlaces()) {
            if (place instanceof Vineyard) {
                return (Vineyard) place;
            }
        }

        return null;
    }
}
