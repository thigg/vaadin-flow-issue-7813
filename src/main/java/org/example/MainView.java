package org.example;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.material.Material;

/**
 * The main view contains a button and a click listener.
 */
@Route
@Theme(value = Material.class)
@CssImport("./styles/shared-styles.css")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends AppLayout {

    public MainView() {
        Div fl = new Div();
        fl.add(new Text("Change the view twice and you shall observe the error."));
        BuggyView fl2 = new BuggyView();

        addToNavbar(new DrawerToggle());
        final Tab workingTab = new Tab("working");
        final Tab buggyTab = new Tab("buggy");
        Tabs tabs = new Tabs(buggyTab, workingTab);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
        setContent(workingTab);
        tabs.addSelectedChangeListener(event -> {
            setContent(
                    event.getSelectedTab() == buggyTab ? fl : fl2
            );
            afterNavigation();
        });
    }
}
