package axl.itmo.place;

import axl.itmo.item.food.Vine;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record Vineyard(@NotNull List<Vine> vines) implements Place {

    @Override
    public void rain() {
        vines.forEach(Vine::rain);
        System.out.println("Дождь негативно влияет на изюм.");
    }

    @Override
    public void sun() {
        vines.forEach(Vine::sun);
        System.out.println("Солнце положительно влияет на изюм.");
    }
}
