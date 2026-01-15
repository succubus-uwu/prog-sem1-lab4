package axl.itmo.item.food;

import axl.itmo.item.Pickable;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Vine implements Food, Pickable {

    private final long id = System.nanoTime();

    private boolean isOnVine;

    private @NotNull GrapeType type;

    public Vine(@NotNull GrapeType type) {
        this.isOnVine = true;
        this.type = type;
    }

    public boolean isOnVine() { return isOnVine; }

    public void pick() {
        System.out.println(this + " собран.");
        isOnVine = false;
    }

    @Override
    public void rain() {
        if (isOnVine() && type != GrapeType.GRAPE && Math.random() > 0.75) {
            type = GrapeType.RAISIN;
        }
    }

    @Override
    public void sun() {
        if (isOnVine() && Math.random() > 0.75) {
            switch (type) {
                case GRAPE -> type = GrapeType.RAISIN;
                case RAISIN -> type = GrapeType.EXCELLENT_RAISIN;
            }
        }
    }

    @Override
    public int getHealthImpact() {
        return type.getHealthImpact();
    }

    public enum GrapeType {
        GRAPE("Виноград", 1),
        RAISIN("Изюм", 2),
        EXCELLENT_RAISIN("Превосходный изюм", 3);

        private final String name;

        private final int healthImpact;

        GrapeType(@NotNull String name, int healthImpact) {
            this.name = name;
            this.healthImpact = healthImpact;
        }

        public String getName() {
            return name;
        }

        public int getHealthImpact() {
            return healthImpact;
        }
    }

    @Override
    public @NotNull String toString() {
        return type.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vine vine = (Vine) o;
        return isOnVine == vine.isOnVine && type == vine.type;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}