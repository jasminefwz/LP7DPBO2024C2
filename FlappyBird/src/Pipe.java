/*
Saya Jasmine Noor Fawzia [2200598] mengerjakan soal LP7 dalam Mata Kuliah DPBO
untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan
Aamiin
*/

import java.awt.*;

public class Pipe {
    private int posX; //variabel untuk menyimpan posisi X objek
    private int posY; //variabel untuk menyimpan posisi Y objek
    private int width; //variabel untuk menyimpan lebar objek
    private int height; //variabel untuk menyimpan tinggi objek
    private Image image; //variabel untuk menyimpan gambar objek
    private int velocityX; //variabel untuk menyimpan kecepatan objek di sumbu X
    private boolean passed; //variabel untuk menandai apakah objek telah "dilewati" oleh pemain

    //constructor
    public Pipe(int posX, int posY, int width, int height, Image image) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.image = image;

        this.velocityX = -3;
        this.passed = false;
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
    public void setVelocityY(int velocityX) {
        this.velocityX = velocityX;
    }
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    //get atribut
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Image getImage() {
        return image;
    }
    public int getVelocityX() {
        return velocityX;
    }
    public boolean getPassed() {
        return passed;
    }
}