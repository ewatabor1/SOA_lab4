
public class Seat {
    private int row;
    private int column;
    private int price;
    private boolean reserved;
    private boolean bought;

    public Seat(int row, int column, int price){
        this.row=row;
        this.column=column;
        this.price=price;
    }

    public int getRow(){
        return row;
    }
    public void setRow(int row){
        this.row=row;
    }
    public int getColumn(){return column;}
    public void setColumn(){
        this.column=column;
    }
    public int getPrice(){
        return price;
    }

    public boolean isReserved(){
        if (bought) return true;
        return reserved;
    }
    public void setReserved(boolean reserved){
        this.reserved=reserved;
    }

    public boolean isBought(){
        return bought;
    }
    public void setBought(boolean bought){
        this.bought=bought;
    }
}
