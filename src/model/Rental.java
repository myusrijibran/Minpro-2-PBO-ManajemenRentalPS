package model;

public class Rental {
    private String idRental;
    private String idPelanggan;
    private String idPS;
    private int lamaRental;
    private int totalHarga;

    public Rental(String idRental, String idPelanggan, String idPS,
                  int lamaRental, int totalHarga) {

        setIdRental(idRental);
        setIdPelanggan(idPelanggan);
        setIdPS(idPS);
        setLamaRental(lamaRental);
        setTotalHarga(totalHarga);
    }

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

    public void setIdRental(String idRental) {
        if (idRental == null || idRental.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ID rental tidak boleh kosong."
            );
        }

        this.idRental = idRental;
    }

    public void setIdPelanggan(String idPelanggan) {
        if (idPelanggan == null || idPelanggan.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "ID pelanggan tidak boleh kosong."
            );
        }

        this.idPelanggan = idPelanggan;
    }

    public void setIdPS(String idPS) {
        if (idPS == null || idPS.trim().isEmpty()) {
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
        if (totalHarga <= 0) {
            throw new IllegalArgumentException(
                    "Total harga harus lebih dari 0."
            );
        }

        this.totalHarga = totalHarga;
    }
}
