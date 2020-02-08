package bo.BOImplement;

import bo.GoodsBO;
import dao.GoodsDAO;
import obj.Goods;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import stdc.IdName;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GoodsBOImp extends GoodsDAO implements GoodsBO {

    @Override
    public Goods getById(String id) {
        List<Goods> items = extractFile();
        Optional<Goods> resultOpt = items.stream().filter(item -> item.getId().equals(id)).findAny();
        return resultOpt.orElseGet(Goods::new);
    }

    @Override
    public List<Goods> getAllGoods() {
        return getAll();
    }

    private List<Goods> extractFile() {
        Scanner file = getFile();
        if (file == null) {
            return new ArrayList<>();
        }
        List<Goods> resultList = new ArrayList<>();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            Goods resultItem = toObj(line);
            resultList.add(resultItem);
        }
        return resultList;
    }

    private Goods toObj(String line) {
        String[] parts = line.split(",");
        return mapToObj(parts);
    }

    private Goods mapToObj(String[] parts) {
        Goods goods = new Goods();
        goods.setId(parts[0]);
        goods.setCode(parts[1]);
        goods.setName(parts[2]);
        goods.setPrice(Integer.parseInt(parts[3]));
        goods.setStock(Integer.parseInt(parts[4]));
        goods.setLocationCode(parts[5]);
        return goods;
    }

    private Scanner getFile() {
        File file = new File("D:\\Project\\WebApp\\WebApp\\src\\main\\java\\testFile\\TestGoods.txt");
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
