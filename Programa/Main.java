package Programa;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o numero do departamento para consultar vendedor :");
        int id = ler.nextInt();

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Test1: seller findyById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== Test2: seller findyByDepartmentId ====");
        Department department = new Department(id,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }
    }
}
