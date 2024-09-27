package org.negi.auction_backend.controller;

import org.negi.auction_backend.model.Auction;
import org.negi.auction_backend.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    @GetMapping("")
    public String baseAPI(){
        return "Auction API is live!";
    }

    @GetMapping("/all")
    public List<Auction> getAuctions(){
        return this.auctionService.getAllAuctions();
    }

    @GetMapping("/id")
    public Auction getAuction(@RequestParam Integer id){
        return this.auctionService.getAuctionById(id);
    }

    @PostMapping("/add")
    public Auction save(@RequestBody Auction auction){
        return this.auctionService.save(auction.getOwner_id(),auction.getBase_price(),auction.getItem_name());
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer id){
        return this.auctionService.delete(id);
    }

    @GetMapping("/owned")
    public List<Auction> getByOwner(@RequestParam Integer id){
        return this.auctionService.getByOwner(id);
    }

    @PutMapping("/update")
    public Auction update(@RequestBody Auction auction){

        return auction;//update: add the support for getting the mapper for the entity i.e., model to object mapping -> and the reverse mapping too
    }
}
