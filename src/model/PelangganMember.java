package model;

public class PelangganMember extends Pelanggan {

    public PelangganMember(
            String idPelanggan,
            String nama,
            String noTelepon) {

        super(idPelanggan, nama, noTelepon);
    }

    @Override
    public String getJenisPelanggan() {
        return "Member";
    }

    @Override
    public int hitungDiskon(int total) {
        return total * 10 / 100;
    }
}
