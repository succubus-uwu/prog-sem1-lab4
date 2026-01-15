package axl.itmo.item.food;

import axl.itmo.item.Item;

public interface Food extends Item {

    void rain();

    void sun();

    int getHealthImpact();
}