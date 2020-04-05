import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.ejb.Startup;
import javax.faces.bean.ManagedBean;


@Singleton
@Startup
@Lock
public class SeatsActionBean implements SeatsAction {

    ArrayList<Seat> seats;

    @PostConstruct
    public void init(){
        seats = new ArrayList<Seat>(Arrays.asList(
                new Seat(1,1,90), new Seat(1,2,90), new Seat(1,3,90),
                new Seat(2,3,70), new Seat(2,2,60), new Seat(2,3,70),
                new Seat(3,1,65), new Seat(3,2,60), new Seat(2,3,60),
                new Seat(3,4,65), new Seat(3,5,60), new Seat(2,6,60),
                new Seat(4,1,100), new Seat(4,2,90), new Seat(4,3,90),
                new Seat(5,1,60), new Seat(5,2,60), new Seat(5,3,60),
                new Seat(6,1,300)));
    }


    public ArrayList<Seat> getSeats(){
        if (seats==null)
            init();
        return seats;
    }

    public int getSeatPrice(Seat seat){
        return seat!=null ? seat.getPrice() : 0;
    }
    public void reserveSeat(Seat seat) throws Exception {
        if (!seat.isReserved()){
            seat.setReserved(true);
        }
        else throw new Exception("Seat already reserved!");
    }

    public void unreserveSeat(Seat seat) {
        seat.setReserved(false);
    }

}
