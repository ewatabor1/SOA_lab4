import javax.ejb.Stateful;
import java.util.ArrayList;

@Stateful
public class PaymentBean {
    private int wallet;

    public PaymentBean(){
        wallet = 300;
    }

    public int getWallet(){
        return wallet;
    }

    public void payForSeat(Seat seat) throws Exception {
        if (wallet<seat.getPrice())
            throw new Exception("Not enough money to buy this seat.");
        if (seat.isReserved())
            throw new Exception("Seat already reserved");
        seat.setReserved(true);
        wallet=-seat.getPrice();
    }

    public boolean payForSeats(ArrayList<Seat> seats) throws Exception {
        int seatsPrice = 0;
        for (Seat seat:seats){
            seatsPrice=seatsPrice+seat.getPrice();
            if (seat.isBought()){
                throw new Exception("One of the seats is already taken");
            }
        }
        if (wallet<seatsPrice){
            throw new Exception("Not enough money to buy seats");
        }
        for (Seat seat: seats){
            seat.setBought(true);
        }
        wallet=wallet-seatsPrice;
        return true;
    }
}