package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class WasteBin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int fillLevel;

    @Column(nullable = false)
    private boolean malfunctioning;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    public WasteBin() {}

    public WasteBin(String location, int fillLevel, boolean malfunctioning, User user) {
        this.location = location;
        this.fillLevel = fillLevel;
        this.malfunctioning = malfunctioning;
        this.user = user;
    }
    // null, "Location A", 50, false, savedUser
    public WasteBin(Long id, String location, int fillLevel, boolean malfunctioning, User user) {
        this.id = id;
        this.location = location;
        this.fillLevel = fillLevel;
        this.malfunctioning = malfunctioning;
        this.user = user;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getFillLevel() { return fillLevel; }
    public void setFillLevel(int fillLevel) { this.fillLevel = fillLevel; }

    public boolean isMalfunctioning() { return malfunctioning; }
    public void setMalfunctioning(boolean malfunctioning) { this.malfunctioning = malfunctioning; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

}
