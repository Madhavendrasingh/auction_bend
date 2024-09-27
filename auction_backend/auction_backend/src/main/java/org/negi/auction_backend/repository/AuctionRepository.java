package org.negi.auction_backend.repository;

import org.negi.auction_backend.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction,Integer> {
    @Query("SELECT a FROM Auction a WHERE a.owner_id = :owner_id")
    List<Auction> findByOwner_id(@Param("owner_id") Integer owner_id);
}
