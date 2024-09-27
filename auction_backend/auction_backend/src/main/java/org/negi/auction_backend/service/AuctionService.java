package org.negi.auction_backend.service;

import org.negi.auction_backend.model.Auction;
import org.negi.auction_backend.repository.AuctionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuctionService {
    private AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }

    public Auction getAuctionById(Integer id){
        return auctionRepository.findById(id).orElse(null);
    }

    public List<Auction> getAllAuctions(){
        return auctionRepository.findAll();
    }

    public Auction save(Integer owner_id, Float base_price, String name){
        Auction auction = new Auction();
        auction.setBase_price(base_price);
        auction.setItem_name(name);
        auction.setOwner_id(owner_id);
        return this.auctionRepository.save(auction);
    }

    public String delete(Integer id){
        try {
            this.auctionRepository.deleteById(id);
            return "Auction removed!";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public Auction edit(Auction auction){
        Auction auctionToEdit = this.auctionRepository.findById(auction.getId()).orElse(null);
        if (auctionToEdit == null)
            return this.auctionRepository.save(auction);
        else {
            auctionToEdit.setAuction_status(auction.getAuction_status());
            auctionToEdit.setBase_price(auction.getBase_price());
            auctionToEdit.setImage(auction.getImage());
            auctionToEdit.setItem_info(auction.getItem_info());
            auctionToEdit.setItem_name(auction.getItem_name());
            auctionToEdit.setTop_bid(auction.getTop_bid());
            auctionToEdit.setTop_bidder(auction.getTop_bidder());
            return this.auctionRepository.save(auctionToEdit);
        }
    }

    public List<Auction> getByOwner(Integer id){
        List<Auction> auctions;
        auctions = this.auctionRepository.findByOwner_id(id);
        return auctions;
    }
}
