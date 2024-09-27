package org.negi.auction_backend.service;

import org.negi.auction_backend.model.Bid;
import org.negi.auction_backend.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {
    @Autowired
    BidRepository bidRepository;

    public Bid getById(Integer id){
        return this.bidRepository.findById(id).orElse(null);
    }

    public Bid save(float bid_value, Integer auction_id, Integer bidder){
        Bid bid = new Bid();
        bid.setBid_value(bid_value);
        bid.setBidder(bidder);
        bid.setAuction_id(auction_id);
        return this.bidRepository.save(bid);
    }

    public List<Bid> getAllBids(){
        return this.bidRepository.findAll();
    }

    public List<Bid> getAllByAuctionID( Integer id){
        return this.bidRepository.findByAuction_id(id);
    }

    public List<Bid> getAllByBidder(Integer bidder){
        return this.bidRepository.findByBidder(bidder);
    }
    public String deleteById(Integer id){
        try {
            this.bidRepository.deleteById(id);
            return "Bid removed!";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
