package controller;

public interface AdminControllerInterface {
    boolean login(String nama, String password);
    void deleteAnggota(int id);
    void resetPassAnggota(int id);
}
