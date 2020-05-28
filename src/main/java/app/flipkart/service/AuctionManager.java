package app.flipkart.service;

import app.flipkart.model.Auction;
import app.flipkart.model.Bid;
import app.flipkart.model.Buyer;
import app.flipkart.model.Seller;
import app.flipkart.model.WithdrawBid;

public interface AuctionManager {
    
    public void addBuyer(Buyer buyer);
    public void addSeller(Seller seller);
    public void createAuction(Auction auction);
    public void withdrawBid(WithdrawBid withdrawBid);
    public String closeAuction(String auctionId);
    public void createBid(Bid bid);
    public double calculateAuctionValue(Seller seller);
}
