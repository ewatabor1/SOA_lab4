public class User {
    private int id;
    private int money;
    public User(int id, int money){
        this.id=id;
        this.money=money;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money=money;
    }

}
