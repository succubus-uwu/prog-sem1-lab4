package axl.itmo.player;

import axl.itmo.item.Item;
import axl.itmo.item.food.Food;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class Player {

    private final @NotNull List<Item> items;

    private int health;

    public Player(@NotNull List<Item> items, int health) {
        this.items = items;
        this.health = health;
    }

    public @NotNull List<Item> getItems() {
        return items;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }

        if (health > 5) {
            health = 5;
        }

        this.health = health;
    }

    public int getPurveyance() {
        return items.stream()
                .mapToInt(o -> o instanceof Food food ? food.getHealthImpact() : 0)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return health == player.health && Objects.equals(items, player.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return "Персонаж";
    }
}
