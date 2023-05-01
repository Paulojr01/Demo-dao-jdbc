package Programa;

import LimpaConsole.Limpa;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner ler = new Scanner(System.in);
        String opcao = "";

        /* do {
            System.out.print(
                    "\n\nDigite uma opção que deseja realizar:\n\n 1 - Vendedores \n 2 - Busca por departamento \n 3 - Todos os vendedores \n 4 - Insira um novo vendedor \n 5 - Atualizar vendedor \n 6 - Deletar vendedor \n 0 - Encerrar Programa \n --> ");
            opcao = ler.next();
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

                    System.out.print("Dados dos vendedores deste departamento: \n");
                    SellerDao sellerDao2 = DaoFactory.createSellerDao();
                    Department department = new Department(id, null);
                    List<Seller> list = sellerDao2.findByDepartment(department);
                    for (Seller obj : list) {
                        System.out.println(obj)
                        System.out.println();;
                    }
                    System.out.println("\nPressione  tecla enter para voltar ao menu.");
                    ler.nextLine();
                    ler.nextLine();
                    break;

                case "3":

                    ler = new Scanner(System.in);
                    System.out.println("Digite o all para retorna todos os vendedores : ");
                    String all = ler.nextLine();
                    SellerDao sellerDao3 = DaoFactory.createSellerDao();
                    list = sellerDao3.findAll();
                    for (Seller obj : list) {
                        System.out.println(obj)
                        System.out.println();;
                    }

                    System.out.println("\nPressione  tecla enter para voltar ao menu.");
                    ler.nextLine();
                    ler.nextLine();

                    break;

                case "4":
                    ler = new Scanner(System.in);
                    System.out.println("Digite o Nome do vendedor: ");
                    String nome = ler.nextLine();
                    System.out.println("Digite o Email do vendedor: ");
                    String email = ler.nextLine();
                    System.out.println("Digite o salario base do vendedor: ");
                    Double salario = ler.nextDouble();
                    ler.nextLine();
                    System.out.println("Digite o ID do departamento: ");
                    int id2 = ler.nextInt();
                    ler.nextLine();

                    Department dep = new Department(id2, null);
                    Seller newSeller = new Seller(null, nome, email, new Date(), salario, dep);

                    sellerDao = DaoFactory.createSellerDao();
                    sellerDao.insert(newSeller);
                    System.out.print("Inserido! novo id = " + newSeller.getId());

                    break;

                case "5":
                    String opcao2 = "";
                    do {
                        System.out.print(
                                "\n\nAlterar dados do vendedor:\n\n 1 - Alterar nome do vendedor\n 2 - Alterar email do vendedor \n 3 - Alterar data de nascimento do vendedor \n 4 - Alterar salario do vendedor \n 5 - Alterar departamento do vendedor \n 0 - Encerrar Programa \n --> ");
                        opcao2 = ler.nextLine();
                        ler = new Scanner(System.in);
                        Limpa.Console();

                        switch (opcao2) {
                            case "1":
                                System.out.println("Digite primeiro o Id do vendedor: ");
                                int idUp = ler.nextInt();
                                ler.nextLine();
                                sellerDao = DaoFactory.createSellerDao();
                                seller = sellerDao.findById(idUp);
                                System.out.println("Alterar nome do vendedor: ");
                                String setNome = ler.nextLine();
                                seller.setName(setNome);
                                sellerDao.update(seller);
                                System.out.print("Nome alterado com sucesso!");
                                break;

                            case "2":
                                System.out.println("Digite primeiro o Id do vendedor: ");
                                idUp = ler.nextInt();
                                ler.nextLine();
                                sellerDao = DaoFactory.createSellerDao();
                                seller = sellerDao.findById(idUp);
                                System.out.println("Alterar email do vendedor: ");
                                String setEmail = ler.nextLine();
                                seller.setEmail(setEmail);
                                sellerDao.update(seller);
                                System.out.print("Email alterado com sucesso!");
                                break;

                            case "3":
                                System.out.println("Digite primeiro o Id do vendedor: ");
                                idUp = ler.nextInt();
                                ler.nextLine();
                                sellerDao = DaoFactory.createSellerDao();
                                seller = sellerDao.findById(idUp);
                                System.out.print("Digite  data do nascimento do vendedor (no formato yyyy/MM/dd): ");
                                String dataString = ler.nextLine();
                                SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
                                Date data = null;
                                try {
                                    data = formato.parse(dataString);
                                } catch (Exception e) {
                                    System.out.println("Data inválida!");
                                    System.exit(0);
                                }
                                seller.setBirthDate(data);
                                sellerDao.update(seller);
                                System.out.print("Salario alterado com sucesso!");

                                break;

                            case "4":
                                System.out.println("Digite primeiro o Id do vendedor: ");
                                idUp = ler.nextInt();
                                ler.nextLine();
                                sellerDao = DaoFactory.createSellerDao();
                                seller = sellerDao.findById(idUp);
                                System.out.println("Alterar salario do vendedor: ");
                                double setSalario = ler.nextDouble();
                                ler.nextLine();
                                seller.setBaseSalary(setSalario);
                                sellerDao.update(seller);
                                System.out.print("Salario alterado com sucesso!");
                                break;

                            case "5":
                                System.out.println("Digite primeiro o Id do vendedor: ");
                                idUp = ler.nextInt();
                                ler.nextLine();
                                sellerDao = DaoFactory.createSellerDao();
                                seller = sellerDao.findById(idUp);
                                System.out.println("Digite o número do novo departamento do vendedor: ");
                                int setDep = ler.nextInt();
                                Department department1 = new Department(setDep, null);
                                ler.nextLine();
                                seller.setDepartment(department1);
                                sellerDao.update(seller);
                                System.out.print("Departamento  alterado com sucesso!");
                                break;
                        }


                    } while (!opcao2.equals("0")); //

                    break;

                case "6":
                    ler = new Scanner(System.in);
                    System.out.println("Digite o Id do vendedor que deseja deletar: ");
                    int idDel = ler.nextInt();
                    ler.nextLine();
                    sellerDao = DaoFactory.createSellerDao();
                    sellerDao.deleteById(idDel);

                    System.out.print("id deletado com sucesso!");
                    break;

                case "0":
                    System.out.println("Programa encerrando....");
                    break;


                default:
                    System.out.println("Opção inválida");
                    break;


            }

        } while (!opcao.equals("0")); */

        do {
            System.out.print(
                    "\n\nDigite uma opção que deseja realizar:\n\n 1 - Busca por departamento \n 2 - Mostrar Todos os departamento \n 3 - Insira um novo departamento \n 4 - Atualizar nome do departamento \n 5 - Deletar departamento por id \n 0 - Encerrar Programa \n --> ");
            opcao = ler.next();
            Limpa.Console();

            switch (opcao) {
                case "1":

                    ler = new Scanner(System.in);
                    System.out.println("Digite o id do departamento: ");
                    int idDep2 = ler.nextInt();
                    DepartmentDao departamentDao = DaoFactory.createdepartmentDaoDao();
                    Department departamentDao1 = departamentDao.findById(idDep2);
                    System.out.print("DEPARTAMENTO \n" + departamentDao1);

                    break;

                case"2":
                    ler = new Scanner(System.in);
                    System.out.println("Digite all para retorna todos os departamento: ");
                    String all = ler.next();
                     departamentDao = DaoFactory.createdepartmentDaoDao();
                    List<Department> list = departamentDao.findAll();
                    System.out.print("TODOS OS DEPARTAMENTOS \n");
                    for (Department obj : list ){
                        System.out.print(obj);
                        System.out.println();
                    }
                    break;

                case"3":
                    ler = new Scanner(System.in);
                    System.out.println("Digite o Id do novo departamento: ");
                    int idDep = ler.nextInt();
                    System.out.println("Digite o nome do novo departamento: ");
                    String nomeDep = ler.next();
                    departamentDao = DaoFactory.createdepartmentDaoDao();
                    Department department = new Department(idDep, nomeDep);
                    departamentDao.insert(department);
                    System.out.print("Departamento criado");
                    break;
                case"4":
                    ler = new Scanner(System.in);
                    System.out.println("Digite o Id do departamento que deseja altera : ");
                    idDep = ler.nextInt();
                    departamentDao = DaoFactory.createdepartmentDaoDao();
                    departamentDao1 = departamentDao.findById(idDep);
                    System.out.println("Digite o nome que deseja alterar: ");
                    String setName = ler.next();
                    departamentDao1.setName(setName);
                    departamentDao.update(departamentDao1);
                    System.out.print("Nome alterado com sucesso");
                    break;
                case"5":
                    break;
            }



        }while (!opcao.equals("0")) ;

    }
}
