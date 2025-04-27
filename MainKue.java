public class MainKue {
    public static void main(String[] args) {
        Kue[] daftarKue = new Kue[20];

        // Mengisi array dengan berbagai jenis kue
        daftarKue[0] = new KuePesanan("Kue Lapis", 15000, 2);
        daftarKue[1] = new KueJadi("Kue Nastar", 5000, 3);
        // Lanjutkan isi hingga 20
        for (int i = 2; i < daftarKue.length; i++) {
            if (i % 2 == 0) {
                daftarKue[i] = new KuePesanan("Kue Brownies " + i, 20000, i);
            } else {
                daftarKue[i] = new KueJadi("Kue Putri Salju " + i, 8000, i);
            }
        }

        double totalHarga = 0;
        double totalHargaPesanan = 0, totalBeratPesanan = 0;
        double totalHargaJadi = 0, totalJumlahJadi = 0;
        double hargaTerbesar = 0;
        Kue kueTermahal = null;

        // a. Tampilkan semua kue
        System.out.println("Daftar Kue:");
        for (Kue kue : daftarKue) {
            System.out.println(kue);
        }

        // b. Total harga semua kue
        for (Kue kue : daftarKue) {
            totalHarga += kue.hitungHarga();

            // Polimorfisme: object Kue bisa menunjuk ke subclass-nya
            if (kue instanceof KuePesanan) {
                // c. Total harga dan berat KuePesanan
                totalHargaPesanan += kue.hitungHarga();
                totalBeratPesanan += ((KuePesanan) kue).getBerat();
            } else if (kue instanceof KueJadi) {
                // d. Total harga dan jumlah KueJadi
                totalHargaJadi += kue.hitungHarga();
                totalJumlahJadi += ((KueJadi) kue).getJumlah();
            }

            // e. Cari kue dengan harga akhir terbesar
            if (kue.hitungHarga() > hargaTerbesar) {
                hargaTerbesar = kue.hitungHarga();
                kueTermahal = kue;
            }
        }

        System.out.println("\nTotal Harga Semua Kue: " + totalHarga);
        System.out.println("Total Harga KuePesanan: " + totalHargaPesanan);
        System.out.println("Total Berat KuePesanan: " + totalBeratPesanan);
        System.out.println("Total Harga KueJadi: " + totalHargaJadi);
        System.out.println("Total Jumlah KueJadi: " + totalJumlahJadi);
        System.out.println("\nKue dengan Harga Terbesar: " + kueTermahal);
    }
}
