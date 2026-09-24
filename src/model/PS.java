package model;

public class PS {
    private String id;
    private String jenis;
    private int harga;

    public PS(String id, String jenis, int harga) {
        setId(id);
        setJenis(jenis);
        setHarga(harga);
    }

    public String getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID PS tidak boleh kosong.");
        }

        this.id = id;
    }

    public void setJenis(String jenis) {
        if (jenis == null || jenis.trim().isEmpty()) {
            throw new IllegalArgumentException("Jenis PS tidak boleh kosong.");
        }

        this.jenis = jenis;
    }

    public void setHarga(int harga) {
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0.");
        }

        this.harga = harga;
    }
}