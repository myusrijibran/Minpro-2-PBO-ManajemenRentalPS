package service;

import java.util.ArrayList;
import model.Pelanggan;
import model.PelangganMember;
import model.PelangganReguler;

public class PelangganService {

    private ArrayList<Pelanggan> daftarPelanggan =
            new ArrayList<>();

    public PelangganService() {

        // Dummy data awal
        daftarPelanggan.add(
                new PelangganReguler(
                        "P001",
                        "Jibran",
                        "08123456789"
                )
        );

        daftarPelanggan.add(
                new PelangganMember(
                        "P002",
                        "Andi",
                        "08123456788"
                )
        );
    }

    public void tambahPelanggan(Pelanggan pelanggan) {

        if (cariPelanggan(
                pelanggan.getIdPelanggan()) != null) {

            throw new IllegalArgumentException(
                    "ID pelanggan sudah digunakan."
            );
        }

        daftarPelanggan.add(pelanggan);
    }

    public void tampilkanPelanggan() {

        if (daftarPelanggan.isEmpty()) {
            System.out.println(
                    "Belum ada data pelanggan."
            );
            return;
        }

        System.out.println(
                "\n--- DAFTAR PELANGGAN ---"
        );

        for (Pelanggan pelanggan : daftarPelanggan) {

            System.out.println(
                    "-------------------------"
            );

            System.out.println(
                    "ID Pelanggan : "
                    + pelanggan.getIdPelanggan()
            );

            System.out.println(
                    "Nama         : "
                    + pelanggan.getNama()
            );

            System.out.println(
                    "No. Telepon  : "
                    + pelanggan.getNoTelepon()
            );

            System.out.println(
                    "Jenis        : "
                    + pelanggan.getJenisPelanggan()
            );
        }
    }

    public Pelanggan cariPelanggan(
            String idPelanggan) {

        for (Pelanggan pelanggan : daftarPelanggan) {

            if (pelanggan.getIdPelanggan()
                    .equalsIgnoreCase(idPelanggan)) {

                return pelanggan;
            }
        }

        return null;
    }
}