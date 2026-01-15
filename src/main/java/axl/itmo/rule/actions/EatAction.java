package axl.itmo.rule.actions;

import axl.itmo.GameMachine;
import axl.itmo.Weather;
import axl.itmo.item.food.Food;
import axl.itmo.item.food.Vine;
import axl.itmo.place.Place;
import axl.itmo.place.Vineyard;
import axl.itmo.player.Player;
import axl.itmo.rule.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public final class EatAction implements Rule {

    @Override
    public boolean effect(@NotNull GameMachine game) {
        Player player = game.getPlayer();

        @SuppressWarnings("unchecked")
        List<Food> foods = (List<Food>) (List<?>) player.getItems().stream()
                .filter(item -> item instanceof Food)
                .sorted(Comparator.comparingInt(o -> ((Food) o).getHealthImpact()))
                .toList();
        if (foods.isEmpty()) {
            return false;
        }

        Food food = foods.get(foods.size() - 1);
        player.setHealth(player.getHealth() + food.getHealthImpact());
        player.getItems().remove(food);

        return false;
    }
}
