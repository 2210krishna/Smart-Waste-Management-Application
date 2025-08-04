// package com.example.demo.repositories;

// import com.example.demo.entities.Route;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface RouteRepository extends JpaRepository<Route, Long> {
    
// }
package com.example.demo.repositories;

import com.example.demo.entities.Route;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    // Find routes by associated user
    List<Route> findByUser(User user);

    // Find route by route name
    Optional<Route> findByRouteName(String routeName);

    // Find all routes by a specific user ID
    List<Route> findAllByUserId(Long userId);
}
