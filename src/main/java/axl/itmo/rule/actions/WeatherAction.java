package axl.itmo.rule.actions;

import axl.itmo.GameMachine;
import axl.itmo.place.Place;
import axl.itmo.rule.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class WeatherAction implements Rule {

    @Override
    public boolean effect(@NotNull GameMachine game) {
        List<Place> places = game.getPlaces();

        for (Place place : places) {
            switch (game.getWeather()) {
                case SUNNY -> place.sun();
                case RAINY -> place.rain();
            }
        }

        return false;
    }
}
