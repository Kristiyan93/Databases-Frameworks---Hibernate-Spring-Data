package softuni.shampoocompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import softuni.shampoocompany.service.IngredientService;
import softuni.shampoocompany.service.ShampooService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@org.springframework.stereotype.Controller
public class Controller implements CommandLineRunner {
    private final ShampooService shampooService;
    private final IngredientService ingredientService;
    private final Scanner scanner;

    @Autowired
    public Controller(ShampooService shampooService, IngredientService ingredientService, Scanner scanner) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
        //selectShampoosBySize();
        //selectShampoosBySizeOrLabel();
        //selectShampoosByPrice();
        //selectIngredientsByName();
        //selectIngredientsByNames();
        //countShampoosByPrice();
        //selectShampoosByIngredients(); NOT Work

    }

    private void selectShampoosByIngredients() {
        List<String> names = new ArrayList<>();

        System.out.print("Enter: ");

        String input = this.scanner.nextLine();

        while (!input.equals("")) {
            names.add(input);

            System.out.print("Enter name: ");
            input = this.scanner.nextLine();
        }

        this.shampooService.selectShampoosByIngredients(names)
                .forEach(System.out::println);
    }

    private void countShampoosByPrice() {
        System.out.print("Enter price: ");
        BigDecimal price = new BigDecimal(this.scanner.nextLine());

        Integer count = this.shampooService.countShampoosByPrice(price);

        System.out.println(count);
    }

    private void selectIngredientsByNames() {
        List<String> names = new ArrayList<>();

        System.out.print("Enter name: ");
        String name = this.scanner.nextLine();

        while (!name.equals("")) {
            names.add(name);

            System.out.print("Enter name: ");
            name = this.scanner.nextLine();
        }

        this.ingredientService
                .selectIngredientsByNames(names)
        .forEach(System.out::println);
    }

    private void selectIngredientsByName() {
        System.out.print("Enter name starts with: ");
        String letters = this.scanner.nextLine();

        this.ingredientService
                .selectIngredientsByName(letters)
                .forEach(System.out::println);
    }

    private void selectShampoosByPrice() {
        System.out.print("Enter price for Shampoos: ");
        BigDecimal price = new BigDecimal(this.scanner.nextLine());

        this.shampooService.selectShampoosByPrice(price)
                .forEach(System.out::println);
    }

    private void selectShampoosBySizeOrLabel() {
        System.out.print("Enter Shampoos by Size: ");
        String inputSize = this.scanner.nextLine();

        System.out.print("Enter Shampoos by Label: ");
        Long inputId = Long.parseLong(this.scanner.nextLine());

        this.shampooService
                .selectShampoosBySizeOrLabel(inputSize, inputId)
                .forEach(System.out::println);
    }

    private void selectShampoosBySize() {
        System.out.print("Enter Shampoos by Size: ");

        String inputSize = this.scanner.nextLine();

        this.shampooService.selectShampoosBySize(inputSize).forEach(System.out::println);
    }
}
