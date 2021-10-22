package controller;

import entity.AdminEntity;

public class AdminControllerInterfaceImpl implements AdminControllerInterface{

    @Override
    public boolean login(String nama, String password) {
        AdminEntity adminEntity = new AdminEntity(nama,password);
        return AllObjectModel.adminModel.login(adminEntity);
    }

    @Override
    public void deleteAnggota(int id) {
        AllObjectModel.anggotaModel.remove(id);
    }

    @Override
    public void resetPassAnggota(int id) {
        AllObjectModel.anggotaModel.resetPassword(id);
    }
}
