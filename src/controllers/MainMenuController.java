package src.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {

    public enum Command {
        QuestionDelivery,
        BestellungsHistorie,
        Warehouse,
        Bookkeeping,
        Logout,
    }


    private FrameManager frameManager;
    private Command processedCommand;


    public MainMenuController(FrameManager frameManager, Command command) {
        this.frameManager = frameManager;
        this.processedCommand = command;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.processedCommand) {
            case QuestionDelivery:
                frameManager.showQuestionDelivery();
                break;
            case BestellungsHistorie:
                frameManager.showBestellungsHistorie();
                break;
            case Warehouse:
                frameManager.showWarehouse();
                break;
            case Bookkeeping:
                frameManager.showBookkeeping();
                break;
            case Logout:
                frameManager.showLogin();
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }
    }
}
