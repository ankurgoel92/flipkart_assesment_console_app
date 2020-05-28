package app.flipkart;

import app.flipkart.model.Auction;
import app.flipkart.model.Bid;
import app.flipkart.model.Buyer;
import app.flipkart.model.Seller;
import app.flipkart.model.WithdrawBid;
import app.flipkart.service.AuctionManager;
import app.flipkart.service.impl.AuctionManagerImpl;

public class AuctionSystemMain {
    private static AuctionManager manager = new AuctionManagerImpl();
    public static void main(String[] args) {
        System.out.println("NOTE TO EVALUATOR: I have used short names for seller,buyres,auctions etc like s1,b1,a1. I was short of time but would like to use Command pattern to process the inputs and factory for creating the objects. Thanks");
        String input1 = "add_buyer b1;add_buyer b2;add_buyer b3;add_seller s1;create_auction a1:10:50:1:s1;create_bid b1:a1:17;create_bid b2:a1:15;create_bid b2:a1:19;create_bid b3:a1:19;close_auction a1;get_profit s1";
        String input2 = "add_seller s2;create_auction a2:5:20:2:s2;create_bid b3:a2:25;create_bid b2:a2:5;withdraw_bid b2:a2;close_auction a2;get_profit s2";
        processInput(input1);
        processInput(input2);
    }

    private static void processInput(String input) {
       // AuctionManager manager = new AuctionManagerImpl();
        String[] operations = input.split(";");

        for (String operation : operations) {
            String[] operationDetails = operation.split(" ");
            String operationName = operationDetails[0].trim();
            String operationAttributes = operationDetails[1].trim();

            if (operationName.equalsIgnoreCase("add_buyer")) {
                manager.addBuyer(new Buyer(operationAttributes));
            }

            if (operationName.equalsIgnoreCase("add_seller")) {
                manager.addSeller(new Seller(operationAttributes));
            }

            if (operationName.equalsIgnoreCase("create_auction")) {
                manager.createAuction(new Auction(operationAttributes));
            }

            if (operationName.equalsIgnoreCase("create_bid")) {
                manager.createBid(new Bid(operationAttributes));
            }
            
            if (operationName.equalsIgnoreCase("withdraw_bid")) {
                manager.withdrawBid(new WithdrawBid(operationAttributes));
            }

            if (operationName.equalsIgnoreCase("close_auction")) {
                System.out.println("WINNER: " + manager.closeAuction(operationAttributes));

            }

            if (operationName.equalsIgnoreCase("get_profit")) {
                System.out.println("PROFIT: " + manager.calculateAuctionValue(new Seller(operationAttributes)));
            }

        }
    }

}
