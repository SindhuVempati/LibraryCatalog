/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarycatalog;

public class Book {
    //Properties, Fields, Global variables
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;
    int dayCheckedOut = -1;
    
    //constructor
    public Book(String bookTitle, int bookPageCount, int bookISBN){
        this.title = bookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;  
    }
    
    //getters
    public String getTitle(){
        return this.title;
    }
    
    public int getpageCount(){
        return this.pageCount;
    }
    
    public int getISBN(){
        return this.ISBN;
    }
    
    public boolean getIsCheckedOut(){
        return this.isCheckedOut;
    }
    
    public int getDayCheckedOut(){
        return this.dayCheckedOut;
    }
    
    public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut){
        this.isCheckedOut = newIsCheckedOut;
    }
    
    private void setDayCheckedOut(int day){
        this.dayCheckedOut = day;
    }
    
}
