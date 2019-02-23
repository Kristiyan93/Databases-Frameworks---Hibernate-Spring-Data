package Lab.b_BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        BankAccount bankAccount = null;

        String input = reader.readLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int id ;
            double amount;

            switch (command) {
                case "Create":
                    createAccount(accounts);
                    break;
                case "Deposit":
                    id = Integer.parseInt(tokens[1]);
                    amount = Double.parseDouble(tokens[2]);

                    depositAccount(accounts, id, amount);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterest(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    getInterestAccount(accounts, id, years);
                    break;
            }

            input = reader.readLine();
        }
    }

    private static void getInterestAccount(HashMap<Integer, BankAccount> accounts, int id, int years) {
        BankAccount current1 = accounts.get(id);

        if (isNull(current1)) return;

        double currentInterest = current1.getInterest(years);

        System.out.printf("%.2f%n", currentInterest);
    }

    private static void depositAccount(HashMap<Integer, BankAccount> accounts, int id, double amount) {
        BankAccount current = accounts.get(id);

        if (isNull(current)) return;

        current.deposit(amount);
        accounts.put(id, current);
        System.out.printf("Deposited %.0f to ID%d%n", accounts.get(id).getBalance(), accounts.get(id).getId());
    }

    private static void createAccount(HashMap<Integer, BankAccount> accounts) {
        BankAccount bankAccount;
        bankAccount = new BankAccount();
        accounts.put(bankAccount.getId(), bankAccount);

        System.out.println(bankAccount.toString());
    }

    private static boolean isNull(BankAccount current) {
        if (current == null) {
            System.out.println("Account does not exist");
            return true;
        }

        return false;
    }
}
