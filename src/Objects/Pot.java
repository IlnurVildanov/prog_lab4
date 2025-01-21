package Objects;

import Enums.Place;
import Interfaces.IPlace;
import java.util.ArrayList;
import java.util.List;

public class Pot extends Obj implements IPlace {
    private List<Porridge> contents = new ArrayList<>();
    private Place place = Place.NONE;

    public Pot(String name) {
        super(name);
    }

    @Override
    public void printInfo() {
    }

    @Override
    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public Place getPlace() {
        return this.place;
    }

    public void addPorridge(Porridge p) {
        contents.add(p);
    }

    public boolean isEmpty() {
        return contents.isEmpty();
    }

    public void removeOnePortion() {
        if (!contents.isEmpty()) {
            contents.remove(contents.size() - 1);
        }
    }

    public void scrapeSides() {
        // Например, убираем остатки
        contents.clear(); // после соскребания всё уходит
    }
}
