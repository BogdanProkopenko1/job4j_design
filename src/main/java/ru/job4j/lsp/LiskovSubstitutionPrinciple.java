package ru.job4j.lsp;

public class LiskovSubstitutionPrinciple {

    private static class Aircraft {

        double maxSpeed;
        double fuel;
        int passengers;
        double weight;
        String location;

        public Aircraft(double maxSpeed, double fuel, int passengers, double weight, String location) {
            this.maxSpeed = maxSpeed;
            this.fuel = fuel;
            this.passengers = passengers;
            this.weight = weight;
            this.location = location;
        }

        public String sendFlight(String target) {
            if (weight > 25 || fuel <= 10 || passengers > 500) {
                throw new IllegalArgumentException("Aircraft is not allowed to fly");
            }
            String rsl = location;
            this.location = target;
            return rsl + " -> " + target;
        }
    }

    private static class Airplane extends Aircraft {

        public Airplane(double maxSpeed, int fuel, int passengers, double weight, String location) {
            super(maxSpeed, fuel, passengers, weight, location);
        }

        @Override
        public String sendFlight(String target) {
            if (weight > 15 || fuel <= 30 || passengers > 300) {
                throw new IllegalArgumentException("Aircraft is not allowed to fly");
            }
            String rsl = location;
            this.location = target;
            return rsl + " -> " + target;
        }
    }

    private static class Boeing extends Airplane {

        public Boeing(double maxSpeed, int fuel, int passengers, double weight, String location) {
            super(maxSpeed, fuel, passengers, weight, location);
        }

        @Override
        public String sendFlight(String target) {
            if (weight > 10 || fuel <= 35 || passengers > 200) {
                throw new IllegalArgumentException("Aircraft is not allowed to fly");
            }
            String rsl = location;
            this.location = target;
            return rsl + " -> " + target;
        }
    }

    private static class Helicopter extends Aircraft {

        public Helicopter(double maxSpeed, int fuel, int passengers, double weight, String location) {
            super(maxSpeed, fuel, passengers, weight, location);
        }

        @Override
        public String sendFlight(String target) {
            if (weight > 30 || fuel <= 15 || passengers > 10) {
                throw new IllegalArgumentException("Aircraft is not allowed to fly");
            }
            String rsl = location;
            this.location = target;
            return rsl + " -> " + target;        }
    }

    public static void main(String[] args) throws InterruptedException {
        Aircraft aircraft = new Aircraft(1000, 50, 400, 20, "Saint-Petersburg");
        System.out.println(aircraft.sendFlight("Barcelona"));
        Thread.sleep(10000);
        aircraft = new Airplane(1000, 50, 200, 10, aircraft.location);
        System.out.println(aircraft.sendFlight("New-York"));
        Thread.sleep(10000);
        aircraft = new Boeing(1000, 50, 100, 6, aircraft.location);
        System.out.println(aircraft.sendFlight("Stockholm"));
        Thread.sleep(10000);
        aircraft = new Helicopter(1000, 20, 5, 14, aircraft.location);
        System.out.println(aircraft.sendFlight("Saint-Petersburg"));
    }
}