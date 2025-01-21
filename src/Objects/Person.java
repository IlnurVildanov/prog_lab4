package Objects;

import Enums.Mood;
import Interfaces.IPlace;
import Interfaces.IProperty;
import Enums.Place;
import Enums.Action;

public abstract class Person extends Obj implements IPlace, IProperty {
    protected Mood mood;
    protected String propertyDescription = "";
    protected Place currentPlace = Place.NONE;

    public Person(String name, Mood mood) {
        super(name);
        this.mood = mood;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    @Override
    public void setProperty(String property) {
        this.propertyDescription = property;
    }

    @Override
    public String getProperty() {
        return propertyDescription;
    }

    @Override
    public void setPlace(Place place) {
        this.currentPlace = place;
    }

    @Override
    public Place getPlace() {
        return currentPlace;
    }

    // Просто для примера, чтобы персонаж мог "говорить"
    public void say(String text) {
        System.out.println(getName() + " говорит: \"" + text + "\"");
    }

    // Абстрактный метод: каждый конкретный персонаж будет по-своему делать действия
    public abstract void doAction(Action action);

    @Override
    public void printInfo() {
        System.out.println("Person " + name + ", mood=" + mood + ", property=" + propertyDescription);
    }
}
