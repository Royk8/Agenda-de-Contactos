import java.util.ArrayList;

public class Contacto {
    private String name, lastName, nickName, email, category;
    private float telephone;
    //private ArrayList<String> categoryList = new ArrayList();


    public Contacto() {
    }

    public Contacto(String name, String lastName, String nickName, String email, String category, float telephone) {
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email = email;
        this.category = category;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getTelephone() {
        return telephone;
    }

    public void setTelephone(float telephone) {
        this.telephone = telephone;
    }
}
