package app.flipkart.model;

public class Buyer {

    private String name;
    private int bidAmount;

    public Buyer(String name, int bidAmount) {
        super();
        this.name = name;
        this.bidAmount = bidAmount;
    }

    public Buyer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Buyer [name=");
        builder.append(name);
        builder.append(", bidAmount=");
        builder.append(bidAmount);
        builder.append("]");
        return builder.toString();
    }

}
