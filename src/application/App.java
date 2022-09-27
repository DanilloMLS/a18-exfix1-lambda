package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Empregado;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o caminho completo do arquivo:");
        String arquivo = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            List<Empregado> empregados = new ArrayList<>();
            String linha = br.readLine();

            while (linha != null) {
                String[] dado = linha.split(",");
                empregados.add(new Empregado(dado[0],dado[1],Double.parseDouble(dado[2])));
                linha = br.readLine();
            }

            for (Empregado empregado : empregados) {
                System.out.println(empregado);
            }

            //E-mails em ordem alfabética dos funcionários que recebem mais que o usuário digitar
            System.out.println("Entre com o salário (serão listados os funcionários que recebem mais que o digitado):");
            double salario = sc.nextDouble();

            List<String> emails = empregados.stream()
                                    .filter(p -> p.getSalario() > salario)
                                    .map(p -> p.getEmail()).sorted()
                                    .collect(Collectors.toList());
            
            emails.forEach(System.out::println);

            double soma = empregados.stream()
                                    .filter(p -> p.getNome().startsWith("M"))
                                    .map(p -> p.getSalario())
                                    .reduce(0.0, (x,y) -> x + y);

            System.out.println("Soma dos salários de quem começa com M: " + soma);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}
