package org.example;

import java.util.stream.IntStream;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.data.renderer.IconRenderer;

public class BuggyView extends Grid<DataClass> {

    private static final Image EMPTY_IMAGE = new Image();

    public BuggyView() {
        addColumn((new IconRenderer<>((group) -> EMPTY_IMAGE)));
        setItems(IntStream.range(0, 100).mapToObj(i -> new DataClass()));
    }
}
