package com.gfa.bank_of_simba.controllers;

import com.gfa.bank_of_simba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankAccountController {
    List<BankAccount> bankAccounts;

    public BankAccountController() {
        this.bankAccounts = new ArrayList<>();
        bankAccounts.add(new BankAccount("Zazu", 1000, "cockatoo", false, true));
        bankAccounts.add(new BankAccount("Pumbaa", 3000, "warthog", false, true));
        bankAccounts.add(new BankAccount("Nala", 4000, "lion", false, true));
        bankAccounts.add(new BankAccount("Scar", 5000, "lion", true, false));
        bankAccounts.add(new BankAccount("Rafiki", 1000, "baboon", false, true));
    }

    @GetMapping("/show")
    public String showBankAccount(Model model) {
        BankAccount bankAccount = new BankAccount("Simba", 2000, "lion", true, true);
        model.addAttribute("bankAccount", bankAccount);
        return "bank_account";
    }

    @GetMapping("/html_text")
    public String showHtmlText(Model model) {
        String html_text = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
        model.addAttribute("html_text", html_text);
        return "html_text";
    }

    @GetMapping("/bank_accounts")
    public String showBankAccounts(Model model) {
        model.addAttribute("bankAccounts", bankAccounts);
        return "bank_accounts";
    }

    @GetMapping("/raise_balance")
    public String showRaiseBalance(Model model) {
        model.addAttribute("bankAccounts", bankAccounts);
        return "raise_balance";
    }

    @PostMapping("/raise_balance")
    public String raiseBalance(@RequestParam String name) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getName().equals(name)) {
                bankAccount.setBalance(bankAccount.getBalance() + 10 * (bankAccount.isKing() ? 10 : 1));
                break;
            }
        }
        return "redirect:/bank_accounts";
    }

    @GetMapping("/new_bank_account")
    public String showNewBankAccount(Model model) {
        model.addAttribute("bankAccount", new BankAccount());
        return "new_bank_account";
    }

    @PostMapping("/new_bank_account")
    public String addNewBankAccount(@ModelAttribute BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
        return "redirect:/bank_accounts";
    }
}
