package com.example.cs5610f20serverjavajannunzi.services;

import com.example.cs5610f20serverjavajannunzi.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// + WidgetService Class -- the functions within this class provides access to the database.
// Currently we have the 'database' hard coded as a List of Widgets called 'widget'.
// The hardcoded list will be replaced later on with MySQL.
public class WidgetService {

    //  + wigets[] -- a hardcoded array that we'll use temporarily to simulate a database
    // this will be replaced later on. NOTE:: topicId is now passed.
    List<Widget> widgets = new ArrayList<Widget>();
    {
        widgets.add(new Widget("123", "Widget 123", "HEADING", "topic123"));
        widgets.add(new Widget("234", "Widget 234", "PARAGRAPH", "topic123"));
        widgets.add(new Widget("345", "Widget 345", "HEADING", "topic234"));
        widgets.add(new Widget( "456", "PIZZA MANUAL WIDGET 456", "PARAGRAPH","5f8de90e7c74f50017f7ce2f"));
    }


    /*
        + findWidgetsForTopic
     */
    public List<Widget> findWidgetsForTopic(String tid) {
        List<Widget> ws = new ArrayList<Widget>(); // creates an new Arraylist to add widgets that have the give 'topicId/tid'
        for(Widget w: widgets) { // iterate through the widgets in the hardcoded 'database'
            if(w.getTopicId().equals(tid)) { // if the iterated element is equal to the given 'tid'
                ws.add(w); // add it to the Arraylist so we can return it to the client
            }
        }
        return ws;
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }


    public Widget findWidgetById(String widgetId) {
        for(Widget w: widgets) {
            if(w.getId().equals(widgetId))
                return w;
        }
        return null;
    }

    public Widget createWidget(Widget widget) {
        widget.setId((new Date()).toString());
        widgets.add(widget);
        return widget;
    }

    public Integer updateWidget(
            String widgetId,
            Widget newWidget) {
        for(Widget w: widgets) {
            if(w.getId().equals(widgetId)) {
                w.setName(newWidget.getName());
                w.setType(newWidget.getType());
                return 1;
            }
        }
        return 0;
    }
}
