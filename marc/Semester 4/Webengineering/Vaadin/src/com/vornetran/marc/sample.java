package com.vornetran.marc;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

/**
 * Created by Marc on 18/06/2015.
 */
public class sample extends UI {
    @Override
    public void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.addComponent(new Label("Hello, world!"));
    }
}
