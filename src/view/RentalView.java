package view;

import java.util.Scanner;

public class RentalView {

    private Scanner input;

    public RentalView(Scanner input) {
        this.input = input;
    }

    public void tampilkanMenu() {

        System.out.println("\n=================================");
        System.out.println("   SISTEM MANAJEMEN RENTAL PS");
        System.out.println("=================================");
        System.out.println("1. Tambah PS");
        System.out.println("2. Tampilkan PS");
        System.out.println("3. Ubah PS");
        System.out.println("4. Hapus PS");
        System.out.println("5. Tambah Pelanggan");
        System.out.println("6. Tampilkan Pelanggan");
        System.out.println("7. Rental PS");
        System.out.println("8. Tampilkan Rental");
        System.out.println("9. Keluar");
        System.out.println("=================================");
    }

    public int inputPilihan() {

        while (true) {

            System.out.print("Pilih menu: ");

            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    public String inputString(String pesan) {

        while (true) {

            System.out.print(pesan);
            String nilai = input.nextLine().trim();

            if (!nilai.isEmpty()) {
                return nilai;
            }

            System.out.println(
                    "Input tidak boleh kosong."
            );
        }
    }

    public int inputAngka(String pesan) {

        while (true) {

            System.out.print(pesan);

            try {

                int nilai = Integer.parseInt(
                        input.nextLine()
                );

                if (nilai <= 0) {
                    System.out.println(
                            "Angka harus lebih dari 0."
                    );
                    continue;
                }

                return nilai;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }

    public void tampilkanHeader(String judul) {
        System.out.println("\n--- " + judul + " ---");
    }
}
