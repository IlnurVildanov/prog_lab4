import Enums.Action;
import Enums.Mood;
import Enums.Place;
import Exceptions.NoMorePorridgeException;
import Exceptions.StickyResidueException;
import Objects.*;

public class Main {
    public static void main(String[] args) {
        Carlson carlson = new Carlson("Карлсон", Mood.GLOOMY);
        Kid malysh = new Kid("Малыш", Mood.NEUTRAL);

        Cupboard cupboard = new Cupboard("Буфет");
        Plate plate = new Plate("Тарелка");
        cupboard.storePlate(plate);

        Pot pot = new Pot("Кастрюля");
        // Положим немного каши
        pot.addPorridge(new Porridge("Каша#1"));
        pot.addPorridge(new Porridge("Каша#2"));
        pot.addPorridge(new Porridge("Каша#3"));

        // ===== Формируем ПЕРВУЮ строку вывода =====
        // "Но Карлсону было не до смеха."
        // Для имитации: вызываем doAction(Action.LAUGH), но он мрачный.
        carlson.doAction(Action.LAUGH);
        System.out.println(); // завершение первой строки

        // ===== ВТОРАЯ строка =====
        // "Малыш вскочил, вынул из буфета тарелку и сказал Карлсону, чтобы он сам положил себе сколько хочет."
        malysh.doAction(Action.JUMP);   // "Малыш вскочил, "
        malysh.doAction(Action.TAKE);   // "вынул из буфета тарелку и "
        malysh.doAction(Action.TELL);   // "сказал Карлсону, чтобы..."
        System.out.println(); // конец второй строки

        // ===== ТРЕТЬЯ строка =====
        // "Все еще мрачный как туча, Карлсон взял кастрюлю и принялся накладывать кашу в тарелку."
        System.out.print("Все еще мрачный как туча, ");
        carlson.doAction(Action.TAKE);  // "Карлсон взял кастрюлю и "
        carlson.doAction(Action.POUR);  // "принялся накладывать кашу..."
        System.out.println(); // конец третьей строки

        // Положим (попробуем несколько раз) кашу в тарелку
        for (int i = 0; i < 4; i++) {
            try {
                carlson.takePorridgeFromPot(pot);
                plate.addPorridge(new Porridge("Каша#" + i));
            } catch (NoMorePorridgeException e) {
                // Если закончилась каша - просто не добавляем
                // Но не выводим ничего лишнего, чтобы текст совпадал
                break;
            }
        }

        // ===== ЧЕТВЕРТАЯ строка =====
        // "Он накладывал и накладывал, а когда выскреб все до дна,
        //  стал водить указательным пальцем по стенке кастрюли, отколупывая и то, что прилипло."
        System.out.print("Он накладывал и накладывал, ");
        carlson.doAction(Action.SCRAPE);     // "когда выскреб все до дна, "
        carlson.doAction(Action.MOVE_FINGER);// "стал водить указательным пальцем по стенке кастрюли, "
        carlson.doAction(Action.PEEL_OFF);   // "отколупывая и то, что прилипло."

        // Проверим в конце — вдруг бросим StickyResidueException
        try {
            carlson.scrapeResidue(pot);
        } catch (StickyResidueException e) {
            // Не выводим ничего «лишнего» — по условию текста не нужно
            // но мы обязаны перехватить (демонстрация обработки unchecked)
        }
        System.out.println(); // конец четвертой строки
    }
}
