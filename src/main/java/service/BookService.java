package service;

import obj.Mobil;
import obj.Persegi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("book")
public class BookService {
    @GET
    @Path("test")
//    @Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Mobil getBook() {

        Mobil toyota = new Mobil();
        toyota.nama = "avanza";
        String nameMobil = toyota.getNama();


        cekNamaMobil(nameMobil);

        Persegi persegi = new Persegi();
        persegi.setSisi(20);

        int hasil = persegi.hitungLuas();
        System.out.println(hasil);
        return toyota;
    }

    private void cekNamaMobil(String nameMobil) {
        if (nameMobil.equals("avanza")) {
            nameMobil = "senia";
        }
    }
}
