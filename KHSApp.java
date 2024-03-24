/*
 * Adrian Ibrahim Putra Wirahmat
 * 235150407111005
 * SI - A
 * 
 */


package Pemlan3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    List<MataKuliah> mataKuliahList;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.mataKuliahList = new ArrayList<>();
    }

    public void tambahMataKuliah(MataKuliah mataKuliah) {
        mataKuliahList.add(mataKuliah);
    }
}

class MataKuliah {
    String kodeMK;
    String namaMK;
    int nilaiAngka;

    public MataKuliah(String kodeMK, String namaMK, int nilaiAngka) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.nilaiAngka = nilaiAngka;
    }

    public String konversiNilaiABCD() {
        if (nilaiAngka >= 80 && nilaiAngka <= 100) {
            return "A";
        } else if (nilaiAngka >= 60 && nilaiAngka < 80) {
            return "B";
        } else if (nilaiAngka >= 50 && nilaiAngka < 60) {
            return "C";
        } else if (nilaiAngka >= 40 && nilaiAngka < 50) {
            return "D";        
        } else {
            return "E (Tidak Lulus)";
        }
    }
}

public class KHSApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();

        Mahasiswa mahasiswa = new Mahasiswa(nim, nama);

        boolean validator = true;
        while (validator) {
            System.out.print("Masukkan Kode Mata Kuliah: ");
            String kodeMK = scanner.nextLine();
            System.out.print("Masukkan Nama Mata Kuliah: ");
            String namaMK = scanner.nextLine();
            System.out.print("Masukkan Nilai Angka: ");
            int nilaiAngka = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            MataKuliah mataKuliah = new MataKuliah(kodeMK, namaMK, nilaiAngka);
            mahasiswa.tambahMataKuliah(mataKuliah);

            System.out.print("Apakah ingin memasukkan mata kuliah lagi? (y/n): ");
            String jawaban = scanner.nextLine();
            if (!jawaban.equalsIgnoreCase("y")) {
                validator = false;
            }
        }

        // Cetak KHS
        System.out.println("\nKartu Hasil Studi (KHS) Mahasiswa");
        System.out.println("NIM: " + mahasiswa.nim);
        System.out.println("Nama: " + mahasiswa.nama);
        for (MataKuliah mataKuliah : mahasiswa.mataKuliahList) {
            System.out.println("Mata Kuliah: " + mataKuliah.kodeMK + " - " + mataKuliah.namaMK + " - Nilai: "+ mataKuliah.konversiNilaiABCD());
        }

        scanner.close();
    }
}