package service;

import java.util.ArrayList;
import model.PS;

public class PSService {

    private ArrayList<PS> daftarPS = new ArrayList<>();
    
    public PSService() {

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
}

    public void tambahPS(PS ps) {

        if (cariPS(ps.getId()) != null) {
            throw new IllegalArgumentException(
                    "ID PS sudah digunakan."
            );
        }

        daftarPS.add(ps);
    }

    public void tampilkanPS() {

        if (daftarPS.isEmpty()) {
            System.out.println("Belum ada data PS.");
            return;
        }

        System.out.println("\n--- DAFTAR PS ---");

        for (PS ps : daftarPS) {
            System.out.println("-------------------");
            System.out.println("ID      : " + ps.getId());
            System.out.println("Jenis   : " + ps.getJenis());
            System.out.println("Harga   : Rp" + ps.getHarga());
        }
    }

    public boolean ubahPS(String id, String jenis, int harga) {

        PS ps = cariPS(id);

        if (ps == null) {
            return false;
        }

        ps.setJenis(jenis);
        ps.setHarga(harga);

        return true;
    }

    public boolean hapusPS(String id) {

        PS ps = cariPS(id);

        if (ps == null) {
            return false;
        }

        daftarPS.remove(ps);

        return true;
    }

    public PS cariPS(String id) {

        for (PS ps : daftarPS) {

            if (ps.getId().equalsIgnoreCase(id)) {
                return ps;
            }
        }

        return null;
    }
}
