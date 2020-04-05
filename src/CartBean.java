import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartBean {
    private ArrayList<Seat> cart;
    private int cartPrice;
    @PostConstruct
    public void init (){
        this.cart = new ArrayList<Seat>();
        this.cartPrice = 0;
    }
    public ArrayList<Seat> getCart(){
        return cart;
    }
    public void setCart (ArrayList cart){
        this.cart=cart;
    }
    public void addToCart (Seat seat){
        cart.add(seat);
        cartPrice+=seat.getPrice();
    }
    public void removeFromCart (Seat seat){
        cart.remove(seat);
        cartPrice-=seat.getPrice();
    }
    public int getCartPrice(){
        return cartPrice;
    }
    public void clearCart(){
        cart.clear();
        cartPrice=0;
    }
}
