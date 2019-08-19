import java.util.Comparator;
import java.util.List;

public class AccountMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //1.sort list<list<String>> by name
        accounts.sort(Comparator.comparing((List<String> l) -> l.get(0)));

        //2.sort list<string> by lexical order
        for (List<String> account : accounts) {
            String name = account.get(0);
            account.remove(0);
            account.sort(Comparator.naturalOrder());
            deduplicate(account);
            account.add(0, name);
        }

        //3.for lists with the same name:
        //  use binary search to find same words
        // if find: merge

        String prevName = accounts.get(0).get(0);
        int prevIndex = 0;
        int index = 1;
        while (index < accounts.size()) {
            if (!accounts.get(index).get(0).equals(prevName)) {
                prevName = accounts.get(index).get(0);
                prevIndex = index;
                index++;
            } else {
                boolean merged = false;
                for (int i = index - 1; i >= prevIndex; i--) {
                    if (sameUser(accounts, i, index)) {
                        mergeAccount(accounts, i, index);
                        merged = true;
                        index = i;
                    }
                }
                if (!merged) {
                    index++;
                }

            }
        }
        return accounts;

    }

    private boolean sameUser(List<List<String>> accounts, int indexOne, int indexTwo) {
        List<String> accountOne = accounts.get(indexOne);
        List<String> accountTwo = accounts.get(indexTwo);
        for (String email : accountTwo) {
            if (isIn(email, accountOne, 1, accountOne.size() - 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIn(String s, List<String> list, int start, int end) {
        int l = start;
        int r = end;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (s.equals(list.get(mid))) {
                return true;
            } else if (s.compareTo(list.get(mid)) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    private void mergeAccount(List<List<String>> accounts, int i1, int i2) {
        List<String> listOne = accounts.get(i1);
        List<String> listTwo = accounts.get(i2);
        int indexOne = 1;
        int indexTwo = 1;
        while (indexOne < listOne.size() && indexTwo < listTwo.size()) {
            // same mail don't add
            if (listOne.get(indexOne).equals(listTwo.get(indexTwo))) {
                indexTwo++;

            } else if (listOne.get(indexOne).compareTo(listTwo.get(indexTwo)) > 0) {
                listOne.add(indexOne, listTwo.get(indexTwo));
                indexTwo++;
            }
            indexOne++;
        }
        while (indexTwo < listTwo.size()) {
            listOne.add(listTwo.get(indexTwo++));
        }
        accounts.remove(i2);
    }

    private void deduplicate(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
    }
}
