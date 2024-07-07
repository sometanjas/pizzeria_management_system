package src.controllers;

import src.storage.transactions.TransactionRecord;
import src.storage.transactions.TransactionsDaoDbImpl;
import src.views.BookkeepingPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookkeepingController implements ActionListener {

    private BookkeepingPanel bookkeepingPanel;

    public BookkeepingController(BookkeepingPanel bookkeepingPanel) {
        this.bookkeepingPanel = bookkeepingPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int moneyToDeposit = Integer.parseInt(bookkeepingPanel.getMoneyInput().getText());
        TransactionRecord transactionRecord = new TransactionRecord(moneyToDeposit, null, null);
        TransactionsDaoDbImpl.getInstance().addTransaction(transactionRecord);
        bookkeepingPanel.refreshData();
    }
}
