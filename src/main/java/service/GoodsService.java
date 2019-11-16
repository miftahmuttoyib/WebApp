package service;

import bo.BOImplement.GoodsBOImp;
import bo.GoodsBO;
import obj.Goods;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("goods")
public class GoodsService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Goods getGoodsById(String id) {
        return new Goods();
    }

    @GET
    @Path("get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Goods> selectAllGoods() {
        GoodsBO goodsBO = new GoodsBOImp();
        return goodsBO.getAllGoods();
    }

    @POST
    @Path("save/single")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Goods saveGoods(Goods goods){
        return goods;
    }

    @POST
    @Path("save/list")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Goods> saveListGoods(List<Goods> goodsList) {
        goodsList.toArray();
        return goodsList;
    }

    @DELETE
    @Path("delete/single")
    public void deleteGoods(String id) {

    }
}
