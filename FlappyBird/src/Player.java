/*
Saya Jasmine Noor Fawzia [2200598] mengerjakan soal LP7 dalam Mata Kuliah DPBO
untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan
Aamiin
*/

import java.awt.*;

public class Player {
    private int posX; //variabel untuk menyimpan posisi X objek
    private int posY; //variabel untuk menyimpan posisi Y objek
    private int width; //variabel untuk menyimpan lebar objek
    private int height; //variabel untuk menyimpan tinggi objek
    private Image image; //variabel untuk menyimpan gambar objek
    private int velocityY; //variabel untuk menyimpan kecepatan objek di sumbu Y

    public Player(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;
        this.velocityY = -30;
    }

    //set atribut
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    //get atribut
    public int getPosX() {
        return this.posX;
    }
    public int getPosY() {
        return this.posY;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public Image getImage() {
        return this.image;
    }
    public int getVelocityY() {
        return velocityY;
    }
}