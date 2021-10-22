package entity;

import java.sql.Date;

public class PeminjamanEntity {

    private String idPeminjaman;
    private String isbnBuku;
    private String judulBuku;
    private String namaAnggota;
    private int idAnggota;
    private Date tglPeminjaman;
    private Date tglPengembalian;
    private Boolean statusPeminjaman;

    public PeminjamanEntity(String isbnBuku, int idAnggota) {
        this.isbnBuku = isbnBuku;
        this.idAnggota = idAnggota;
    }

    public PeminjamanEntity() {
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getIsbnBuku() {
        return isbnBuku;
    }

    public void setIsbnBuku(String isbnBuku) {
        this.isbnBuku = isbnBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public Date getTglPeminjaman() {
        return tglPeminjaman;
    }

    public void setTglPeminjaman(Date tglPeminjaman) {
        this.tglPeminjaman = tglPeminjaman;
    }

    public Date getTglPengembalian() {
        return tglPengembalian;
    }

    public void setTglPengembalian(Date tglPengembalian) {
        this.tglPengembalian = tglPengembalian;
    }

    public Boolean getStatusPeminjaman() {
        return statusPeminjaman;
    }

    public void setStatusPeminjaman(Boolean statusPeminjaman) {
        this.statusPeminjaman = statusPeminjaman;
    }
}
