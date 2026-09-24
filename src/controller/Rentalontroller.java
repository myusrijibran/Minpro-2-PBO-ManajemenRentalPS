package controller;

import model.PS;
import model.Pelanggan;
import model.PelangganMember;
import model.PelangganReguler;
import model.Rental;

import service.PSService;
import service.PelangganService;
import service.RentalService;

import view.RentalView;

public class Rentalontroller {

    private PSService psService;
    private PelangganService pelangganService;
    private RentalService rentalService;
    private RentalView view;

    private boolean berjalan = true;

    // Constructor
    public Rentalontroller(
            PSService psService,
            PelangganService pelangganService,
            RentalService rentalService,
            RentalView view) {

        this.psService = psService;
        this.pelangganService = pelangganService;
        this.rentalService = rentalService;
        this.view = view;
    }

    // ==========================================
    // MENJALANKAN PROGRAM
    // ==========================================
    public void jalankan() {

        while (berjalan) {

            view.tampilkanMenu();

            int pilihan = view.inputPilihan();

            switch (pilihan) {

                case 1:
                    tambahPS();
                    break;

                case 2:
                    psService.tampilkanPS();
                    break;

                case 3:
                    ubahPS();
                    break;

                case 4:
                    hapusPS();
                    break;

                case 5:
                    tambahPelanggan();
                    break;

                case 6:
                    pelangganService.tampilkanPelanggan();
                    break;

                case 7:
                    rentalPS();
                    break;

                case 8:
                    rentalService.tampilkanRental(
                            pelangganService,
                            psService
                    );
                    break;

                case 9:
                    berjalan = false;
                    view.tampilkanPesan(
                            "Program selesai. Terima kasih!"
                    );
                    break;

                default:
                    view.tampilkanPesan(
                            "Menu tidak tersedia."
                    );
                    break;
            }
        }
    }

    // ==========================================
    // TAMBAH PS
    // ==========================================
    private void tambahPS() {

        view.tampilkanHeader("Tambah PS");

        String id = view.inputString("ID PS     : ");
        String jenis = view.inputString("Jenis PS  : ");
        int harga = view.inputAngka("Harga/Jam : Rp");

        try {

            PS ps = new PS(id, jenis, harga);

            psService.tambahPS(ps);

            view.tampilkanPesan(
                    "PS berhasil ditambahkan."
            );

        } catch (IllegalArgumentException e) {

            view.tampilkanPesan(
                    "Gagal: " + e.getMessage()
            );
        }
    }

    // ==========================================
    // UBAH PS
    // ==========================================
    private void ubahPS() {

        view.tampilkanHeader("Ubah PS");

        String id = view.inputString(
                "Masukkan ID PS: "
        );

        String jenis = view.inputString(
                "Jenis PS baru : "
        );

        int harga = view.inputAngka(
                "Harga baru     : Rp"
        );

        try {

            boolean berhasil = psService.ubahPS(
                    id,
                    jenis,
                    harga
            );

            if (berhasil) {

                view.tampilkanPesan(
                        "Data PS berhasil diubah."
                );

            } else {

                view.tampilkanPesan(
                        "ID PS tidak ditemukan."
                );
            }

        } catch (IllegalArgumentException e) {

            view.tampilkanPesan(
                    "Gagal: " + e.getMessage()
            );
        }
    }

    // ==========================================
    // HAPUS PS
    // ==========================================
    private void hapusPS() {

        view.tampilkanHeader("Hapus PS");

        String id = view.inputString(
                "Masukkan ID PS: "
        );

        boolean berhasil =
                psService.hapusPS(id);

        if (berhasil) {

            view.tampilkanPesan(
                    "Data PS berhasil dihapus."
            );

        } else {

            view.tampilkanPesan(
                    "ID PS tidak ditemukan."
            );
        }
    }

    // ==========================================
    // TAMBAH PELANGGAN
    // ==========================================
    private void tambahPelanggan() {

        view.tampilkanHeader(
                "Tambah Pelanggan"
        );

        String id = view.inputString(
                "ID Pelanggan : "
        );

        String nama = view.inputString(
                "Nama         : "
        );

        String noTelepon = view.inputString(
                "No. Telepon  : "
        );

        System.out.println();
        System.out.println("Jenis Pelanggan");
        System.out.println("1. Reguler");
        System.out.println("2. Member");

        int jenis = view.inputPilihan();

        try {

            Pelanggan pelanggan;

            if (jenis == 1) {

                pelanggan = new PelangganReguler(
                        id,
                        nama,
                        noTelepon
                );

            } else if (jenis == 2) {

                pelanggan = new PelangganMember(
                        id,
                        nama,
                        noTelepon
                );

            } else {

                view.tampilkanPesan(
                        "Jenis pelanggan tidak tersedia."
                );

                return;
            }

            pelangganService.tambahPelanggan(
                    pelanggan
            );

            view.tampilkanPesan(
                    "Pelanggan berhasil ditambahkan."
            );

        } catch (IllegalArgumentException e) {

            view.tampilkanPesan(
                    "Gagal: " + e.getMessage()
            );
        }
    }

    // ==========================================
    // RENTAL PS
    // ==========================================
    private void rentalPS() {

        view.tampilkanHeader("Rental PS");

        // Mencari pelanggan
        String idPelanggan = view.inputString(
                "ID Pelanggan : "
        );

        Pelanggan pelanggan =
                pelangganService.cariPelanggan(
                        idPelanggan
                );

        if (pelanggan == null) {

            view.tampilkanPesan(
                    "Pelanggan tidak ditemukan."
            );

            return;
        }

        // Mencari PS
        String idPS = view.inputString(
                "ID PS        : "
        );

        PS ps = psService.cariPS(idPS);

        if (ps == null) {

            view.tampilkanPesan(
                    "PS tidak ditemukan."
            );

            return;
        }

        // Input lama rental
        int lama = view.inputAngka(
                "Lama rental (jam): "
        );

        // Menghitung harga awal
        int total = ps.getHarga() * lama;

        // Polymorphism
        int diskon = pelanggan.hitungDiskon(total);

        // Menghitung total pembayaran
        int totalBayar = total - diskon;

        // Membuat ID rental otomatis
        String idRental =
                "R00" + (rentalService.jumlahRental() + 1);

        // Membuat objek Rental
        Rental rental = new Rental(
                idRental,
                pelanggan.getIdPelanggan(),
                ps.getId(),
                lama,
                totalBayar
        );

        // Menyimpan data rental
        rentalService.tambahRental(rental);

        // Menampilkan detail rental
        System.out.println();
        System.out.println("================================");
        System.out.println("         DETAIL RENTAL");
        System.out.println("================================");

        System.out.println(
                "ID Rental    : " + idRental
        );

        System.out.println(
                "Nama Penyewa : " + pelanggan.getNama()
        );

        System.out.println(
                "Jenis        : "
                + pelanggan.getJenisPelanggan()
        );

        System.out.println(
                "PS           : " + ps.getJenis()
        );

        System.out.println(
                "Lama Rental  : " + lama + " jam"
        );

        System.out.println(
                "Harga Awal   : Rp" + total
        );

        System.out.println(
                "Diskon       : Rp" + diskon
        );

        System.out.println(
                "Total Bayar  : Rp" + totalBayar
        );

        System.out.println("================================");

        System.out.println(
                "Rental berhasil!"
        );
    }
}