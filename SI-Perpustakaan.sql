CREATE TABLE buku
(
    buku_isbn         VARCHAR(13)       NOT NULL PRIMARY KEY,
    buku_judul        VARCHAR(255)      NOT NULL,
    buku_penerbit     VARCHAR(50)       NOT NULL,
    buku_terbit       INT               NOT NULL,
    buku_halaman      INT               NOT NULL,
    buku_ketersediaan BOOL DEFAULT TRUE NOT NULL
);

CREATE TABLE admin
(
    admin_id       INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    admin_nama     VARCHAR(20) NOT NULL,
    admin_password VARCHAR(15) NOT NULL
);

CREATE TABLE anggota
(
    anggota_id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    anggota_nama     VARCHAR(20)  NOT NULL,
    anggota_password VARCHAR(15)  NOT NULL,
    anggota_notelp   VARCHAR(12)  NOT NULL,
    anggota_alamat   VARCHAR(100) NOT NULL,
    anggota_aktif    BOOL DEFAULT TRUE NOT NULL
);

CREATE TABLE peminjaman
(
    peminjaman_id    VARCHAR(6)         NOT NULL PRIMARY KEY,
    buku_isbn        VARCHAR(13)        NOT NULL,
    anggota_id       INT                NOT NULL,
    peminjaman_tgl   TIMESTAMP          NOT NULL,
    pengembalian_tgl TIMESTAMP          NULL,
    status           BOOL DEFAULT FALSE NOT NULL
);

ALTER TABLE peminjaman
    ADD FOREIGN KEY (buku_isbn) REFERENCES buku (buku_isbn),
    ADD FOREIGN KEY (anggota_id) REFERENCES anggota (anggota_id);

INSERT INTO admin(admin_nama, admin_password)
VALUES ('admin', 'admin');
