package evm.cooker.controllers.creational;

import evm.cli.Reader;

public abstract class MealFactory {
    protected String getName() {
        return Reader.getInstance().readString("Название:");
    }
}
