import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAccountMerge {

    @Test
    public void testCaseOne() {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account = new ArrayList<>();
        account.add("John");
        account.add("johnsmith@mail.com");
        account.add("john_newyork@mail.com");
        accounts.add(account);
        account = new ArrayList<>();
        account.add("John");
        account.add("johnsmith@mail.com");
        account.add("john00@mail.com");
        accounts.add(account);
        account = new ArrayList<>();
        account.add("Mary");
        account.add("mary@google.com");
        accounts.add(account);
        account = new ArrayList<>();
        account.add("John");
        account.add("johnnybravo@mail.com");
        accounts.add(account);
        AccountMerge am = new AccountMerge();
        am.accountsMerge(accounts);
    }
}
