// package com.example.demo.entities;

// import java.security.Identity;

// import javax.persistence.*;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Route {

//     public Route(Object object, String string, String string2, User savedUser) {
        
//     }

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String routeName;
    

//     @Column(nullable = false)
//     private String path;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "user_id", nullable = false)
//     @JsonIgnore
//     private User user;
// }
package com.example.demo.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {

   public Route(Object object, String routeName, String path, User user) {
        this.routeName = routeName;
        this.path = path;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String routeName;

    @Column(nullable = false)
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
}


