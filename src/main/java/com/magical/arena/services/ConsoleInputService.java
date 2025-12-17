package com.magical.arena.services;


import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleInputService implements InputService {

    private final Scanner scanner;
    public ConsoleInputService() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    @Override
    public Integer readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try{
                Integer value = Integer.parseInt(input);
                if(value > 0) {
                    return value;
                }
            }catch(NumberFormatException e){ }

            System.out.println("Invalid input. Please enter a positive integer.");
        }
    }
}
