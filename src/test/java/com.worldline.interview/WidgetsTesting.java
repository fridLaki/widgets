package com.worldline.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WidgetsTesting {

    @Test
    void testNotSupportedWidgets() {
        WidgetMachine widgetMachine = new WidgetMachine();
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () -> {
            widgetMachine.getEngine().fill(FuelType.DIESEL, 1);
        }, "java.lang.IllegalStateException");

        assertEquals("Sorry, the fuel type isn't supported",thrown.getMessage());
    }

    @Test
    void tesNewWidgets() {
        WidgetMachine widgetMachine = new WidgetMachine();
        widgetMachine.getEngine().fill(FuelType.WOOD, 130);

        assertEquals(8.7, widgetMachine.produceWidgets(4));
    }
}
