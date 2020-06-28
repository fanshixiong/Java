package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMonitor implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        actionEvent.getActionCommand();
    }
}
