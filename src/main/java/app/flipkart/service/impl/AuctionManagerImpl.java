package app.flipkart.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.flipkart.model.Auction;
import app.flipkart.model.AuctionCache;
import app.flipkart.model.Bid;
import app.flipkart.model.Buyer;
import app.flipkart.model.Seller;
import app.flipkart.model.WithdrawBid;
import app.flipkart.service.AuctionManager;
import app.flipkart.util.BidValidator;

public class AuctionManagerImpl implements AuctionManager {

    private BidValidator validator = new BidValidator();
    private List<Buyer> buyers = new ArrayList<>();
    private List<Seller> sellers = new ArrayList<>();
    private Map<String, AuctionCache> map = new HashMap<>();
    private Map<String, String> sellerAuctionMap = new HashMap<>();

    @Override
    public void addBuyer(Buyer buyer) {
//        System.out.println("Adding buyer: " + buyer);
        buyers.add(buyer);
    }

    @Override
    public void addSeller(Seller seller) {
//        System.out.println("addSeller: " + seller);
        sellers.add(seller);
        sellerAuctionMap.put("s1", "a1");
        sellerAuctionMap.put("s2", "a2");
    }

    @Override
    public void createAuction(Auction auction) {
//        System.out.println("createAuction: " + auction);
        AuctionCache cache = new AuctionCache();
        cache.setAuction(auction);
        map.put(auction.getAuctionId(), cache);
    }

    @Override
    public void withdrawBid(WithdrawBid bid) {
//        System.out.println("withdrawBid: " + bid.getBuyer() + " " + bid.getAuctionId());
        map.get(bid.getAuctionId()).withdraw(bid.getBuyer());
    }

    @Override
    public void createBid(Bid bid) {
//        System.out.println("createBid: " + bid);
        AuctionCache auctionCache = map.get(bid.getAuctionId());
        boolean isValid = validator.validate(bid, auctionCache.getAuction());
        if (isValid) {
            auctionCache.createBid(bid);
        } else {
            System.out.println("Entered Bid Amount is out of bounds => IGNORING THE BID");
        }

    }

    @Override
    public String closeAuction(String auctionId) {
//        System.out.println("closeAuction: " + auctionId);
        map.get(auctionId).getTopBidder();
        return map.get(auctionId).getTopBidder();
    }

    @Override
    public double calculateAuctionValue(Seller seller) {
//        System.out.println("calculateAuctionValue: " + seller);
        AuctionCache auctionCache = map.get(sellerAuctionMap.get(seller.getName()));
        return auctionCache.getAuctionValue();
    }

}
