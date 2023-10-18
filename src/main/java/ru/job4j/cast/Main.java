package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
         Bus bus = new Bus();
         Airplane airplane = new Airplane();
         Train train = new Train();

         Vehicle[] vehicles =
                 {
                         bus,
                         airplane,
                         train
                 };

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
