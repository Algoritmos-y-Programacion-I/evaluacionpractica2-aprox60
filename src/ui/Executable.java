package ui;

import java.util.Scanner;
import model.Controller;
import model.Project;
import model.Pillar;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }
    
    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
    */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema
    */
    public void registerProject() {
        System.out.println("Registra un nuevo proyecto con sus siguientes elementos: ");
        System.out.println("Pilar al que hace parte");
        int pillarType = reader.nextInt();
        reader.nextLine();
        System.out.println("Identificador");
        String id = reader.nextLine();
        System.out.println("Nombre");
        String name = reader.nextLine();
        System.out.println("Descripción");
        String description = reader.nextLine();
        System.out.println("Estado: Activo O inactivo (true/false)");
        Boolean status = reader.nextBoolean();
        reader.nextLine();
        control.registerProjectInPillar(pillarType, description, description, description, status);
    }

    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar 
    */
    public void showProjectsByPillar() {

    }

}