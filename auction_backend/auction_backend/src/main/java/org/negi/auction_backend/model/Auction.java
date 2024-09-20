package org.negi.auction_backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "item_name", nullable = false)
    private String item_name;

    @Column(name = "base_price", nullable = false)
    private float base_price;

    @Column(name = "owner_id", nullable = false)
    private Integer owner_id;

    @Column(name = "top_bid")
    private Integer top_bid;

    @Column(name = "all_bids")
    private List<Integer> all_bids;

    public Auction() {
    }

    public Integer getId() {
        return id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public float getBase_price() {
        return base_price;
    }

    public void setBase_price(float base_price) {
        this.base_price = base_price;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public Integer getTop_bid() {
        return top_bid;
    }

    public void setTop_bid(Integer top_bid) {
        this.top_bid = top_bid;
    }

    public List<Integer> getAll_bids() {
        return all_bids;
    }

    public void setAll_bids(List<Integer> all_bids) {
        this.all_bids = all_bids;
    }
}
