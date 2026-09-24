package model;

public class PelangganReguler extends Pelanggan {

    public PelangganReguler(
            String idPelanggan,
            String nama,
            String noTelepon) {

        super(idPelanggan, nama, noTelepon);
    }

    @Override
    public String getJenisPelanggan() {
        return "Reguler";
    }

    @Override
    public int hitungDiskon(int total) {
        return 0;
    }
}