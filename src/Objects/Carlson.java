package Objects;

import Enums.Action;
import Enums.Mood;
import Exceptions.NoMorePorridgeException;
import Exceptions.StickyResidueException;

public class Carlson extends Person {
    public Carlson(String name, Mood mood) {
        super(name, mood);
    }

    @Override
    public void doAction(Action action) {
        switch (action) {
            case LAUGH:
                // если Карлсон мрачный выводим что ему не до смеха
                if (getMood() == Mood.GLOOMY) {
                    System.out.print("Но " + getName() + "у было не до смеха. ");
                } else {
                    System.out.print(getName() + " смеется. ");
                }
                break;
            case TAKE:
                System.out.print(getName() + " взял кастрюлю и ");
                break;
            case POUR:
                System.out.print("принялся накладывать кашу в тарелку. ");
                break;
            case SCRAPE:
                System.out.print("когда выскреб все до дна, ");
                break;
            case MOVE_FINGER:
                System.out.print("стал водить указательным пальцем по стенке кастрюли, ");
                break;
            case PEEL_OFF:
                System.out.print("отколупывая и то, что прилипло.");
                break;
            default:
                System.out.print(getName() + " совершает действие: " + action + ". ");
        }
    }

    public void takePorridgeFromPot(Pot pot) throws NoMorePorridgeException {
        if (pot.isEmpty()) {
            throw new NoMorePorridgeException("В кастрюле больше нет каши!");
        }
        pot.removeOnePortion();
    }

    public void scrapeResidue(Pot pot) {
        if (Math.random() < 0.1) {
            throw new StickyResidueException("Случилась неприятность при соскребании!");
        }
        pot.scrapeSides();
    }
}
