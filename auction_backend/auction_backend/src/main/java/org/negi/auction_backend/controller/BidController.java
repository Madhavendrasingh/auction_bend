package org.negi.auction_backend.controller;

import org.negi.auction_backend.model.Bid;
import org.negi.auction_backend.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bid")
public class BidController {

    @Autowired
    BidService bidService;

    @GetMapping("")
    public String isApiLive(){
        return "Bid api is Live!";
    }

    @GetMapping("/all")
    public List<Bid> getAll(){
        return this.bidService.getAllBids();
    }

    @GetMapping("/id")
    public Bid getById(@RequestParam Integer id){
        return this.bidService.getById(id);
    }

    @GetMapping("/auction")
    public List<Bid> getByAuction(@RequestParam Integer auction_id){
        return this.bidService.getAllByAuctionID(auction_id);
    }

    @GetMapping("/bidder")
    public List<Bid> getByBidder(@RequestParam Integer bidder_id){
        return this.bidService.getAllByBidder(bidder_id);
    }

    @PostMapping("/add")
    public Bid save(@RequestBody Bid bid){
        System.out.println(bid);
        System.out.println(bid.getBid_value()+", "+bid.getAuction_id()+", "+bid.getBidder());
        return this.bidService.save(bid.getBid_value(), bid.getAuction_id(), bid.getBidder());
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer id){
        return this.bidService.deleteById(id);
    }

}
