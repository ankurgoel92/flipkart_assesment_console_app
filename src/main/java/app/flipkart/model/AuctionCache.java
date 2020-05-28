package app.flipkart.model;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class AuctionCache {
    public Auction auction;
    Set<String> buyersRegistered = new HashSet<String>();
    public Map<String, Integer> map = new HashMap<>();
    public Auction getAuction() {
        return auction;
    }
    public void setAuction(Auction auction) {
        this.auction = auction;
    }
    public Map<String, Integer> getBuyerToBidMap() {
        return map;
    }
    public void setBuyerToBidMap(Map<String, Integer> buyerToBidMap) {
        this.map = buyerToBidMap;
    }
    public void withdraw(String buyer) {
        map.remove(buyer);        
    }
    
    public void createBid(Bid bid) {
        buyersRegistered.add(bid.getBuyer());
        map.put(bid.getBuyer(), bid.getBidAmout());
    }
    
    public String getTopBidder() {
        if(map.size() <= 0) {
            return "NO WINNER";
        }
        final int max = getWinningPrice();
        Set<Entry<String, Integer>> result = map.entrySet().stream().filter(e -> e.getValue() == max).collect(Collectors.toSet());
        return result.iterator().next().getKey();
    }
    
    public int getWinningPrice() {
        List<Integer> amounts = map.values().stream().collect(Collectors.toList());
        Collections.sort(amounts, Collections.reverseOrder());
        int maxUniqueAmount = 0;
        for (int i = 1; i < amounts.size(); i++) {
            if(amounts.get(i) != amounts.get(i - 1)) {
                maxUniqueAmount = amounts.get(i);
                break;
            }
        }
        final int max = maxUniqueAmount;
        return max;
    }
    public double getAuctionValue() {
        double participationCost = 0.2 * buyersRegistered.size() * auction.getParticipationCost();
        if(map.isEmpty()) {
            return participationCost;
        }
        double average = (auction.getHighestBid() + auction.getLowestBid()) / 2.0;
        DecimalFormat format = new DecimalFormat("#.#");
        double result = getWinningPrice() + participationCost - average;
        return Double.parseDouble(format.format(result));
    }
    
    
}
