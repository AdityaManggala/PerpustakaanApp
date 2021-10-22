package controller;

import model.*;

public class AllObjectModel {
    public static AdminModelInterface adminModel = new AdminModelInterfaceImpl();
    public static AnggotaModelInterface anggotaModel = new AnggotaModelInterfaceImpl();
    public static BukuModelInterface bukuModel = new BukuModelInterfaceImpl();
    public static PeminjamanModelInterface peminjamanModel = new PeminjamanModelInterfaceImpl();
}
