import java.util.*;
public class Librarien extends Main{
    String Lname,Lpass;
    public Librarien(String lname, String lpass) {
        Lname = lname;
        Lpass = lpass;
    }
    public static Librarien lCheck(List<Librarien> Librians, String uname,String upass){
        for(Librarien l  : Librians){
            if(uname.equals(l.Lname )&& upass.equals(l.Lpass)){
                return l;//returns that liberarian object
            }
        }
        return null;
    }

    public static void libBook(){
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
        System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-10s |\n","ID","NAME","SOURSE","GENURE","QUANTITY");
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
        for(Books book : Main.books){
            System.out.printf("| %-10d | %-20s | %-20s | %-20s | %-10d |\n",book.id,book.bna,book.aut,book.gnr,book.qun);
        }
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
    }

   
    public int updateStocks(){
        while(true){
            System.out.println("ENTER BOOK ID");
            int bid=in.nextInt();
            in.nextLine();
            Books b = Books.getBook_id(bid);
            if(b!=null){
                System.out.println("BOOK IS FOUNDED\nENTER QUANTITY OF NEW STOCK");
                int op=in.nextInt();
                in.nextLine();
                b.setQun(b.getQun()+op);
                return 1;
                
            }
            else{
                System.out.println("ENTER EXISTING BOOK ID\nTRY ANOTHER ID OR EXIT");
                int op=Main.dis();
                if(op==0){
                    System.out.println("EXITED SUCCESSFULLY");
                    return 0;
                }
            }
        }
    }
    public int addStock(){
        System.out.println("ENTER BOOK NAME: ");
        String bname = in.nextLine();
        System.out.println("ENTER BOOK AUTHOR NAME: ");
        String bauth = in.nextLine();
        System.out.println("ENTER BOOK GENERE: ");
        String bgnr = in.nextLine();
        System.out.println("ENTER BOOK QUANTITY: ");
        int bquan = in.nextInt();
        in.nextLine();
        int oid;
        while(true){//loop for get valid or unique book id for new stocks
            System.out.println("ENTER BOOK ID ");
            int id = in.nextInt();
            in.nextLine();
            Books b = Main.books.stream().filter(bok->bok.getId()==id).findFirst().orElse(null);//checks if already book is exist with same id and return that book to b.if not exist then return null to b.
            if(b==null){//b is null.so, librarien id for newstock is unique(that specific id is not assigned to books in Main.books)
                oid=id;//oid is used.because  final problem is occuer due to using "id" on return statement at end of method
                Main.books.add(new Books(bname,bauth,bgnr,oid,bquan));//new book stock is added to Main.Books 
                return 1;
            }
            else{//here b is not null.b contain the exixting book with that (librarien assigning id) "id" in Main.Books
                System.out.println("BOOK ID IS ALREADY EXIST");
                System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-10s |\n","ID","NAME","SOURSE","GENURE","QUANTITY");
                System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                System.out.printf("| %-10d | %-20s | %-20s | %-20s | %-10d |\n",b.id,b.bna,b.aut,b.gnr,b.qun);
                System.out.println("+------------+----------------------+----------------------+----------------------+------------+");//info about the existing book
                System.out.println("TRY ANOTHER ID OR EXIT");//asking for try another id or exit
                int op=Main.dis();//0 for exit 1 for try another id
                if (op==0) {//book not added
                    return 0;
                }
            }
        }
        
    }
}
