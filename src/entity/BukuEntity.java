package entity;

public class BukuEntity {

    private String isbn;
    private String judul;
    private String penerbit;
    private int terbit;
    private int halaman;

    public BukuEntity(String isbn, String judul, String penerbit, int terbit, int halaman) {
        this.isbn = isbn;
        this.judul = judul;
        this.penerbit = penerbit;
        this.terbit = terbit;
        this.halaman = halaman;
    }

    public BukuEntity() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTerbit() {
        return terbit;
    }

    public void setTerbit(int terbit) {
        this.terbit = terbit;
    }

    public int getHalaman() {
        return halaman;
    }

    public void setHalaman(int halaman) {
        this.halaman = halaman;
    }
}
