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

    public int addBooks(){
        System.out.println("NEW STOCKS OR EXISTING STOCKS");
        int op=Main.dis();
        if(op==1){
            Books newstock = this.addstock();    //this call addstock() and got new abooks object,that object is store in new stock
            //Main.books.add(newstock)           that newstock book object is added to books. it is simplefied in below line.
            if(newstock ==null){
                return 0;
            }
            else{
                Main.books.add(this.addstock());
                return 1;
            }
        }
        else if(op==0){
            //developing.....
        }
        return 1;
    }
    public Books addstock(){
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
        ui:while(true){//loop for get valid or unique book id for new stocks
            System.out.println("ENTER BOOK ID ");
            int id = in.nextInt();
            in.nextLine();
            Books b = Main.books.stream().filter(bok->bok.getId()==id).findFirst().orElse(null);//checks if already book is exist with same id and return that book to b.if not exist then return null to b.
            if(b==null){//b is null.so, librarien id for newstock is unique(that specific id is not assigned to books in Main.books)
                oid=id;//oid is used.because  final problem is occuer due to using "id" on return statement at end of method
                break ui;//breaks the loop
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
                    return null;
                }
                //if op == 1, then automatically while loop is works.
            }
        }
        return new Books(bname, bauth, bgnr, oid, bquan);
    }
}
