package view;

import controller.*;

public class AllObjectController {
    public static AdminControllerInterface adminController = new AdminControllerInterfaceImpl();
    public static AnggotaControllerInterface anggotaController = new AnggotaControllerInterfaceImpl();
    public static PeminjamanControllerInterface peminjamanController = new PeminjamanControllerInterfaceImpl();
    public static BukuControllerInterface bukuController = new BukuControllerInterfaceImpl();
}
