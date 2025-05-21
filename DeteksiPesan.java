package ExceptionHandling;

import java.util.Scanner;

//class exception khusus untuk menangani kata terlarang
class KataTerlarangException extends Exception {
    public KataTerlarangException(String pesan) {
        super(pesan); //memanggil constructor dari kelas exception
    }
}

public class DeteksiPesan {

    //method untuk memeriksa apakah pesan mengandung kata terlarang
    public static void periksaPesan(String pesan) throws KataTerlarangException {
        //daftar kata terlarang
        String[] kataTerlarang = {"bodoh", "jelek"};

        //cek setiap kata dalam daftar
        for (String kata : kataTerlarang) {
            //jika pesan mengandung kata terlarang (tanpa memperhatikan huruf besar kecil)
            if (pesan.toLowerCase().contains(kata)) {
                //throw exception jika ditemukan kata terlarang
                throw new KataTerlarangException("Pesan mengandung kata terlarang: \"" + kata + "\"");
            }
        }
    }

    public static void main(String[] args) {
        //scanner untuk mengambil input dari pengguna
        Scanner input = new Scanner(System.in);

        System.out.print("Ketik pesan Anda: ");
        String pesanPengguna = input.nextLine(); //mengambil input dari user

        try {
            periksaPesan(pesanPengguna); //memeriksa apakah ada kata terlarang
            System.out.println("Pesan berhasil dikirim: " + pesanPengguna); //jika aman, kirim pesan
        } catch (KataTerlarangException e) {
            //catch exception jika ada kata terlarang
            System.out.println("Pesan gagal dikirim.");
            System.out.println("Alasan: " + e.getMessage()); //menampilkan pesan kesalahan
        }
    }
}
