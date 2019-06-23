/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.view;

import hotel.controller.Controller;
import java.util.Scanner;

/**
 *
 * @author Filipe
 */
public class LoginUI
{
    private Controller controller;
    private Scanner scanner;
    public LoginUI()
    {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }
    public void menu()
    {
        
    }

    /**
     * @return the controller
     */
    public Controller getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * @return the scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * @param scanner the scanner to set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
}
