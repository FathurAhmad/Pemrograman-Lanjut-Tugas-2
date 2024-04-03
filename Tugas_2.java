import java.util.Scanner;

apakah
class Kendaraan {
    private String nomorPlat;
    private int kapasitas;
    private int jumlahPenumpang;
    public boolean valid;
    public String jenisKendaraan;
    public int naik;
    public int turun;

    Kendaraan(String nomorPlat, int kapasitas) {
        this.nomorPlat = nomorPlat;
        this.kapasitas = kapasitas;
    }

    public String getNomorPlat() {
        return this.nomorPlat;
    }

    public void setKonfirmasi() {
        Scanner input = new Scanner(System.in);
        System.out.println("Penumpang melebihi batas, anda tetap melanjutkan ? (ya / tidak)");
        System.out.print("Jawaban Anda : ");
        String jawaban = input.next();
        if (jawaban.equalsIgnoreCase("ya")) {
            this.valid = true;
        }
    }

    public void setNaik(int naik) {
        if (naik + this.jumlahPenumpang <= this.kapasitas) {
            this.jumlahPenumpang += naik;
            this.naik = naik;
            if (this.jenisKendaraan.equalsIgnoreCase("Bus")) {
                getPembayaranBus(naik);
            }
            System.out.println("Penumpang Berhasil Naik");
        } else if (this.kapasitas == this.jumlahPenumpang) {
            System.out.println("Maaf, penumpang penuh");
        } else {
            setKonfirmasi();
            if (valid == true) {
                this.jumlahPenumpang += naik - ((naik + this.jumlahPenumpang) - this.kapasitas);
                this.naik = naik - ((naik + this.jumlahPenumpang) - this.kapasitas);
                if (this.jenisKendaraan.equalsIgnoreCase("Bus")) {
                    getPembayaranBus(naik);
                }
                System.out.println("Penumpang Berhasil Naik");
            }
        }
        getInfo();
    }
    public int getNaik() {
        return this.naik;
    }

    public void setTurun(int turun) {
        if (this.jumlahPenumpang - turun < 0) {
            System.out.println("Harap masukkan jumlah penumpang turun dengan tepat");
        } else {
            this.jumlahPenumpang -= turun;
            this.turun = turun;
        }
        getInfo();
    }

