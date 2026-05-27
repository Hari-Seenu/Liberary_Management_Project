import java.util.*;
public class Mem {
    String Mname,Mpass;
    int mid;
    List<Books> mhold  = new ArrayList<>();
    public Mem(String mname, String mpass) {
        Mname = mname;
        Mpass = mpass;
    }
    public static Mem mCheck(List<Mem> members, String uname,String upass){
        for(Mem m: members){
            if(uname.equals(m.Mname )&& upass.equals(m.Mpass)){
                return m;
            }
        }
        return null;
    }
    
    public int rentBook(int bookId){
        for(Books book : Main.books ){//loop for iterate all books in List<Books> books as book.
            if(bookId== (int) book.id){//check needed bookin there or not.
                if(book.qun>=0){// check its quantity.
                    if(this.mhold.stream().anyMatch(bok -> bok.getId()==book.getId())){//check that book is already in mhold(member book list)
                    //this.mhold == um object in main. in anyMatch(returns boolean true/false),bok is mhold books and book isin List<Books>books[line 19]      
                        while(true){
                            System.out.println("YOU AREADY HAVE IT\nNEED TO ADD ?");
                            int op = Main.dis();//this is a decision static function from Main class. just a look it up 
                            if(op==1){
                                this.mhold.stream().filter(bok->bok.getId()==bookId).findFirst().ifPresent(bok -> bok.setQun(bok.getQun()+1));
                                Main.books.stream().filter(bok->bok.getId()==bookId).findFirst().ifPresent(bok -> bok.setQun(bok.getQun()-1));//updating Main.book id to -1
                                //iterate all books in Main.books by stream(),filter() it for find that book obj by id,findFirst()for get that book obj and ifPresent for set that book obj's quantity to quan-- bu getid() and setid()
                                return 1;//existing book quantity updated
                            }
                            else if(op==2){//existing book quantity is not updated
                                return op;//op==2 so op = 2.in  Main class 2=="not added successfully"
                            }
                            System.out.println("IDHA KOODA OLUNGA PARTHU PODAMUDIYALANA,APRO ROMBA KASTAM");
                        }
                    }
                    //here,that book is new to member so,adding new object to it with quantity 1.
                    this.mhold.add(new Books(book.bna,book.aut,book.gnr,book.id,1));
                    Main.books.stream().filter(bok->bok.getId()==bookId).findFirst().ifPresent(bok -> bok.setQun(bok.getQun()-1));//updating Main.book id to -1
                    //iterate all books in Main.books by stream(),filter() it for find that book obj by id,findFirst()for get that book obj and ifPresent for set that book obj's quantity to quan-- bu getid() and setid()
                    return 1; //new book added successfully
                    }
                else{
                    return -2;//out of stock
                }
            }    
        } 
        return -1;  //book not found
    }

    public void ownShelf(){
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
        System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-10s |\n","ID","NAME","SOURSE","GENURE","QUANTITY");
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
        for(Books book : this.mhold){
            System.out.printf("| %-10d | %-20s | %-20s | %-20s | %-10d |\n",book.id,book.bna,book.aut,book.gnr,book.qun);
        }
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
    }


}
