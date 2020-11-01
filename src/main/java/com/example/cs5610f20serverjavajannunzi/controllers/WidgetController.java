package com.example.cs5610f20serverjavajannunzi.controllers;

import com.example.cs5610f20serverjavajannunzi.models.Widget;
import com.example.cs5610f20serverjavajannunzi.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    WidgetService service = new WidgetService();

    /*
        + sayHello()
        Point the browser to -- localhost:8080/hello
        @GetMapping("/hello") --
            @GetMapping listens to 'GET' http requests
            ("/hello") -- to executes the the function sayHello and
            maps all the results of the function to localhost:8080/hello
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!!";
    }

    /*
        + findWidgetsForTopic()
     */
    @GetMapping("/api/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("topicId") String topicId) { // Parse 'topicId' then pass it as into 'String topicId'
        System.out.println("findwidgetsForTopic reached, topicID is : " + topicId);
        return service.findWidgetsForTopic(topicId); // now we use use the instantiated var 'topicId' to pass to 'findWidgetsForTopic(topicId')
    }


    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable("wid") String widgetId) {
        return service.findWidgetById(widgetId);
    }

    @PostMapping("/api/widgets")
    public Widget createWidget(@RequestBody Widget widget) {
        return service.createWidget(widget);
    }

    @PutMapping("/api/widgets/{wid}")
    public Integer updateWidget(
            @PathVariable("wid") String widgetId,
            @RequestBody Widget newWidget) {
        return service.updateWidget(widgetId, newWidget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public Integer deleteWidget( @PathVariable("wid") String widgetId) {
        return service.deleteWidget(widgetId);
    }



}
