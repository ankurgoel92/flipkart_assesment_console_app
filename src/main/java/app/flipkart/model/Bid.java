package app.flipkart.model;

public class Bid {

    private String buyer;
    private String auctionId;
    private int bidAmout;

    public Bid(String operationAttributes) {
        String[] attributes = operationAttributes.split(":");
        this.buyer = attributes[0];
        this.auctionId = attributes[1];
        this.bidAmout = Integer.parseInt(attributes[2]);
    }

    public Bid(String buyer, String auctionId, int bidAmout) {
        super();
        this.buyer = buyer;
        this.auctionId = auctionId;
        this.bidAmout = bidAmout;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public int getBidAmout() {
        return bidAmout;
    }

    public void setBidAmout(int bidAmout) {
        this.bidAmout = bidAmout;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Bid [buyer=");
        builder.append(buyer);
        builder.append(", auctionId=");
        builder.append(auctionId);
        builder.append(", bidAmout=");
        builder.append(bidAmout);
        builder.append("]");
        return builder.toString();
    }

}
