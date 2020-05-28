package app.flipkart.model;

public class WithdrawBid {

    private String buyer;
    private String auctionId;

    public WithdrawBid(String operationAttributes) {
        String[] attributes = operationAttributes.split(":");
        this.buyer = attributes[0];
        this.auctionId = attributes[1];
    }

    public WithdrawBid(String buyer, String auctionId, int bidAmout) {
        super();
        this.buyer = buyer;
        this.auctionId = auctionId;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Bid [buyer=");
        builder.append(buyer);
        builder.append(", auctionId=");
        builder.append(auctionId);
        builder.append("]");
        return builder.toString();
    }

}
