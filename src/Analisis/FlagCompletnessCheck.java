package Analisis;

import internals.Flag;
import internals.FlagState;

import java.util.*;
import java.util.stream.Collectors;

public class FlagCompletnessCheck {

    public static void main(String[] args) {
        FlagCompletnessCheck fc = new FlagCompletnessCheck();
        fc.addNewFlagCombination(List.of(new FlagState(Flag.As,true)
                ,new FlagState(Flag.Bs,false)
        ));
        fc.checkCompletness();
    }
    //Change the length of the map
    private FlagTree tree = new FlagTree(null,null);

    private List<Set<FlagState>> flagCombinationsToAdd = new ArrayList<>();
    private Set<Flag> flagsObserved = new HashSet<>();



    public void addNewFlagCombination(List<FlagState> flagStates){

        //Check for new non observed flags
        var copy_flag = flagStates.stream()
                .map(FlagState::getFlag)
                .collect(Collectors.toSet());
        var missing_flags = new TreeSet<>(copy_flag);
        missing_flags.removeAll(flagsObserved);

        if(missing_flags.size() > 0 ){
            flagsObserved = copy_flag;
        }

        //Add to list to be inserted later
        flagCombinationsToAdd.add(new TreeSet<>(flagStates));
    }





    //TO change a lot
    private void addAllFlags(){
        for (var flagStateToAdd : flagCombinationsToAdd){


            //get the flags missings
            var flagToAdd = flagStateToAdd.stream()
                    .map(FlagState::getFlag)
                    .collect(Collectors.toSet());
            var flagsObservedCopy = new TreeSet<>(flagsObserved);
            flagsObservedCopy.removeAll(flagToAdd);
            var missingFlags = new ArrayList<>(flagsObservedCopy);




            for(var perm : getPermutations( List.of(true,false),flagsObservedCopy.size())){
                var newSet = new TreeSet<FlagState>();
                for (var i=0;i< perm.size();i++){
                    newSet.add(new FlagState(missingFlags.get(i), perm.get(i)));
                }
                flagStateToAdd.addAll(newSet);
                tree.addChildren(new ArrayList<>(flagStateToAdd));

            }


        }
    }


    public void checkCompletness(){
        addAllFlags();
        tree.checkCorrect();
        //Tira excepcion
    }



    private static <T> List<List<T>> getPermutations(List<T> set, int k) {
        List<List<T>> result = new ArrayList<>();
        int n = set.size();
        getPremutations_imp(set, new ArrayList<>() {}, n, k, result);
        return result;
    }

    private static <T> void getPremutations_imp(List<T> set, Collection<T> prefix, int n, int k, List<List<T>> result) {
        // Base case: k is 0, add the prefix as a result
        if (k == 0) {
            result.add(new ArrayList<>(prefix));
            return;
        }

        // Iterate over the set and recursively call for k - 1
        for (int i = 0; i < n; ++i) {
            // Add the current element to the prefix
            prefix.add(set.get(i));

            // Recur for the next element with reduced k
            getPremutations_imp(set, prefix, n, k - 1, result);

            // Backtrack to remove the last element
            prefix.remove(prefix.size() - 1);
        }

    }
}



class FlagTree{
    private FlagTree parent;
    private HashMap<FlagState,FlagTree> childs = new HashMap<>();
    private FlagState value;
    public boolean isChecked = false;
    public FlagTree(FlagTree parent,FlagState value){
        this.parent = parent;
        this.value = value;
    }



    public FlagTree addChildren(List<FlagState> flagStates){

        if(flagStates.isEmpty()) {return null;}
        childs.put(flagStates.get(0),new FlagTree(this, flagStates.get(0)));
        var newChild = childs.get(flagStates.get(0));
        newChild.addChildren(flagStates.subList(1, flagStates.size()));
        return newChild;
    }




    private boolean existsOpposite(){
        if(isChecked) return true;
        var oppositeValue = new FlagState(value.getFlag(),!value.getState());
        var res = parent.childs.get(oppositeValue);
        if(res == null){
            //get whole tree backwards
            var flags = new LinkedList<FlagState>();
            var currentNode = this;
            while(currentNode.parent != null){
                flags.add(currentNode.value);
                currentNode = currentNode.parent;
            }
            var message = "There needs to be a flag  combination that covers the combination ";
            for(var flag : flags){
                message+=flag.getInputName();
            }
            throw new RuntimeException(message);
        }
        res.isChecked = true;
        return true;
    }



    public void checkCorrect(){
        //process node
        existsOpposite();
        //proces childs
        for(var child : childs.values()){
            child.checkCorrect();
        }
    }


}

