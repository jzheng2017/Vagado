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

    /**
     * Gets the controller based on the Controller Type
     * @param type
     * @return Controller
     */
    public Controller getController(ControllerType type) {
        for (Controller controller : controllers) {
            if (controller.getType().equals(type)) {
                return controller;
            }
        }
        return null;
    }

    /**
     * Gets an instance of ControllerManager
     * @return ControllerManager
     */
    public static ControllerManager getInstance() {
        if (controllerManager == null) {
            controllerManager = new ControllerManager();
        }
        return controllerManager;
    }

    /**
     * Gets all known controllers from the factory and adds it to the list
     */
    private void getAllControllers() {
        for (ControllerType type : ControllerType.values()) {
            Controller controller = ControllerFactory.getController(type);
            if (controller != null) {
                controllers.add(controller);
            }
        }
    }
}
