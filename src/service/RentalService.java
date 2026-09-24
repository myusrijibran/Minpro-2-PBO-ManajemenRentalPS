package service;

import java.util.ArrayList;
import model.PS;
import model.Pelanggan;
import model.Rental;

public class RentalService {

    public int jumlahRental() {
    return daftarRental.size();
}
    private ArrayList<Rental> daftarRental = new ArrayList<>();

    public void tambahRental(Rental rental) {
        daftarRental.add(rental);
    }

    public void tampilkanRental(
            PelangganService pelangganService,
            PSService psService) {

        if (daftarRental.isEmpty()) {
            System.out.println("Belum ada transaksi rental.");
            return;
        }

        System.out.println("\n--- DAFTAR RENTAL ---");

        for (Rental rental : daftarRental) {

            Pelanggan pelanggan =
                    pelangganService.cariPelanggan(
                            rental.getIdPelanggan()
                    );

            PS ps =
                    psService.cariPS(
                            rental.getIdPS()
                    );

            System.out.println("----------------------------");

            System.out.println(
                    "ID Rental     : "
                    + rental.getIdRental()
            );

            if (pelanggan != null) {

                System.out.println(
                        "ID Pelanggan  : "
                        + pelanggan.getIdPelanggan()
                );

                System.out.println(
                        "Nama Penyewa  : "
                        + pelanggan.getNama()
                );

                System.out.println(
                        "No. Telepon   : "
                        + pelanggan.getNoTelepon()
                );
            }

            if (ps != null) {

                System.out.println(
                        "ID PS         : "
                        + ps.getId()
                );

                System.out.println(
                        "Jenis PS      : "
                        + ps.getJenis()
                );

                System.out.println(
                        "Harga/Jam     : Rp"
                        + ps.getHarga()
                );
            }

            System.out.println(
                    "Lama Rental   : "
                    + rental.getLamaRental()
                    + " jam"
            );

            System.out.println(
                    "Total Harga   : Rp"
                    + rental.getTotalHarga()
            );
        }
    }
}
