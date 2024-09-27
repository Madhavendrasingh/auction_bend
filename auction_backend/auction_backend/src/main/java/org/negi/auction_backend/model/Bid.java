package org.negi.auction_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private Integer auction_id;
    @Column
    private Integer bidder;
    @Column
    private float bid_value;

    public Bid(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(Integer auction_id) {
        this.auction_id = auction_id;
    }

    public Integer getBidder() {
        return bidder;
    }

    public void setBidder(Integer bidder) {
        this.bidder = bidder;
    }

    public float getBid_value() {
        return bid_value;
    }

    public void setBid_value(float bid_value) {
        this.bid_value = bid_value;
    }
}
