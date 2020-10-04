package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model){
       model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return  "bankaccount";
    }

   @PostMapping
    public String OpenAccount(@ModelAttribute BankAccount bankAccount,Model model){
        bankAccountService.openAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return "redirect:bankaccount";
   }
   @GetMapping ("/edit/{id}")
    public String getEditBankAccountPage (@PathVariable int id,Model model){
        BankAccount account = bankAccountService.getBankAccount(id);

        model.addAttribute("bankAccount",account);
        return "bankaccount-edit";
   }

    @PostMapping("/edit/{id}")
    public String editAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {

        bankAccountService.editBankAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";

    }

    @GetMapping("/delete/{id}")
    public String getDeleteBankAccountPage (@PathVariable int id,Model model){
        BankAccount account = bankAccountService.getBankAccount(id);
        model.addAttribute("bankAccount",account);
        return "bankaccount-delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteAccount (@PathVariable int id,@ModelAttribute BankAccount bankAccount,Model model){

        bankAccountService.deleteBankAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @GetMapping("/withdraw/{id}")
    public  String getWithDrawBankAccountPage (@PathVariable int id,Model model){
        BankAccount account = bankAccountService.getBankAccount(id);
        model.addAttribute("bankAccount",account);
        return "bankaccount-withdraw";
    }
    @PostMapping("/withdraw/{id}")
    public String withDrawAccount (@PathVariable int id,@ModelAttribute BankAccount bankAccount,Model model){
        bankAccountService.withDrawBankAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @GetMapping("/deposit/{id}")
    public  String getDepositBankAccountPage (@PathVariable int id,Model model){
        BankAccount account = bankAccountService.getBankAccount(id);
        model.addAttribute("bankAccount",account);
        return "bankaccount-deposit";
    }
    @PostMapping("/deposit/{id}")
    public String DepositAccount (@PathVariable int id,@ModelAttribute BankAccount bankAccount,Model model){
        bankAccountService.depositBankAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }


}
