package model;

import entity.AdminEntity;
import helper.DbUtil;

import java.sql.Connection;

public interface AdminModelInterface {
    Connection conn = DbUtil.getConection();
    boolean login(AdminEntity adminEntity);
}
