package com.gfa.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWebController {
    AtomicLong atomicLong = new AtomicLong();

    @RequestMapping("/web/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", " World");
        return "greeting";
    }

    @RequestMapping("/web/greeting_counter")
    public String countGreetings(@RequestParam() String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("count", atomicLong.incrementAndGet());
        return "greeting_counter";
    }

    @RequestMapping("/hello_world")
    public String helloWorld(@RequestParam() int fontSize, @RequestParam() String color, Model model) {
        String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
                "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
                "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
                "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};
        Random random = new Random();
        model.addAttribute("hello", hellos[random.nextInt(hellos.length)]);
        model.addAttribute("fontSize", fontSize);
        model.addAttribute("color", color);
        return "hello_world";
    }

    @RequestMapping("/fizz")
    public String fizzBuzzWoof(@RequestParam() String name, Model model) {
        long count = atomicLong.incrementAndGet();
        model.addAttribute("name", name);
        if (count % 3 == 0 && count % 5 == 0 && count % 7 == 0) {
            model.addAttribute("count", "FizzBuzzWoof");
        } else if (count % 3 == 0 && count % 5 == 0) {
            model.addAttribute("count", "FizzBuzz");
        } else if (count % 5 == 0 && count % 7 == 0) {
            model.addAttribute("count", "BuzzWoof");
        } else if (count % 3 == 0 && count % 7 == 0) {
            model.addAttribute("count", "FizzWoof");
        } else if (count % 3 == 0) {
            model.addAttribute("count", "Fizz");
        } else if (count % 5 == 0) {
            model.addAttribute("count", "Buzz");
        } else if (count % 7 == 0) {
            model.addAttribute("count", "Woof");
        } else {
            model.addAttribute("count", count);
        }
        return "greeting_counter";
    }
}
