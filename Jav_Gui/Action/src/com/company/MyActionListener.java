package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        TextField field = (TextField)actionEvent.getSource();
        System.out.println(field.getText());
    }
}
