package Model;

public class Supplier {
    private int id ;
    private String name;
    private long contact;

    public Supplier(){
        id = 0;
        contact = 0;
        name = "";
    }
    public Supplier(int id, String name, long contant) {
        this.id = id;
        this.name = name;
        this.contact = contant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
}
