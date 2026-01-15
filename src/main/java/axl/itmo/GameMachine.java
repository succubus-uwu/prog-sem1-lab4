package axl.itmo;

import axl.itmo.player.Player;
import axl.itmo.place.Place;
import axl.itmo.rule.Rule;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GameMachine {

    private final @NotNull Player player;

    private final @NotNull List<Place> places;

    private final @NotNull List<Rule> rules;

    private @NotNull Weather weather;

    private @NotNull GameDate date;

    public GameMachine(@NotNull Player player,  @NotNull List<Place> places, @NotNull List<Rule> rules) {
        this.player = player;

        if (places.isEmpty()) {
            throw new IllegalArgumentException("нет мест для посещения.");
        }
        this.places = places;

        if (rules.isEmpty()) {
            throw new IllegalArgumentException("нет игровых правил.");
        }
        this.rules = rules;
        date = new GameDate(1);
        weather = Weather.CLOUDY;
    }

    public @NotNull Player getPlayer() {
        return player;
    }

    public @NotNull List<Place> getPlaces() {
        return places;
    }

    public @NotNull GameDate getDate() {
        return date;
    }

    public @NotNull Weather getWeather() {
        return weather;
    }

    public boolean processDay() {
        System.out.println(weather + " погода.");
        System.out.println(date + " день. ");

        for (Place place : places) {
            switch (weather) {
                case SUNNY -> place.sun();
                case RAINY -> place.rain();
            }
        }

        for (Rule rule : rules) {
            if (rule.effect(this))
                return false;
        }

        date = new GameDate(date.day() + 1);
        weather = weather.getNextWeather();
        return true;
    }
}
