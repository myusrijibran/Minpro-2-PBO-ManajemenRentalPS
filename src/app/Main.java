package app;

import java.util.ArrayList;
import java.util.Scanner;

// ======================================================
// CLASS PS
// ======================================================
class PS {

    private String id;
    private String jenis;
    private int harga;

    public PS(String id, String jenis, int harga) {
        setId(id);
        setJenis(jenis);
        setHarga(harga);
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    // Setter + Validasi
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ID PS tidak boleh kosong."
            );
        }

        this.id = id;
    }

    public void setJenis(String jenis) {
        if (jenis == null || jenis.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Jenis PS tidak boleh kosong."
            );
        }

        this.jenis = jenis;
    }

    public void setHarga(int harga) {
        if (harga <= 0) {
            throw new IllegalArgumentException(
                    "Harga harus lebih dari 0."
            );
        }

        this.harga = harga;
    }
}


// ======================================================
// SUPERCLASS PELANGGAN
// ======================================================
class Pelanggan {

    private String idPelanggan;
    private String nama;
    private String noTelepon;

    public Pelanggan(
            String idPelanggan,
            String nama,
            String noTelepon) {

        setIdPelanggan(idPelanggan);
        setNama(nama);
        setNoTelepon(noTelepon);
    }

    // Getter
    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    // Setter + Validasi
    public void setIdPelanggan(String idPelanggan) {

        if (idPelanggan == null
                || idPelanggan.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID pelanggan tidak boleh kosong."
            );
        }

        this.idPelanggan = idPelanggan;
    }

    public void setNama(String nama) {

        if (nama == null
                || nama.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Nama pelanggan tidak boleh kosong."
            );
        }

        this.nama = nama;
    }

    public void setNoTelepon(String noTelepon) {

        if (noTelepon == null
                || noTelepon.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Nomor telepon tidak boleh kosong."
            );
        }

        if (!noTelepon.matches("[0-9]+")) {

            throw new IllegalArgumentException(
                    "Nomor telepon hanya boleh berisi angka."
            );
        }

        this.noTelepon = noTelepon;
    }

    // Method untuk polymorphism
    public String getJenisPelanggan() {
        return "Pelanggan";
    }

    public int hitungDiskon(int total) {
        return 0;
    }
}


// ======================================================
// SUBCLASS PELANGGAN REGULER
// ======================================================
class PelangganReguler extends Pelanggan {

    public PelangganReguler(
            String idPelanggan,
            String nama,
            String noTelepon) {

        super(idPelanggan, nama, noTelepon);
    }

    // Method overriding
    @Override
    public String getJenisPelanggan() {
        return "Reguler";
    }

    @Override
    public int hitungDiskon(int total) {
        return 0;
    }
}


// ======================================================
// SUBCLASS PELANGGAN MEMBER
// ======================================================
class PelangganMember extends Pelanggan {

    public PelangganMember(
            String idPelanggan,
            String nama,
            String noTelepon) {

        super(idPelanggan, nama, noTelepon);
    }

    // Method overriding
    @Override
    public String getJenisPelanggan() {
        return "Member";
    }

    @Override
    public int hitungDiskon(int total) {
        return total * 10 / 100;
    }
}


// ======================================================
// CLASS RENTAL
// ======================================================
class Rental {

    private String idRental;
    private String idPelanggan;
    private String idPS;
    private int lamaRental;
    private int totalHarga;

    public Rental(
            String idRental,
            String idPelanggan,
            String idPS,
            int lamaRental,
            int totalHarga) {

        setIdRental(idRental);
        setIdPelanggan(idPelanggan);
        setIdPS(idPS);
        setLamaRental(lamaRental);
        setTotalHarga(totalHarga);
    }

    // Getter
    public String getIdRental() {
        return idRental;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getIdPS() {
        return idPS;
    }

    public int getLamaRental() {
        return lamaRental;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    // Setter + Validasi
    public void setIdRental(String idRental) {

        if (idRental == null
                || idRental.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID rental tidak boleh kosong."
            );
        }

        this.idRental = idRental;
    }

    public void setIdPelanggan(String idPelanggan) {

        if (idPelanggan == null
                || idPelanggan.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID pelanggan tidak boleh kosong."
            );
        }

        this.idPelanggan = idPelanggan;
    }

