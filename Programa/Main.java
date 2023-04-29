package Programa;

import LimpaConsole.Limpa;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner ler = new Scanner(System.in);
        String opcao = "";

        do {
            System.out.print(
                    "\n\nDigite uma opção que deseja realizar:\n\n 1 - Busca por ID\n 2 - Busca por departamento \n 3 - Todos os vendedores \n 0 - Encerrar Programa \n --> ");
            opcao = ler.nextLine();
            ler = new Scanner(System.in);
            Limpa.Console();

            switch (opcao) {
                case "1":
                    ler = new Scanner(System.in);
                    System.out.println("Digite o ID do vendedor: ");
                    int id = ler.nextInt();
                    SellerDao sellerDao = DaoFactory.createSellerDao();
                    Seller seller = sellerDao.findById(id);

                    System.out.println("\nPressione  tecla enter para voltar ao menu.");
                    ler.nextLine();
                    ler.nextLine();
                    break;
                case "2":
                    ler = new Scanner(System.in);
                    System.out.println("Digite o ID do departamento: ");
                    id = ler.nextInt();

                    System.out.print("Dados dos vendedores deste departamento: \n" );
                    SellerDao sellerDao2 = DaoFactory.createSellerDao();
                    Department department = new Department(id,null);
                    List<Seller> list = sellerDao2.findByDepartment(department);
                    for (Seller obj : list){
                        System.out.println(obj);
                    }
                    System.out.println("\nPressione  tecla enter para voltar ao menu.");
                    ler.nextLine();
                    ler.nextLine();
                    break;
                case"3":

                    ler = new Scanner(System.in);
                    System.out.println("Digite o all para retorna todos os vendedores : ");
                    String all = ler.nextLine();
                    SellerDao sellerDao3 = DaoFactory.createSellerDao();
                    list = sellerDao3.findAll();
                    for (Seller obj : list){
                        System.out.println(obj);
                    }

                    System.out.println("\nPressione  tecla enter para voltar ao menu.");
                    ler.nextLine();
                    ler.nextLine();

                break;

                case "0":
                    System.out.println("Programa encerrando....");
                    break;



                default:
                    System.out.println("Opção inválida");
                    break;


            }

        } while (!opcao.equals("0"));





    }
}
