public class Books{
    String bna,aut,gnr;
    int id,qun;
    public Books(String bna, String aut, String gnr, int id, int qun) {
        this.bna = bna;
        this.aut = aut;
        this.gnr = gnr;
        this.id = id;
        this.qun = qun;
    }
    public String getBna() {
        return bna;
    }
    public void setBna(String bna) {
        this.bna = bna;
    }
    public String getAut() {
        return aut;
    }
    public void setAut(String aut) {
        this.aut = aut;
    }
    public String getGnr() {
        return gnr;
    }
    public void setGnr(String gnr) {
        this.gnr = gnr;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQun() {
        return qun;
    }
    public void setQun(int qun) {
        this.qun = qun;
    }

    public static Books getBook_id(int id){
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
        System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-10s |\n","ID","NAME","SOURSE","GENURE","QUANTITY");
        System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
        for(Books b: Main.books){
            if(b.id==id){
                System.out.printf("| %-10d | %-20s | %-20s | %-20s | %-10d |\n",b.id,b.bna,b.aut,b.gnr,b.qun);
                System.out.println("+------------+----------------------+----------------------+----------------------+------------+");
                return b;
            }
        }
        return null;
    }

}