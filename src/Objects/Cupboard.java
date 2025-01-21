package Objects;

import java.util.ArrayList;
import java.util.List;

public class Cupboard extends Obj {
    private List<Plate> plates = new ArrayList<>();

    public Cupboard(String name) {
        super(name);
    }

    @Override
    public void printInfo() {
        // Не выводим лишнего
    }

    public void storePlate(Plate plate) {
        plates.add(plate);
    }

    public Plate takePlate() {
        if (!plates.isEmpty()) {
            return plates.remove(0);
        }
        return null;
    }
}
