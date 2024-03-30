package evm.aircraft.controllers.creational;

public interface ICreate<Item> {
    Item create();
    Item createDefault();
}
