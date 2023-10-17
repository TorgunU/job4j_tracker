package ru.job4j.polymorph;

public interface Transport {
    void drive();

    void setPassengersNumber(int count);

    int refuel(int fuelQuantity);
}
