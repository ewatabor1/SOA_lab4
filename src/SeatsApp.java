import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ManagedBean(name = "seatsBean")
@SessionScoped
public class SeatsApp {
    @EJB SeatsAction seatsActionBean;
    @EJB PaymentBean paymentBean;
    @EJB CartBean cartBean;
    @EJB SeatsAvailabilityBean seatsAvailabilityBean;

    Logger logger = Logger.getLogger(getClass().getName());

    private List<Seat> cartSeats = new ArrayList<>();
    private List<Seat> availableSeats = new ArrayList<>();


    public ArrayList<Seat> getAvailableSeats(){
        seatsAvailabilityBean.setAvailableSeats(seatsActionBean.getSeats());
        return seatsAvailabilityBean.getAvailableSeats();
    }
    public ArrayList<Seat> getCartSeats(){
        return cartBean.getCart();
    }
    public void reserveSeat(Seat seat){
        try {
            seatsActionBean.reserveSeat(seat);
            cartBean.addToCart(seat);
            seatsAvailabilityBean.removeSeat(seat);
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }
    }
    public void removeFromCart(Seat seat){
        seatsActionBean.unreserveSeat(seat);
        cartBean.removeFromCart(seat);
        seatsAvailabilityBean.addSeat(seat);
    }

    public int getCartPrice(){
        return cartBean.getCartPrice();
    }

    public int getWallet (){
        return paymentBean.getWallet();
    }

    public boolean getDisableBuyTickets(){
        return paymentBean.getWallet()<cartBean.getCartPrice();
    }

    public void buyTickets() {
        try {
            if (paymentBean.payForSeats(cartBean.getCart())) {
                cartBean.clearCart();
            }
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }
    }
}
