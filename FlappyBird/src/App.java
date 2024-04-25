/*
Saya Jasmine Noor Fawzia [2200598] mengerjakan soal LP7 dalam Mata Kuliah DPBO
untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan
Aamiin
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    public static void main(String[] args) {
        //membuat instance dari kelas App
        App window = new App();
        window.setSize(360, 360);
        //menetapkan panel ke konten utama frame
        window.setContentPane(window.panel);
        //menempatkan frame di tengah layar
        window.setLocationRelativeTo(null);
        //menampilkan frame
        window.setVisible(true);
    }

    private JPanel panel;
    private JButton button;
    private JLabel label;

    public App() {
        //mengatur judul frame
        setTitle("Flappy Bird");

        //menambahkan aksi pada tombol
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ketika tombol ditekan, buat dan tampilkan frame FlappyBird
                // Membuat instance dari JFrame untuk frame FlappyBird
                JFrame frame = new JFrame("Flappy Bird");
                //menetapkan operasi penutupan default menjadi keluar aplikasi
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //mengatur ukuran frame FlappyBird
                frame.setSize(360, 640);
                //menempatkan frame di tengah layar
                frame.setLocationRelativeTo(null);
                //mengatur frame agar tidak dapat diubah ukurannya
                frame.setResizable(false);

                //buat objek JPanel
                FlappyBird flappyBird = new FlappyBird();
                //menambahkan JPanel FlappyBird ke dalam frame
                frame.add(flappyBird);
                //mengatur ukuran frame sesuai dengan konten
                frame.pack();
                //mengarahkan fokus ke JPanel FlappyBird
                flappyBird.requestFocus();
                //menampilkan frame FlappyBird
                frame.setVisible(true);

                //menutup frame App (frame menu utama)
                setVisible(false);
            }
        });
    }
}