# Sistem Manajemen Rental PS

## Deskripsi Singkat Program

Sistem Manajemen Rental PS merupakan program berbasis Java yang digunakan untuk mengelola data PlayStation (PS), pelanggan, dan transaksi rental.

Program ini dibuat untuk menerapkan konsep Pemrograman Berorientasi Objek (PBO), seperti encapsulation, inheritance, polymorphism, access modifier, getter dan setter, serta validasi input.

Fitur utama program:
1. Menambahkan data PS
2. Menampilkan data PS
3. Mengubah data PS
4. Menghapus data PS
5. Menambahkan data pelanggan
6. Menampilkan data pelanggan
7. Melakukan transaksi rental PS
8. Menampilkan data transaksi rental

## Alur Program

1. Program dijalankan melalui Main.java.
2. Program membuat objek Service dan View.
3. RentalController mengatur jalannya program dan menu.
4. Pengguna memilih menu yang tersedia.
5. Data yang dimasukkan pengguna diproses oleh Controller.
6. Data PS dan pelanggan dikelola melalui Service.
7. Data transaksi rental disimpan dalam ArrayList.
8. Saat melakukan rental, program mencari data pelanggan berdasarkan ID pelanggan.
9. Program mencari data PS berdasarkan ID PS.
10. Program menghitung total harga berdasarkan harga PS dan lama rental.
11. Jika pelanggan merupakan Member, program memberikan diskon 10 persen.
12. Data transaksi rental disimpan dan dapat ditampilkan kembali.
13. Program berjalan sampai pengguna memilih menu Keluar.

## Penerapan Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier private pada atribut setiap class.

Contoh pada class PS:

```java
private String id;
private String jenis;
private int harga;

Atribut tersebut tidak dapat diakses secara langsung dari luar class. Untuk mengakses dan mengubah data digunakan getter dan setter.

Contoh getter:

public String getId() {
    return id;
}

Contoh setter:

public void setId(String id) {
    if (id == null || id.trim().isEmpty()) {
        throw new IllegalArgumentException(
            "ID PS tidak boleh kosong."
        );
    }

    this.id = id;
}

Getter digunakan untuk mengambil nilai atribut, sedangkan setter digunakan untuk mengubah nilai atribut sekaligus melakukan validasi.

Encapsulation diterapkan pada class PS, Pelanggan, PelangganReguler, PelangganMember, dan Rental.

Penerapan Inheritance

Inheritance diterapkan pada class Pelanggan sebagai superclass dan dua subclass, yaitu PelangganReguler dan PelangganMember.

Struktur inheritance:

Pelanggan
PelangganReguler
PelangganMember

Class PelangganReguler dan PelangganMember mewarisi atribut dan method dari class Pelanggan.

Contoh:

class PelangganMember extends Pelanggan {

    public PelangganMember(
            String idPelanggan,
            String nama,
            String noTelepon) {

        super(idPelanggan, nama, noTelepon);
    }
}

Dengan inheritance, subclass dapat menggunakan atribut dan method yang dimiliki oleh superclass.

Penerapan Polymorphism

Polymorphism diterapkan melalui method overriding pada class PelangganReguler dan PelangganMember.

Method yang dioverride adalah getJenisPelanggan dan hitungDiskon.

Pada pelanggan Reguler:

@Override
public int hitungDiskon(int total) {
    return 0;
}

Pada pelanggan Member:

@Override
public int hitungDiskon(int total) {
    return total * 10 / 100;
}

Dengan polymorphism, program dapat memberikan perilaku yang berbeda berdasarkan jenis pelanggan.

Pelanggan Reguler tidak mendapatkan diskon, sedangkan pelanggan Member mendapatkan diskon sebesar 10 persen.

Penerapan Validasi Input

Validasi input digunakan untuk memastikan data yang dimasukkan pengguna sesuai dengan ketentuan program.

Validasi diterapkan pada input String, input angka, setter, ID PS, ID pelanggan, nomor telepon, harga PS, dan lama rental.

Validasi yang diterapkan antara lain:

ID tidak boleh kosong.
Nama tidak boleh kosong.
Nomor telepon hanya boleh berisi angka.
Harga harus lebih dari 0.
Lama rental harus lebih dari 0.
ID PS tidak boleh sama.
ID pelanggan tidak boleh sama.
Input angka yang salah akan ditolak oleh program.
Penerapan Access Modifier

Program menggunakan access modifier private pada atribut class untuk melindungi data agar tidak dapat diakses secara langsung dari luar class.

Contoh:

private String id;
private String jenis;
private int harga;

Akses terhadap atribut dilakukan menggunakan getter dan setter.

Method tertentu pada Controller juga menggunakan access modifier private, seperti tambahPS, ubahPS, hapusPS, tambahPelanggan, dan rentalPS.

Penerapan MVC

Program menerapkan struktur MVC sebagai nilai tambah.

Struktur package yang digunakan:

Source Packages

app
Main.java

controller
RentalController.java

model
PS.java
Pelanggan.java
PelangganReguler.java
PelangganMember.java
Rental.java

service
PSService.java
PelangganService.java
RentalService.java

view
RentalView.java

Penjelasan package:

Model

Package model berisi class yang digunakan untuk merepresentasikan data program, yaitu PS, Pelanggan, PelangganReguler, PelangganMember, dan Rental.

View

Package view berisi RentalView.java yang digunakan untuk menangani tampilan menu dan input dari pengguna.

Controller

Package controller berisi RentalController.java yang mengatur alur program dan menghubungkan View dengan Service.

Service

Package service digunakan untuk mengelola data dan proses CRUD. Package ini terdiri dari PSService, PelangganService, dan RentalService.

App

Package app berisi Main.java yang menjadi titik awal program.

Dummy Data

Program menyediakan dummy data awal sehingga data dapat langsung ditampilkan ketika program dijalankan.

Data PS:

PS001, PS5, Rp10000 per jam
PS002, PS4, Rp7000 per jam

Data Pelanggan:

P001, Jibran, Reguler
P002, Andi, Member

Data Rental:

R001, P001, PS001, 2 jam, Rp20000

Dummy data disimpan dalam ArrayList.

Nilai Tambah yang Diterapkan

Program menerapkan beberapa nilai tambah, yaitu:

MVC
Program memisahkan Model, View, Controller, dan Service ke dalam package yang berbeda.
Polymorphism
Program menggunakan method overriding pada PelangganReguler dan PelangganMember.
Inheritance
Program menggunakan Pelanggan sebagai superclass dengan dua subclass, yaitu PelangganReguler dan PelangganMember.
Validasi Input
Program melakukan validasi terhadap data yang dimasukkan pengguna.
Dummy Data
Program menyediakan data awal sehingga fitur Read dapat langsung menampilkan data tanpa harus melakukan input terlebih dahulu.
