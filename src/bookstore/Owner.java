package bookstore;
import java.io.IOException;
import java.util.ArrayList;

public class Owner{
    private static final Files files = new Files();
    protected static ArrayList<Book> books = new ArrayList<>(); //do same here as customer
    private static final ArrayList<Customer> customers = new ArrayList<>();

    public void restockArrays() throws IOException {
        ArrayList<Book> tempBooks = files.readBookFile();
        ArrayList<Customer> tempCustomers = files.readCustomerFile();
        books.addAll(tempBooks);
        customers.addAll(tempCustomers);
    }

    public String getUsername(){
        return "admin";
    }
    public String getPassword(){
        return "admin";
    }

    public void addCustomer(Customer created){
        customers.add(created);
    }

    public void deleteCustomer(Customer selected){
        customers.remove(selected);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Customer> getCustomers(){
        return (ArrayList<Customer>) customers.clone();
    }

    /*public void addCustomer(Customer c){
        customers.add(c);
    }

    public Customer getCustomers(){
        for(Customer c: customers){
            return c;
        }  //tf is this method
        return getCustomers();
    }

    public void addBook(Book b){
        books.add(b);
    }
    public void deleteBook(Book b){
        books.remove(b);
    }*/ //use these with private arrays to not expose rep

}
