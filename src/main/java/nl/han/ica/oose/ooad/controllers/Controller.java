package nl.han.ica.oose.ooad.controllers;

import nl.han.ica.oose.ooad.enums.ControllerType;

public abstract class Controller {
    private ControllerType type;

    /**
     * Checks whether the current user is authorized to perform the action
     * @return boolean
     */
    protected abstract boolean authorized();

    /**
     * Get type of the controller
     * @return ControllerType
     */
    public ControllerType getType() {
        return type;
    }

    /**
     * Sets the controller type
     * @param type
     */
    public void setType(ControllerType type) {
        this.type = type;
    }
}
