import javax.ejb.Remote;
import javax.ejb.Startup;
import java.util.ArrayList;


@Startup
public interface SeatsAction {

    void init();
    public ArrayList<Seat> getSeats();
    public int getSeatPrice(Seat seat);
    public void reserveSeat(Seat seat) throws Exception;
    public void unreserveSeat(Seat seat);
}
