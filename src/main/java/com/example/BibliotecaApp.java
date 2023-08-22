package com.example;

import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("O que deseja?");
        System.out.println("1. Criar bilioteca");
        System.out.println("2. Sair");
        String resposta = scan.nextLine();
        Boolean encerrar = false;

        do {
            switch (resposta) {
                case "2":
                case "Sair":
                    encerrar = true;
                    break;
                case "1":
                case "Criar bilioteca":
                    System.out.print("Escolha o tamanho da biblioteca: ");
                    resposta = scan.nextLine();
                    int tamanhoBiblioteca = Integer.parseInt(resposta);
                    Biblioteca biblioteca = new Biblioteca(tamanhoBiblioteca);
                    System.out.print("1. Quer adicionar algum livro? ");
                    System.out.println("2. Sair");
                    break

                case "1":
                    System.out.print("1. Quer adicionar algum livro? ");
                    break


            }
        } while (encerrar == false);
    }
}