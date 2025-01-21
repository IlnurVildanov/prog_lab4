package Objects;

import Enums.Place;
import Interfaces.IPlace;
import java.util.ArrayList;
import java.util.List;

public class Plate extends Obj implements IPlace {
    private List<Porridge> contents = new ArrayList<>();
    private Place place = Place.NONE;

    public Plate(String name) {
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
        return place;
    }

    public void addPorridge(Porridge p) {
        contents.add(p);
    }

    public int getPorridgeCount() {
        return contents.size();
    }
}