    public void setIdPS(String idPS) {

        if (idPS == null
                || idPS.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "ID PS tidak boleh kosong."
            );
        }

        this.idPS = idPS;
    }

    public void setLamaRental(int lamaRental) {

        if (lamaRental <= 0) {

            throw new IllegalArgumentException(
                    "Lama rental harus lebih dari 0 jam."
            );
        }

        this.lamaRental = lamaRental;
    }

    public void setTotalHarga(int totalHarga) {

        if (totalHarga < 0) {

            throw new IllegalArgumentException(
                    "Total harga tidak boleh negatif."
            );
        }

        this.totalHarga = totalHarga;
    }
}


// ======================================================
// MAIN PROGRAM
// ======================================================
public class Main {

    static Scanner input = new Scanner(System.in);

    // ArrayList
    static ArrayList<PS> daftarPS =
            new ArrayList<>();

    static ArrayList<Pelanggan> daftarPelanggan =
            new ArrayList<>();

    static ArrayList<Rental> daftarRental =
            new ArrayList<>();


    // ==================================================
    // MAIN
    // ==================================================
    public static void main(String[] args) {

        // ==========================
        // DUMMY DATA PS
        // ==========================

        daftarPS.add(
                new PS(
                        "PS001",
                        "PS5",
                        10000
                )
        );

        daftarPS.add(
                new PS(
                        "PS002",
                        "PS4",
                        7000
                )
        );


        // ==========================
        // DUMMY DATA PELANGGAN
        // ==========================

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


        // ==========================
        // DUMMY DATA RENTAL
        // ==========================

        daftarRental.add(
                new Rental(
                        "R001",
                        "P001",
                        "PS001",
                        2,
                        20000
                )
        );


        // Jalankan menu
        menuUtama();
    }


