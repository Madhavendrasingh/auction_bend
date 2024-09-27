package org.negi.auction_backend.repository;

import org.negi.auction_backend.model.Auction;
import org.negi.auction_backend.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Integer> {
    @Query("SELECT a FROM Bid a WHERE a.auction_id = :auction_id")
    List<Bid> findByAuction_id(@Param("auction_id") Integer auction_id);

    @Query("SELECT a FROM Bid a WHERE a.bidder = :bidder")
    List<Bid> findByBidder(@Param("bidder") Integer bidder);
}
