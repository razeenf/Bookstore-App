package bookstore;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    public void bookFileWrite(ArrayList<Book> books) throws IOException{
        FileWriter bookFile = new FileWriter("book.txt", true);
        for(Book b: books){
            String bookInfo = b.getTitle() + ", " + b.getPrice() + "\n";
            bookFile.write(bookInfo);
        }
        bookFile.close();
    }//this copies all current books in books arraylist into file

    public void customerFileWrite(ArrayList<Customer> customers) throws IOException{
        FileWriter customerFile = new FileWriter("customer.txt", true);
        for(Customer c: customers){
            String outputText = c.getUsername() + ", " + c.getPassword() + ", " + c.getPoints() + "\n";
            customerFile.write(outputText);
        }
        customerFile.close();
    }

    public void bookFileReset() throws IOException {
        FileWriter bookFile = new FileWriter("book.txt", false);
        bookFile.close();
    }//this resets the entire file so we can copy the new book stock in the arraylist

    public void customerFileReset() throws IOException {
        FileWriter customerFile = new FileWriter("customer.txt", false);
        customerFile.close();
    }

    public ArrayList<Book> readBookFile() throws IOException{
        Scanner scan = new Scanner(new FileReader("book.txt"));
        ArrayList<Book> tempBookHolder = new ArrayList<>();

        while(scan.hasNext()) {
            String[] bookInfo = scan.nextLine().split(",");
            String title = bookInfo[0];
            double price = Double.parseDouble(bookInfo[1]);
            tempBookHolder.add(new Book(title, price));
        }
        return tempBookHolder;
    }//reads in from file puts everything in a temp object array and sends array to be copied from to actual array

    public ArrayList<Customer> readCustomerFile() throws IOException{
        Scanner scan = new Scanner(new FileReader("customer.txt"));
        ArrayList<Customer> tempCustomerHolder = new ArrayList<>();

        while(scan.hasNext()) {
            String[] customerInfo = scan.nextLine().split(", ");
            String username = customerInfo[0];
            String password = customerInfo[1];
            int points = Integer.parseInt(customerInfo[2]);
            tempCustomerHolder.add(new Customer(username, password));
            tempCustomerHolder.get(tempCustomerHolder.size()-1).setPoints(points);
        }
        return tempCustomerHolder;
    }
    //this makes file but does not write to it so idk if it can read from it either
    //update: makes file and does read but cannot write so fix that and update files as program opens/closes
    //update: reads and writes and updates files to include newly added books but cannot delete books
    //update: overhauled method of writing to files so delete method not needed files are written to from array and reset at the end of
    //each session so all tables are updated with current stock when reopened and arrays filled with files contents
}
