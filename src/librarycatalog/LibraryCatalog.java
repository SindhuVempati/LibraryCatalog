
package librarycatalog;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalog 
{
    Map<String,Book> bookCollection = new HashMap<String,Book>(); // Book is the class
    int currentDay = 0;
    int lengthofCheckOutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1;
    
    //Constructors
    public LibraryCatalog(Map<String,Book> collection,int lengthOfCheckOutPeriod, 
            double initialLateFee, double feePerLateDay){
        this.bookCollection = collection;
        this.lengthofCheckOutPeriod = lengthOfCheckOutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
        
    }
    
    public LibraryCatalog(Map<String,Book> collection){
        this.bookCollection = collection;
        
    }
    //Getters
    public int getCurrentDay(){
        return this.currentDay;
    }
    public int getlengthofCheckOutPeriod(){
        return this.lengthofCheckOutPeriod;
    }
    public double getinitialLateFee(){
        return this.initialLateFee;
    }
    public double getfeePerLateDay(){
        return this.feePerLateDay;
    }
    public Map<String,Book> getbookCollection(){
        return this.bookCollection;
    }
    public Book getBook(String bookTitle){
        return getbookCollection().get(bookTitle);
    }
    
    //Setters
    
    public void nextDay(){
        currentDay++;
    }
     public void setDay(int day){
         currentDay=day;
     }
     
     //Instance methods 
     public void checkOutBook (String title){
         Book book = getBook(title);
         if(book.getIsCheckedOut()){
             sorryBookAlreadyCheckedOut(book);
         }
         else{
             book.setIsCheckedOut(true, currentDay);
             System.out.println("You just checked out "+title+". It is due on day "+ 
                     (getCurrentDay()+getlengthofCheckOutPeriod())+"." );
         }
     }
     
     public void returnBook(String title){
     
         Book book = getBook(title);
         int daysLate = currentDay - (book.getDayCheckedOut()+getlengthofCheckOutPeriod());
         if(daysLate>0){
             System.out.println("You owe the Library $"+((daysLate*getfeePerLateDay())+getinitialLateFee())
             +"because your book is "+daysLate+"overdue.");
         }else{
             System.out.println("Thank You!");
             
         }
         book.setIsCheckedOut(false, -1);
     }
     
     public void sorryBookAlreadyCheckedOut(Book book){
         System.out.println("Sorry "+book.getTitle()+" is already checked out and it should be back on the day"+
                 (book.getDayCheckedOut()+getlengthofCheckOutPeriod())+".");
     }
     
    public static void main(String[] args) 
    {
        Map<String,Book> bookCollection = new HashMap<String,Book>();
        Book harry = new Book("Harry Potter",333,123456789);
        bookCollection.put("Harry Potter", harry);
        
        LibraryCatalog lib = new LibraryCatalog(bookCollection);
        lib.checkOutBook("Harry Potter");
        lib.nextDay();
        lib.nextDay();
        lib.checkOutBook("Harry Potter");
        lib.setDay(17);
        lib.returnBook("Harry Potter");
        lib.checkOutBook("Harry Potter");

    }
    
}
