
package main;

import view.ViewBD;
import model.ModelBD;
import controller.ControllerBD;

public class Main {
    
    
    public static void main(String[] args) {
        ModelBD modelBD = new ModelBD();
        ViewBD viewBD = new ViewBD();
        ControllerBD controllerBD = new ControllerBD(modelBD, viewBD);
    }
}