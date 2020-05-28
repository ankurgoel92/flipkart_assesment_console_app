package app.flipkart.util;

import app.flipkart.model.Auction;
import app.flipkart.model.Bid;

public class BidValidator {

    public boolean validate(Bid bid, Auction auction) {
        return bid.getBidAmout() <= auction.getHighestBid() && bid.getBidAmout() >= auction.getLowestBid();
    }

}
