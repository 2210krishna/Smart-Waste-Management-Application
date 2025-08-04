 package com.example.demo.Controller;

import com.example.demo.entities.Route;
import com.example.demo.entities.User;
import com.example.demo.Service.RouteService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private UserService userService;

    // Create a new route
    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        return routeService.saveRoute(route);
    }

    // Get all routes
    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    // Get a route by ID
    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));
    }

    // Update a route
    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable Long id, @RequestBody Route routeDetails) {
        Route existingRoute = routeService.getRouteById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));

        existingRoute.setRouteName(routeDetails.getRouteName());
        existingRoute.setPath(routeDetails.getPath());

        User user = userService.getUserById(routeDetails.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + routeDetails.getUser().getId()));
        existingRoute.setUser(user);

        return routeService.saveRoute(existingRoute);
    }

    // Delete a route
    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Long id) {
        if (!routeService.getRouteById(id).isPresent()) {
            throw new RuntimeException("Route not found with id: " + id);
        }
        routeService.deleteRouteById(id);
    }
}
