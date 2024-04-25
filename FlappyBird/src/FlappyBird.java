/*
Saya Jasmine Noor Fawzia [2200598] mengerjakan soal LP7 dalam Mata Kuliah DPBO
untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan
Aamiin
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    //frame attributes
    int frameWidth = 360;
    int frameHeight = 640;

    //image attributes
    Image backgroundImage;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;

    //player attributes
    int playerStartPosX = frameWidth / 8;  //posisi awal X pemain
    int playerStartPosY = frameHeight / 2; //posisi awal Y pemain
    int playerWidth = 34;
    int playerHeight = 24;
    Player player; //objek pemain

    //pipes attributes
    int pipeStartPosX = frameWidth;
    int pipeStartPosY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;
    ArrayList<Pipe> pipes; //arrayList untuk menyimpan pipa-pipa

    //game logic
    Timer gameLoop; //timer untuk logika permainan
    Timer pipesCooldown; //timer untuk interval penambahan pipa
    int gravity = 1; //gravitasi permainan

    //score
    int score = 0; //skor permainan
    JLabel scoreLabel; // label untuk menampilkan skor

    //game state
    boolean gameStarted = false; //status permainan (apakah sudah dimulai atau belum)

    //constructor
    public FlappyBird() {
        setPreferredSize(new Dimension(frameWidth, frameHeight)); //menetapkan ukuran panel
        setFocusable(true); //mengatur panel untuk dapat menerima fokus keyboard
        addKeyListener(this); //menambahkan key listener ke panel

        //load images
        backgroundImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();

        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage); //membuat objek pemain
        pipes = new ArrayList<Pipe>(); //membuat ArrayList untuk menyimpan pipa-pipa

        //timer untuk penambahan pipa baru
        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pipa");
                placePipes(); //menempatkan pipa-pipa baru
            }
        });
        pipesCooldown.start(); //memulai timer

        //timer untuk logika permainan
        gameLoop = new Timer(1000/60, this); //timer dengan interval 1/60 detik (60 FPS)
        gameLoop.start(); //memulai timer

        //inisialisasi scoreLabel
        scoreLabel = new JLabel("Score: 0"); //membuat label skor dengan nilai awal 0
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(10, 10, 100, 20); //atur posisi dan ukuran label
        add(scoreLabel); //menambahkan label ke panel
    }

    //untuk start game
    public void startGame() {
        gameStarted = true; //mengatur status permainan menjadi dimulai
        score = 0; //mengatur skor awal menjadi 0
        pipes.clear(); //menghapus semua pipa dari ArrayList

        //tempatkan Flappy Bird di tengah layar saat permainan dimulai
        player.setPosY(frameHeight / 2);

        //berhenti pergerakan Flappy Bird
        player.setVelocityY(0);

        //reset tampilan skor menjadi 0
        scoreLabel.setText("Score: 0");

        //memulai timer untuk logika permainan dan interval penambahan pipa
        gameLoop.start();
        pipesCooldown.start();
    }

    //metode untuk menggambar komponen
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //memanggil metode paintComponent dari kelas JPanel
        draw(g); //memanggil metode draw untuk menggambar elemen-elemen permainan
    }

    //metode untuk menggambar elemen-elemen permainan
    public void draw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, null); // Menggambar background

        g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null); //menggambar burung

        //menggambar pipa-pipa
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
        }

        //menggambar pesan "Press R or SPACE to Start atau Restart" jika permainan belum dimulai
        if (!gameStarted) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            String message = "Press R or SPACE to " + (score == 0 ? "Start" : "Restart");
            g.drawString(message, (frameWidth - g.getFontMetrics().stringWidth(message)) / 2, frameHeight / 2); //menggambar pesan di tengah layar
        }
    }

    //metode untuk menggerakkan elemen-elemen permainan
    public void move() {
        //jika permainan belum dimulai, keluar dari metode
        if (!gameStarted) return;

        player.setVelocityY(player.getVelocityY() + gravity); //mengatur gravitasi pada pemain
        player.setPosY(player.getPosY() + player.getVelocityY()); //menggerakkan pemain berdasarkan kecepatannya
        player.setPosY(Math.max(player.getPosY(), 0)); //memastikan pemain tidak bergerak di luar batas atas layar

        //memeriksa tabrakan dengan pipa-pipa
        for (int i = 0; i < pipes.size(); i += 2) {
            Pipe upperPipe = pipes.get(i);
            Pipe lowerPipe = pipes.get(i + 1);

            //memindahkan posisi pipa-pipa
            upperPipe.setPosX(upperPipe.getPosX() + upperPipe.getVelocityX());
            lowerPipe.setPosX(lowerPipe.getPosX() + lowerPipe.getVelocityX());

            //memeriksa tabrakan dengan pipa-pipa
            if (player.getPosX() + player.getWidth() > upperPipe.getPosX() &&
                    player.getPosX() < upperPipe.getPosX() + upperPipe.getWidth() &&
                    (player.getPosY() < upperPipe.getPosY() + upperPipe.getHeight() ||
                            player.getPosY() + player.getHeight() > lowerPipe.getPosY())) {
                gameOver(); //memanggil metode gameOver() jika terjadi tabrakan
                return;
            }
        }

        //memeriksa jika pemain menabrak batas atas atau batas bawah layar
        if (player.getPosY() <= 0 || player.getPosY() + player.getHeight() >= frameHeight) {
            gameOver(); //memanggil metode gameOver() jika terjadi tabrakan
            return;
        }

        //memeriksa jika pemain berhasil melewati pipa
        for (int i = 0; i < pipes.size(); i += 2) {
            Pipe upperPipe = pipes.get(i);

            if (upperPipe.getPosX() + upperPipe.getWidth() < player.getPosX() && !upperPipe.getPassed()) {
                upperPipe.setPassed(true); //menandai pipa sebagai sudah dilewati
                score++; //menambah score
                scoreLabel.setText("Score: " + score); //memperbarui label score
            }
        }
    }

    //metode untuk menempatkan pipa-pipa baru
    public void placePipes() {
        if (!gameStarted) return; //jika permainan belum dimulai, keluar dari metode

        int randomPosY = (int) (pipeStartPosY - pipeHeight/4 - Math.random() * (pipeHeight/2)); //menentukan posisi Y pipa secara acak
        int openingSpace = frameHeight/4; //ruang antara pipa atas dan pipa bawah

        //membuat pipa atas
        Pipe upperPipe = new Pipe(pipeStartPosX, randomPosY, pipeWidth, pipeHeight, upperPipeImage);
        pipes.add(upperPipe); //menambahkan pipa atas ke ArrayList

        //membuat pipa bawah
        Pipe lowerPipe = new Pipe(pipeStartPosX, (randomPosY + openingSpace + pipeHeight), pipeWidth, pipeHeight, lowerPipeImage);
        pipes.add(lowerPipe); //menambahkan pipa bawah ke ArrayList
    }

    //metode untuk menangani game over
    private void gameOver() {
        gameStarted = false; //mengatur status permainan menjadi tidak dimulai
        gameLoop.stop(); //hentikan permainan
        pipesCooldown.stop(); //hentikan penambahan pipa baru
        JOptionPane.showMessageDialog(this, "Game Over!\nScore: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE); //menampilkan dialog Game Over dengan skor
    }

    //metode yang dipanggil oleh Timer untuk menggerakkan elemen-elemen permainan
    @Override
    public void actionPerformed(ActionEvent e) {
        move(); //memanggil metode move() untuk menggerakkan elemen-elemen permainan
        repaint(); //memanggil metode repaint() untuk menggambar ulang panel
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //metode untuk menangani event key pressed
    @Override
    public void keyPressed(KeyEvent e) {
        //tombol space untuk mulai dan restart permainan
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!gameStarted) {
                startGame(); //memanggil metode startGame() jika permainan belum dimulai
            } else {
                player.setVelocityY(-10); //menggerakkan pemain ke atas
            }
        }
        //tombol R untuk mulai dan restart permainan
        else if (e.getKeyCode() == KeyEvent.VK_R && !gameStarted) {
            startGame(); //memanggil metode startGame() jika permainan belum dimulai
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}