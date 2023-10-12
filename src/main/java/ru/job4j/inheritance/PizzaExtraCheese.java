package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private final String cheeseName = "extra cheese";

    @Override
    public String name() {
        return super.name() + " + " + cheeseName;
    }
}
