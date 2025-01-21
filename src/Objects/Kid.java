package Objects;

import Enums.Action;
import Enums.Mood;

public class Kid extends Person {

    public Kid(String name, Mood mood) {
        super(name, mood);
    }

    @Override
    public void doAction(Action action) {
        switch (action) {
            case JUMP:
                System.out.print(getName() + " вскочил, ");
                break;
            case TAKE:
                System.out.print("вынул из буфета тарелку и ");
                break;
            case TELL:
                System.out.print("сказал Карлсону, чтобы он сам положил себе сколько хочет. ");
                break;
            default:
                System.out.print(getName() + " совершает действие: " + action + ". ");
        }
    }
}