    // ==================================================
    // MENU UTAMA
    // ==================================================
    static void menuUtama() {

        while (true) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("       SISTEM MANAJEMEN RENTAL PS");
            System.out.println("======================================");
            System.out.println("1. Tambah PS");
            System.out.println("2. Tampilkan PS");
            System.out.println("3. Ubah PS");
            System.out.println("4. Hapus PS");
            System.out.println("5. Tambah Pelanggan");
            System.out.println("6. Tampilkan Pelanggan");
            System.out.println("7. Rental PS");
            System.out.println("8. Tampilkan Rental");
            System.out.println("9. Keluar");
            System.out.println("======================================");

            int pilihan =
                    inputAngka("Pilih menu: ");

            switch (pilihan) {

                case 1:
                    tambahPS();
                    break;

                case 2:
                    tampilkanPS();
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
                    tampilkanPelanggan();
                    break;

                case 7:
                    rentalPS();
                    break;

                case 8:
                    tampilkanRental();
                    break;

                case 9:
                    System.out.println();
                    System.out.println(
                            "Program selesai. Terima kasih!"
                    );
                    return;

                default:
                    System.out.println(
                            "Menu tidak tersedia."
                    );
            }
        }
    }


    // ==================================================
    // TAMBAH PS
    // ==================================================
    static void tambahPS() {

        System.out.println();
        System.out.println("--- TAMBAH PS ---");

        String id =
                inputString("ID PS     : ");

        // Cek ID duplikat
        if (cariPS(id) != null) {

            System.out.println(
                    "ID PS sudah digunakan."
            );

            return;
        }

        String jenis =
                inputString("Jenis PS  : ");

        int harga =
                inputAngka("Harga/Jam : Rp");

        try {

            PS ps =
                    new PS(
                            id,
                            jenis,
                            harga
                    );

            daftarPS.add(ps);

            System.out.println(
                    "PS berhasil ditambahkan."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Gagal: " + e.getMessage()
            );
        }
    }


    // ==================================================
    // TAMPILKAN PS
    // ==================================================
    static void tampilkanPS() {

        System.out.println();
        System.out.println("--- DAFTAR PS ---");

        if (daftarPS.isEmpty()) {

            System.out.println(
                    "Belum ada data PS."
            );

            return;
        }

        for (PS ps : daftarPS) {

            System.out.println(
                    "--------------------------"
            );

            System.out.println(
                    "ID     : " + ps.getId()
            );

            System.out.println(
                    "Jenis  : " + ps.getJenis()
            );

            System.out.println(
                    "Harga  : Rp" + ps.getHarga()
            );
        }
    }


    // ==================================================
    // UBAH PS
    // ==================================================
    static void ubahPS() {

        System.out.println();
        System.out.println("--- UBAH PS ---");

        String id =
                inputString("Masukkan ID PS: ");

        PS ps =
                cariPS(id);

        if (ps == null) {

            System.out.println(
                    "ID PS tidak ditemukan."
            );

            return;
        }

        String jenisBaru =
                inputString("Jenis PS baru : ");

        int hargaBaru =
                inputAngka("Harga baru     : Rp");

        try {

            ps.setJenis(jenisBaru);
            ps.setHarga(hargaBaru);

            System.out.println(
                    "Data PS berhasil diubah."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Gagal: " + e.getMessage()
            );
        }
    }


    // ==================================================
    // HAPUS PS
    // ==================================================
    static void hapusPS() {

        System.out.println();
        System.out.println("--- HAPUS PS ---");

        String id =
                inputString("Masukkan ID PS: ");

        PS ps =
                cariPS(id);

        if (ps == null) {

            System.out.println(
                    "ID PS tidak ditemukan."
            );

            return;
        }

        daftarPS.remove(ps);

        System.out.println(
                "Data PS berhasil dihapus."
        );
    }


    // ==================================================
    // TAMBAH PELANGGAN
    // ==================================================
    static void tambahPelanggan() {

        System.out.println();
        System.out.println(
                "--- TAMBAH PELANGGAN ---"
        );

        String id =
                inputString("ID Pelanggan : ");

        // Cek ID duplikat
        if (cariPelanggan(id) != null) {

            System.out.println(
                    "ID pelanggan sudah digunakan."
            );

            return;
        }

        String nama =
                inputString("Nama         : ");

        String noTelepon =
                inputString("No. Telepon  : ");

        System.out.println();
        System.out.println("Jenis Pelanggan");
        System.out.println("1. Reguler");
        System.out.println("2. Member");

        int jenis =
                inputAngka("Pilih jenis: ");

        try {

            Pelanggan pelanggan;

            if (jenis == 1) {

                pelanggan =
                        new PelangganReguler(
                                id,
                                nama,
                                noTelepon
                        );

            } else if (jenis == 2) {

                pelanggan =
                        new PelangganMember(
                                id,
                                nama,
                                noTelepon
                        );

            } else {

                System.out.println(
                        "Jenis pelanggan tidak tersedia."
                );

                return;
            }

            daftarPelanggan.add(
                    pelanggan
            );

            System.out.println(
                    "Pelanggan berhasil ditambahkan."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Gagal: " + e.getMessage()
            );
        }
    }


    // ==================================================
    // TAMPILKAN PELANGGAN
    // ==================================================
    static void tampilkanPelanggan() {

        System.out.println();
        System.out.println(
                "--- DAFTAR PELANGGAN ---"
        );

        if (daftarPelanggan.isEmpty()) {

            System.out.println(
                    "Belum ada data pelanggan."
            );

            return;
        }

        for (Pelanggan pelanggan :
                daftarPelanggan) {

            System.out.println(
                    "--------------------------"
            );

            System.out.println(
                    "ID          : "
                    + pelanggan.getIdPelanggan()
            );

            System.out.println(
                    "Nama        : "
                    + pelanggan.getNama()
            );

            System.out.println(
                    "No. Telepon : "
                    + pelanggan.getNoTelepon()
            );

            System.out.println(
                    "Jenis       : "
                    + pelanggan.getJenisPelanggan()
            );
        }
    }


    // ==================================================
    // RENTAL PS
    // ==================================================
    static void rentalPS() {

        System.out.println();
        System.out.println("--- RENTAL PS ---");

        // Cari pelanggan
        String idPelanggan =
                inputString(
                        "ID Pelanggan : "
                );

        Pelanggan pelanggan =
                cariPelanggan(idPelanggan);

        if (pelanggan == null) {

            System.out.println(
                    "Pelanggan tidak ditemukan."
            );

            return;
        }


        // Cari PS
        String idPS =
                inputString(
                        "ID PS        : "
                );

        PS ps =
                cariPS(idPS);

        if (ps == null) {

            System.out.println(
                    "PS tidak ditemukan."
            );

            return;
        }


        // Lama rental
        int lama =
                inputAngka(
                        "Lama rental (jam): "
                );


        // Hitung harga
        int total =
                ps.getHarga() * lama;


        // Hitung diskon
        int diskon =
                pelanggan.hitungDiskon(
                        total
                );


        // Total bayar
        int totalBayar =
                total - diskon;


        // Buat ID rental otomatis
        String idRental =
                "R00"
                + (daftarRental.size() + 1);


        // Buat objek rental
        Rental rental =
                new Rental(
                        idRental,
                        pelanggan.getIdPelanggan(),
                        ps.getId(),
                        lama,
                        totalBayar
                );


        // Simpan rental
        daftarRental.add(
                rental
        );


        // Tampilkan detail
        System.out.println();
        System.out.println(
                "================================"
        );
        System.out.println(
                "         DETAIL RENTAL"
        );
        System.out.println(
                "================================"
        );

        System.out.println(
                "ID Rental    : "
                + idRental
        );

        System.out.println(
                "Nama Penyewa : "
                + pelanggan.getNama()
        );

        System.out.println(
                "Jenis        : "
                + pelanggan.getJenisPelanggan()
        );

        System.out.println(
                "PS           : "
                + ps.getJenis()
        );

        System.out.println(
                "Lama Rental  : "
                + lama + " jam"
        );

        System.out.println(
                "Harga Awal   : Rp"
                + total
        );

        System.out.println(
                "Diskon       : Rp"
                + diskon
        );

        System.out.println(
                "Total Bayar  : Rp"
                + totalBayar
        );

        System.out.println(
                "================================"
        );

        System.out.println(
                "Rental berhasil!"
        );
    }


    // ==================================================
    // TAMPILKAN RENTAL
    // ==================================================
    static void tampilkanRental() {

        System.out.println();
        System.out.println(
                "--- DAFTAR RENTAL ---"
        );

        if (daftarRental.isEmpty()) {

            System.out.println(
                    "Belum ada transaksi rental."
            );

            return;
        }

        for (Rental rental :
                daftarRental) {

            Pelanggan pelanggan =
                    cariPelanggan(
                            rental.getIdPelanggan()
                    );

            PS ps =
                    cariPS(
                            rental.getIdPS()
                    );

            System.out.println(
                    "----------------------------"
            );

            System.out.println(
                    "ID Rental    : "
                    + rental.getIdRental()
            );


            if (pelanggan != null) {

                System.out.println(
                        "ID Pelanggan : "
                        + pelanggan.getIdPelanggan()
                );

                System.out.println(
                        "Nama Penyewa : "
                        + pelanggan.getNama()
                );

                System.out.println(
                        "Jenis        : "
                        + pelanggan.getJenisPelanggan()
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


    // ==================================================
    // CARI PS
    // ==================================================
    static PS cariPS(String id) {

        for (PS ps :
                daftarPS) {

            if (ps.getId()
                    .equalsIgnoreCase(id)) {

                return ps;
            }
        }

        return null;
    }


    // ==================================================
    // CARI PELANGGAN
    // ==================================================
    static Pelanggan cariPelanggan(
            String id) {

        for (Pelanggan pelanggan :
                daftarPelanggan) {

            if (pelanggan
                    .getIdPelanggan()
                    .equalsIgnoreCase(id)) {

                return pelanggan;
            }
        }

        return null;
    }


    // ==================================================
    // INPUT STRING
    // ==================================================
    static String inputString(
            String pesan) {

        while (true) {

            System.out.print(pesan);

            String nilai =
                    input.nextLine().trim();

            if (!nilai.isEmpty()) {

                return nilai;
            }

            System.out.println(
                    "Input tidak boleh kosong."
            );
        }
    }


    // ==================================================
    // INPUT ANGKA
    // ==================================================
    static int inputAngka(
            String pesan) {

        while (true) {

            System.out.print(pesan);

            try {

                int nilai =
                        Integer.parseInt(
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
}