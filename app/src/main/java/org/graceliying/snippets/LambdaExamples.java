package org.graceliying.snippets;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class LambdaExamples implements Runnable{

    @Override
    public void run() {
       log.info("Running lambda Examples.");

       // 1. Using a Lambda to print each item in a list
        List<String> names = Arrays.asList("Grace", "Ross", "Charlie");
        names.forEach(name -> log.info("Hello, " + name));

        // 2. Using a lambda to sort a list of Names
        List<String> sortedNames = Arrays.asList("Tom", "Alice", "Bob");
        sortedNames.sort((name1, name2) -> name1.compareTo(name2));
        log.info("Sorted Names; " + sortedNames);

        // 3. Using a lambda with a functional interface
        Greeting greeting = message -> log.info("Greeting: " + message);
        greeting.sayMessage("Welcome to java lambda!");

        // 4. Using Built-in Functional Interface
        Consumer<String> printName = name -> log.info("Name: " + name);
        names.forEach(printName);
    }

    @FunctionalInterface
    interface Greeting {
        void sayMessage(String message);
    }
}
