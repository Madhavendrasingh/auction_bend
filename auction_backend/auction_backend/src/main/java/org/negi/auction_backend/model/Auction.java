package org.negi.auction_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.negi.auction_backend.constants.Auction.Status;

@Entity
@Table(name = "Auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "item_name", nullable = false)
    private String item_name;

    @Column(name = "item_info")
    private String item_info;

    @Column(name = "image")
    @Lob
    @JsonIgnore
    private byte[] image;
    @Column(name = "base_price", nullable = false)
    private float base_price;

    @Column(name = "owner_id", nullable = false)
    private Integer owner_id;

    @Column(name = "top_bid")
    private float top_bid;

    @Column(name = "top_bidder")
    private Integer top_bidder;

    @Column(name = "auction_status")
    @Enumerated(EnumType.ORDINAL)
    private Status auction_status;

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

    public Float getTop_bid() {
        return top_bid;
    }

    public void setTop_bid(Float top_bid) {
        this.top_bid = top_bid;
    }

    public void setTop_bidder(Integer top_bidder) {
        this.top_bidder = top_bidder;
    }

    public Integer getTop_bidder() {
        return top_bidder;
    }

    public String getItem_info() {
        return item_info;
    }

    public void setItem_info(String item_info) {
        this.item_info = item_info;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Status getAuction_status() {
        return auction_status;
    }

    public void setAuction_status(Status auction_status) {
        this.auction_status = auction_status;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }
}
