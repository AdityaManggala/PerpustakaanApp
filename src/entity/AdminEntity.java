package entity;

public class AdminEntity extends UserEntity{

    private int id;
    public AdminEntity(String nama, String password) {
        super(nama, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
