package com.gfa.basic_webshop.controllers;

import com.gfa.basic_webshop.models.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Controller
public class WebShopController {
    List<ShopItem> shopItems;
    double changeRate;

    public WebShopController() {
        this.shopItems = new ArrayList<>();
        shopItems.add(new ShopItem("Running Shoes", "Nike running shoes for everyday sport", 1000, 5, "Clothes & Shoes"));
        shopItems.add(new ShopItem("Printer", "Some HP printer that will print pages", 3000, 2, "Electronics"));
        shopItems.add(new ShopItem("Coca Cola", "0.5l standard coke", 25, 0, "Beverages & Snacks"));
        shopItems.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100, "Beverages & Snacks"));
        shopItems.add(new ShopItem("T-shirt", "Blue with a corgi on a bike", 300, 1, "Clothes & Shoes"));
        this.changeRate = 300;
    }

    @GetMapping("/webshop")
    public String showIndex(Model model) {
        model.addAttribute("shopItems", shopItems);
        return "index";
    }

    @GetMapping("/only_available")
    public String showOnlyAvailableItems(Model model) {
        model.addAttribute("shopItems",
                shopItems.stream()
                        .filter(i -> i.getQuantityOfStock() > 0)
                        .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/cheapest_first")
    public String showItemsSortedByPriceAsc(Model model) {
        model.addAttribute("shopItems",
                shopItems.stream()
                        .sorted((a, b) -> Double.compare(a.getPrice(), b.getPrice()))
                        .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/contains_nike")
    public String showItemsThatContainNike(Model model) {
        model.addAttribute("shopItems",
                shopItems.stream()
                        .filter(i -> i.getName().toLowerCase().contains("nike") ||
                                i.getDescription().toLowerCase().contains("nike"))
                        .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/average_stock")
    public String showAverageStock(Model model) {
        model.addAttribute("averageStock",
                shopItems.stream()
                        .mapToDouble(ShopItem::getQuantityOfStock)
                        .average()
                        .orElse(0));
        return "average_stock";
    }

    @GetMapping("/most_expensive")
    public String showMostExpensiveAvailableItem(Model model) {
        model.addAttribute("shopItems",
                shopItems.stream()
                        .filter(i -> i.getQuantityOfStock() > 0)
                        .sorted(comparing(ShopItem::getPrice).reversed())
                        .limit(1)
                        .collect(Collectors.toList()));
        return "index";
    }

    @PostMapping("/search")
    public String showSearchedItems(@RequestParam String searchTerm, Model model) {
        model.addAttribute("shopItems",
                shopItems.stream()
                        .filter(i -> i.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                                i.getDescription().toLowerCase().contains(searchTerm.toLowerCase()))
                        .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/more_filters")
    public String showMoreFilters(Model model) {
        model.addAttribute("shopItems", shopItems);
        return "more_filters";
    }

    @GetMapping("/filter_by_type/{type}")
    public String showItemsFilteredByType(Model model, @PathVariable String type) {
        model.addAttribute("shopItems",
                shopItems.stream()
                        .filter(i -> i.getType().equalsIgnoreCase(type))
                        .collect(Collectors.toList()));
        return "more_filters";
    }

    @GetMapping("/more_filters/{currency}")
    public String showItemsInEuro(Model model, @PathVariable String currency) {
        model.addAttribute("currency", " €");
        model.addAttribute("shopItems",
                shopItems.stream()
                        .map(i -> new ShopItem(i.getName(), i.getDescription(), i.getPrice() / changeRate, i.getQuantityOfStock(), i.getType()))
                        .collect(Collectors.toList()));
        return "more_filters";
    }

    @PostMapping("/filter_by_price")
    public String showItemsFilteredByPrice(Model model, @RequestParam double searchTerm,
                                           @RequestParam String category) {
        List<ShopItem> filteredByPrice = switch (category) {
            case "above" -> shopItems.stream()
                    .filter(i -> i.getPrice() > searchTerm)
                    .collect(Collectors.toList());
            case "below" -> shopItems.stream()
                    .filter(i -> i.getPrice() < searchTerm)
                    .collect(Collectors.toList());
            case "exactly" -> shopItems.stream()
                    .filter(i -> i.getPrice() == searchTerm)
                    .collect(Collectors.toList());
            default -> new ArrayList<>();
        };
        model.addAttribute("shopItems", filteredByPrice);
        return "more_filters";
    }
}