    public void getPembayaranBus(int naik) {
        Scanner input = new Scanner(System.in);
        while (true) {
            if (naik != getNaik()) {
                System.out.println("Masukkan Jumlah Penumpang dengan Benar");
                continue;
            } else {
                while (true) {
                    int total = getNaik() * 20000;
                    System.out.println("Total : Rp. " + total);
                    System.out.print("Masukkan Uang Anda : Rp. ");
                    int uang = input.nextInt();
                    if (uang < total) {
                        System.out.println("Maaf Uang Anda Tidak Cukup");
                        continue;
                    } else {
                        System.out.println("Pembayaran Berhasil \nSilahkan Naik");
                        if (uang - total > 0) {
                            System.out.println("Sisa Uang Anda : Rp. " + (uang - total));
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    public void infoDriver() {
        if (this.jenisKendaraan.equalsIgnoreCase("Mobil")) {
            Driver driver1 = new Driver("Wahyu", 10261225);
            driver1.getInfoDriver();
        }
        if (this.jenisKendaraan.equalsIgnoreCase("Bus")) {
            Driver driver2 = new Driver("Sumardi", 20130627);
            driver2.getInfoDriver();
        }
        if (this.jenisKendaraan.equalsIgnoreCase("Truk")) {
            Driver driver3 = new Driver("Yono", 30020525);
            driver3.getInfoDriver();
        }
    }

    public String getJenisKendaraan() {
        return this.jenisKendaraan;
    }

    public int getKapasitas() {
        return this.kapasitas;
    }

    public int getJumlahPenumpang() {
        return this.jumlahPenumpang;
    }

    public void getInfo() {
        System.out.println("====================");
        System.out.println("Jenis Kendaraan     : " + getJenisKendaraan());
        System.out.println("Nomor Plat          : " + getNomorPlat());
        if (this.jenisKendaraan.equalsIgnoreCase("Truk")) {
            System.out.println("Kapasitas Muatan    : " + getKapasitas() + " Kg");
        } else {
            System.out.println("Kapasitas Kendaraan : " + getKapasitas() + " orang");
            System.out.println("Jumlah penumpang    : " + getJumlahPenumpang());
        }
        System.out.println("====================");
    }

    public void main() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Cek Keterangan Kendaraan \n2. Cek Kapasitas Penumpang \n3. Penumpang Naik \n4. Penumpang Turun \n5. Cek Jumlah Penumpang \n6. Cek Nama Driver \n7. Keluar");
            System.out.print("Pilihan Anda : ");
            int a = input.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Jenis Kendaraan : " + getJenisKendaraan());
                    System.out.println("Nomor Plat      : " + getNomorPlat());
                    break;
                case 2:
                    System.out.println("Kapasitas Penumpang   : " + getKapasitas());
                    break;
                case 3:
                    System.out.print("Masukkan Jumlah Penumpang : ");
                    int b = input.nextInt();
                    setNaik(b);
                    break;
                case 4:
                    System.out.print("Masukkan Jumlah Penumpang : ");
                    b = input.nextInt();
                    setTurun(b);
                    break;
                case 5:
                    System.out.println("Jumlah Penumpang Saat Ini : " + getJumlahPenumpang());
                    break;
                case 6:
                    infoDriver();
                    break;
                default:
                    return;
            }
        }
    }
}

class Bus extends Kendaraan {
    Bus(String nomorPlat, int kapasitas) {
        super(nomorPlat, kapasitas);
        this.jenisKendaraan = "Bus";
    }
}

class Mobil extends Kendaraan {
    Mobil(String nomorPlat, int kapasitas) {
        super(nomorPlat, kapasitas);
        this.jenisKendaraan = "Mobil";
    }
}

class Truk extends Kendaraan {
    private int kapasitas = getKapasitas();
    private int muatan;
    private String nama;
    private int noSim;
    Driver driver = new Driver(this.nama, this.noSim);

    Truk(String nomorPlat, int kapasitasMuatan) {
        super(nomorPlat, kapasitasMuatan);
        this.jenisKendaraan = "Truk";
    }

    public void main() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Cek Keterangan Kendaraan \n2. Cek Muatan \n3. Driver Naik \n4. Cek Nama Driver \n5. Menaikkan Muatan \n6. Menurunkan Muatan \n7. Keluar");
            System.out.print("Pilihan Anda : ");
            int opsi = input.nextInt();
            switch (opsi) {
                case 1:
                    getInfo();
                    break;
                case 2:
                    System.out.println("Berat Muatan Saat Ini : " + this.muatan + " Kg");
                    break;
                case 3:
                    System.out.print("Masukkan Nama Driver : ");
                    String nama = input.next();
                    System.out.print("Masukkan Nomor SIM   : ");
                    int noSim = input.nextInt();
                    setNama(nama, noSim);
                    break;
                case 4:
                    getInfoDriver();
                    break;
                case 5:
                    System.out.print("Masukkan Berat Muatan : ");
                    int a = input.nextInt();
                    setNaik(a);
                    break;
                case 6:
                    System.out.println("Muatan Berhasil Diturunkan");
                    setTurun();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opsi Tidak Ada");
                    continue;
            }
        }
    }

    public void setNaik(int muatan) {
        if (muatan + this.muatan <= this.kapasitas) {
            this.muatan += muatan;
            this.muatan = muatan;
            System.out.println("Muatan Berhasil Dinaikkan");
        } else if (this.kapasitas == this.muatan) {
            System.out.println("Maaf, Muatan Penuh");
        } else {
            System.out.println("Maaf, Muatan Penuh");
        }
    }

    public void setTurun () {
        this.muatan = 0;
    }

    public void setNama(String nama, int noSim) {
        this.nama = nama;
        this.noSim = noSim;
    }

    void getInfoDriver() {
        System.out.println("Nama Driver : " + this.nama);
        System.out.println("Nomor SIM   : " + this.noSim);
    }
}

class Driver {
    private String nama;
    private int noSim;

    Driver(String nama, int noSim) {
        this.nama = nama;
        this.noSim = noSim;
    }

    public String getNamaDriver() {
        return this.nama;
    }

    public int getNoSim() {
        return this.noSim;
    }

    public void getInfoDriver() {
        System.out.println("Nama      : " + getNamaDriver());
        System.out.println("Nomor SIM : " + getNoSim());
    }
}

public class Tugas_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Masukkan jenis kendaraan : \n1. Mobil \n2. Bus \n3. Truk \n4. Keluar");
            System.out.print("Pilihan Anda : ");
            int jenisKendaraan = input.nextInt();
            input.nextLine();
            switch (jenisKendaraan) {
                case 1:
                    System.out.print("Masukkan Nomor Plat : ");
                    String nomorPlat = input.nextLine();
                    Mobil mobil1 = new Mobil(nomorPlat, (8 - 1));
                    mobil1.main();
                    break;
                case 2:
                    System.out.print("Masukkan Nomor Plat : ");
                    nomorPlat = input.nextLine();
                    Bus bus1 = new Bus(nomorPlat, (40 - 1));
                    bus1.main();
                    break;
                case 3:
                    System.out.print("Masukkan Nomor Plat : ");
                    nomorPlat = input.nextLine();
                    System.out.print("Masukkan Kapasitas Muatan (Kg) : ");
                    int kapasitas = input.nextInt();
                    Truk truk1 = new Truk(nomorPlat, kapasitas);
                    truk1.main();
                    break;
                case 4:
                    System.out.println("Anda Keluar, Terimakasih");
                    System.exit(0);
                default:
                    System.out.println("Kendaraan tidak ditemukan");
                    continue;
            }
        }
    }
}
