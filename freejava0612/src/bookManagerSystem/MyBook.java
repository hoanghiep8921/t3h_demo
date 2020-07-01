package bookManagerSystem;

import java.util.ArrayList;

public class MyBook {
    private ArrayList<Book> bookArrayList = new ArrayList<Book>();
    private String name;


    public MyBook(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //thêm mới sách vào trong kho
    public void addBook(Book book) {
        bookArrayList.add(book);
    }

    public void displayAllBooks() {
        System.out.println("Hien thi toan bo sach");
        if (bookArrayList.size() == 0) {
            System.out.println("Khong co quyen sach nao");
        }
        for (Book book : bookArrayList) {
            System.out.println(book);
            System.out.println("Ten sach :" + book.getName());
            System.out.println("Gia ban:" + book.getPrice());
        }
    }

    public void editBook(int index, Book book) {
        bookArrayList.set(index, book);
    }

    public void deleteBook(String name) {
        int index = -1;
        for (int i = 0; i < bookArrayList.size(); i++) {
            Book book = bookArrayList.get(i);
            if (book.getName().equalsIgnoreCase(name)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Khong tim thay sach can xoa");
        } else {
            bookArrayList.remove(index);
            System.out.println("Xoa thanh cong");
        }
    }

    public Book searchBook(String name) {
        for (Book book : bookArrayList) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

}
