//Title: Banking system: Behind the scenes, opening a bank account involves KYC, account setup, debit card issuance, and more.

package StructuralDesign.FacadePattern;

public class BankAccount {
    public static void main(String[] args){
        FacadePattern bankAccountFacade = new FacadePattern();
        bankAccountFacade.openAccount("sheetal");
    }
}

class AccountService {
    public void createAccount(String name) {
        System.out.println("Account created for" + name );
    }

}
class KYCService {
    public void doKyc(String name) {
        System.out.println("KYC" + name );
    }

}

class FacadePattern{
    private AccountService accountService;
    private KYCService kycService;

    public FacadePattern() {
        accountService = new AccountService();
        kycService = new KYCService();
    }

    public void openAccount(String name) {
        accountService.createAccount(name);
        kycService.doKyc(name);
        
        System.out.println("Bank account opened for " + name);
    }
}

