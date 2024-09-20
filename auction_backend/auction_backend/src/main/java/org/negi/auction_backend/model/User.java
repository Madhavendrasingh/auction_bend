package org.negi.auction_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USERTABLE")
public class User {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name")
    private String name;


    @Column(name = "auction_bids")
    @JsonIgnore
    private List<Integer> auction_bids;

    @Column(name = "auctions_owned")
    private List<Integer> auctions_owned;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(){}


    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getAuction_bids() {
        return auction_bids;
    }

    public void setAuction_bids(List<Integer> auction_bids) {
        this.auction_bids = auction_bids;
    }

    public List<Integer> getAuctions_owned() {
        return auctions_owned;
    }

    public void setAuctions_owned(List<Integer> auctions_owned) {
        this.auctions_owned = auctions_owned;
    }
}
