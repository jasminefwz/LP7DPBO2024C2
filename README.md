# LP7DPBO2024C2

## Janji
Saya Jasmine Noor Fawzia [2200598] mengerjakan soal LP7 dalam Mata Kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan Aamiin

## Desain Program
**1. App.java**

Kelas ini merupakan kelas utama yang digunakan untuk membuat frame utama permainan Flappy Bird. Di dalamnya terdapat:
- Pengaturan frame utama
- Button yang digunakan untuk memulai permainan
- Aksi saat tombol ditekan untuk membuat frame permainan Flappy Bird

**2. Player.java**

Kelas ini merepresentasikan pemain (burung) dalam permainan. Terdapat properti seperti posisi, lebar, tinggi, dan gambar burung. Metode yang disediakan adalah untuk mengatur dan mendapatkan properti pemain.

**3. Pipe.java**

Kelas ini merepresentasikan pipa dalam permainan. Properti yang dimiliki adalah posisi, lebar, tinggi, gambar, kecepatan, dan status apakah pipa sudah dilewati atau belum. Terdapat metode untuk mengatur dan mendapatkan properti pipa.

**4. FlappyBird.java**

Kelas ini bertanggung jawab untuk menggambar elemen-elemen permainan, seperti background, burung, dan pipa-pipa. Alur kerjanya meliputi:
- Pengaturan panel permainan dan propertinya
- Pengaturan gambar-gambar yang akan digunakan
- Inisialisasi pemain dan pipa-pipa
- Pengaturan timer untuk logika permainan dan interval penambahan pipa baru
- Pengaturan skor dan tampilannya
- Metode untuk memulai permainan
- Metode untuk menggambar elemen-elemen permainan
- Metode untuk menggerakkan elemen-elemen permainan
- Metode untuk menempatkan pipa-pipa baru
- Metode untuk menangani game over
- Metode untuk menangani aksi tombol keyboard

## Penjelasan Alur
- Saat program dijalankan, frame utama App.java akan muncul.
- Ketika tombol "Ya" ditekan, frame App.java akan disembunyikan dan frame permainan Flappy Bird akan muncul.
- Pada frame Flappy Bird, pemain dapat memulai permainan menggunakan tombol R atau SPACE.
- Permainan akan dimulai ketika tombol tersebut ditekan.
- Pemain dapat mengontrol burung menggunakan tombol SPACE, burung akan terus bergerak ke bawah karena adanya gaya gravitasi.
- Pemain harus menghindari tabrakan dengan pipa-pipa dengan mengontrol burung untuk terbang di antara celah-celah pipa.
- Setiap kali burung melewati pipa, skor akan bertambah.
- Jika burung menabrak pipa atau batas atas/bawah layar, permainan akan berakhir dan skor akan ditampilkan.
- Pemain dapat memulai kembali permainan dengan menekan tombol R atau SPACE setelah permainan berakhir.

## Dokumentasi saat Program Dijalankan
1. Gui form untuk tampilan awal

![gui form](https://github.com/jasminefwz/LP7DPBO2024C2/assets/147362810/bbc5b20a-550f-4c82-a6e4-887772ee8df3)

2. Start game

![start game](https://github.com/jasminefwz/LP7DPBO2024C2/assets/147362810/2f051e6b-bf1b-4aed-93f4-ccbc8221b65c)

3. Score dan game over

![score dan game over](https://github.com/jasminefwz/LP7DPBO2024C2/assets/147362810/2b5ad1ec-27d3-4d0b-93c7-269556b78bac)

4. Restart game setelah game over 

![restart game](https://github.com/jasminefwz/LP7DPBO2024C2/assets/147362810/750cf0cf-d027-4326-8ebe-6ab03c5ce201)
