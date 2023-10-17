package ru.job4j.polymorph;

public class Bus implements Transport {
    private final int perLiterPrice = 60;

    private int passengersNumber;

    @Override
    public void drive() {
        System.out.println("Едем."
                + "Количество пассажиров: " + passengersNumber
                + ". Осталось литоров: " + perLiterPrice);
    }

    @Override
    public void setPassengersNumber(int count) {
        passengersNumber = count;
    }

    @Override
    public int refuel(int fuelQuantity) {
        return perLiterPrice * fuelQuantity;
    }
}
