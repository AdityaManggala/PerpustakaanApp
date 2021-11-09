package entity;

public class AnggotaEntity extends UserEntity{

    private String noTelp;
    private String alamat;
    private int id;

    public AnggotaEntity(String nama, String password,String noTelp, String alamat) {
        super(nama, password);
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public AnggotaEntity(String nama, String password) {
        super(nama, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
