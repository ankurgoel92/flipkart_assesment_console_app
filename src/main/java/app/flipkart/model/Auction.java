package app.flipkart.model;

public class Auction {
    private String auctionId;
    private int lowestBid;
    private int highestBid;
    private int participationCost;
    private String seller;

    public Auction(String operationAttributes) {
        String[] attributes = operationAttributes.split(":");
        this.auctionId = attributes[0];
        this.lowestBid = Integer.parseInt(attributes[1]);
        this.highestBid = Integer.parseInt(attributes[2]);
        this.participationCost = Integer.parseInt(attributes[3]);
        this.seller = attributes[4];
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public int getLowestBid() {
        return lowestBid;
    }

    public void setLowestBid(int lowestBid) {
        this.lowestBid = lowestBid;
    }

    public int getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(int highestBid) {
        this.highestBid = highestBid;
    }

    public int getParticipationCost() {
        return participationCost;
    }

    public void setParticipationCost(int participationCost) {
        this.participationCost = participationCost;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Auction [auctionId=");
        builder.append(auctionId);
        builder.append(", lowestBid=");
        builder.append(lowestBid);
        builder.append(", highestBid=");
        builder.append(highestBid);
        builder.append(", participationCost=");
        builder.append(participationCost);
        builder.append(", seller=");
        builder.append(seller);
        builder.append("]");
        return builder.toString();
    }

}
