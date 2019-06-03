package softuni.demo.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.demo.service.ShampooService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class Controler implements CommandLineRunner {
    private final ShampooService shampooService;

    public Controler(ShampooService shampooService) {
        this.shampooService = shampooService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> lines = new ArrayList<>();

        while (!input.equals("")) {
            lines.add(input);

            input = scanner.nextLine();
        }

        this.shampooService.selectShampoosByIngredients(lines);

        /*List<String> list = this.shampooService.selectShampooBySize(input);

        list.forEach(System.out::println);*/
    }
}
