package Model;

public class User {
    private int id;
    private String name;
    private String password;
    private String role;

    public User (){
        id = 0;
        name = password = role = "";
    }

    public User(int id,String name,String password,String role){
        this.id=id;
        this.name=name;
        this.password=password;
        this.role=role;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public void setRole(String role){
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
