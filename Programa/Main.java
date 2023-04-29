package Programa;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Test1: seller findyById ====");
        Seller seller = sellerDao.findById(2);

        System.out.println(seller);
    }
}
