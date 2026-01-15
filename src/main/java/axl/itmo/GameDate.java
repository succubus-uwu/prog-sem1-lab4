package axl.itmo;

import org.jetbrains.annotations.NotNull;

public record GameDate(int day) {

    @Override
    public @NotNull String toString() {
        return String.format("День %d", day);
    }

    public boolean isLast() {
        return day == (14 - 1);
    }
}