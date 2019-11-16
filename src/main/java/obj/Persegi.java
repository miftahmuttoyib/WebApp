package obj;

public class Persegi {
    private int sisi;

    public int getSisi() {
        return sisi;
    }
    public void setSisi(int sisi) {
        this.sisi = sisi;
    }

    public int hitungLuas() {
        int hasil = sisi*sisi;
        return hasil;
    }
}
