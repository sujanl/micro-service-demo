package com.sujan.gallaryservice.rest;

import com.sujan.gallaryservice.data.Gallary;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/")
public class HomeController {

    private RestTemplate restTemplate;

    private Environment environment;

    public HomeController(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    @GetMapping("/")
    public String home(){
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from Gallery Service running at port: " + environment.getProperty("local.server.port");
    }

    // This method should only be accessed by users with role of 'admin'
    // We'll add the logic of role based auth later
    @RequestMapping("/admin")
    public String adminHome(){
        // This is also useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "This is the admin area of Gallery service running at port: " + environment.getProperty("local.server.port");
    }

    @RequestMapping("/{id}")
    public Gallary getGallary(@PathVariable int id){
        Gallary gallary = new Gallary();
        gallary.setId(id);

        // get list of available images from the image-service
        List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
        gallary.setImages(images);

        return gallary;
    }
}
