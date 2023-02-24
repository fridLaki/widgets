package com.worldline.interview;

public class Widgets {
    public static void main(String[] args) {

        try {
            WidgetMachine widgetMachine = new WidgetMachine();
            widgetMachine.getEngine().fill(FuelType.DIESEL, 130);
            System.out.println(widgetMachine.produceWidgets(4));
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
