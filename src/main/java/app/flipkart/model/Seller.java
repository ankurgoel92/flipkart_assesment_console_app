package app.flipkart.model;

public class Seller {
    private String name;

    public Seller(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Seller [name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }

}
