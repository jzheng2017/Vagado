package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;
import nl.han.ica.oose.ooad.factories.ControllerFactory;

import java.util.ArrayList;
import java.util.List;

public class ControllerManager {
    private static ControllerManager controllerManager;

    private List<Controller> controllers = new ArrayList<>();

    private ControllerManager() {
        getAllControllers();
    }

    public Controller getController(ControllerType type) {
        for (Controller controller : controllers) {
            if (controller.getType().equals(type)) {
                return controller;
            }
        }
        return null;
    }

    public static ControllerManager getInstance() {
        if (controllerManager == null) {
            controllerManager = new ControllerManager();
        }
        return controllerManager;
    }

    private void getAllControllers() {
        for (ControllerType type : ControllerType.values()) {
            Controller controller = ControllerFactory.getController(type);
            if (controller != null) {
                controllers.add(controller);
            }
        }
    }
}
