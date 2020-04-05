import javax.ejb.Lock;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Lock
@Stateless
public class SeatsAvailabilityBean {
    private ArrayList<Seat> availableSeats = new ArrayList<>();

    public ArrayList<Seat> getAvailableSeats(){
        return availableSeats;
    }
    public void setAvailableSeats(ArrayList<Seat> seats) {
        if (seats!=null) {
            if (!seats.isEmpty()) {
                if (!availableSeats.isEmpty()) {
                    availableSeats.clear();
                }
                for (Seat seat : seats) {
                    if (!seat.isReserved())
                        availableSeats.add(seat);
                }
            }
        }
    }

    public void addSeat(Seat seat){
        if (!availableSeats.contains(seat)){
            availableSeats.add(seat);
        }
    }

    public void removeSeat(Seat seat){
        if (availableSeats.contains(seat))
            availableSeats.remove(seat);
    }


}
