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

}