package ru.job4j.ocp;

import ru.job4j.srp.PassGenerator;

import java.util.ArrayList;

public class Cars {

    //сылка на реализацию(объект), а не на абстракцию(интерфейс)
    private Koenigsegg koenigsegg;

    private static class Engine {

        //метод возвращает экземпляр класса
        public Defect getDefectNumber() {
            return new Defect(new PassGenerator().generateNumber(10));
        }

        //етод принимает обьект, а не интерфейс
        public Defect getDefect(PassGenerator pg) {
            return new Defect(pg.generateString(10));
        }
    }

    private static class Koenigsegg {

        public String getMark() {
            return "Regera";
        }
    }

    private static class Defect {

        private String defect;

        public Defect(String defect) {
            this.defect = defect;
        }
    }
}
