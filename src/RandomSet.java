import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomSet {
    private List<Integer> randomBase;
    private Map<Integer,Integer> intIndexMap;

    /** Initialize your data structure here. */
    public RandomSet() {
        randomBase = new ArrayList<>();
        intIndexMap = new HashMap<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer index = intIndexMap.get(val);
        if (index != null) {
            return false;
        }
        randomBase.add(val);
        index = randomBase.size() - 1;
        intIndexMap.put(val,index);
        return true;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // we have to remove old from intIndexMap
        Integer index = intIndexMap.remove(val);
        if (index == null) {
            return false;
        }
        Integer newValue = randomBase.get(randomBase.size()-1);
        randomBase.set(index,newValue);
        randomBase.remove(randomBase.size()-1);
        intIndexMap.put(newValue,index == randomBase.size() ? null:index);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return randomBase.get((int)(Math.random()*randomBase.size()));
    }
}
