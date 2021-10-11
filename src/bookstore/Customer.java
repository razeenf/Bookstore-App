package bookstore;

public class Customer{
    private final String username;
    private final String password;
    private int points;
    private String status; //just testing have to use status abstract class and implement state design pattern

    Customer(String username, String password) {
        this.username = username;
        this.password = password;
        points = 0;
        setStatus(points);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points += points;
        setStatus(this.points);
    }

    public String getStatus() {
        return status;
    }
    private void setStatus(int points) {
        if(points>1000){
            status = "GOLD";
        }else status = "SILVER";
    }

}


