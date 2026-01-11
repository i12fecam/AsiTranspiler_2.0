package Analysis;

import Internals.Flag;
import Internals.FlagState;

import java.util.*;
import java.util.stream.Collectors;

public class FlagExhaustivenessHelper {

    public static void main(String[] args) {
        FlagExhaustivenessHelper fc = new FlagExhaustivenessHelper();
        fc.addNewFlagCombination(List.of(new FlagState(Flag.As,true)
                                        ,new FlagState(Flag.Bs,null)
        ));
        fc.addNewFlagCombination(List.of(new FlagState(Flag.As,true)
                                        ,new FlagState(Flag.Bs,false)
        ));
        fc.checkCompletness();
    }
    private FlagTree tree = new FlagTree(null,null);


    private Set<Flag> flagsObserved = null;



    public void addNewFlagCombination(List<FlagState> flagStates){

        //Check for new non observed flags
        checkForNotObservedFlags(flagStates);

        var expandedFlagStates = expandUndefinedFlags(flagStates);

        tree.addChildren(expandedFlagStates);
    }

    private void checkForNotObservedFlags(List<FlagState> flagStates){
        var flags = flagStates.stream()
                .map(FlagState::getFlag)
                .collect(Collectors.toSet());

        if(flagsObserved == null){
            flagsObserved = new HashSet<>(flags);
        }

        var missing_flags = new TreeSet<>(flags);
        missing_flags.removeAll(flagsObserved);

        if(missing_flags.size() > 0 ){
            throw new RuntimeException("Introduced new flag not defined in previous definitions:" + missing_flags);
        }
    }

    private List<FlagState> expandUndefinedFlags(List<FlagState> flagStates){
        var undefined_flags = flagStates.stream()
                .filter(f -> f.getFlag() == null)
                .collect(Collectors.toList());

        var defined_flags = flagStates.stream()
                .filter(f -> f.getFlag() != null)
                .collect(Collectors.toList());

        var flagStatesToAdd = new ArrayList<FlagState>();
        for(var perm : getPermutations( List.of(true,false),undefined_flags.size())){
            for (var i=0;i< perm.size();i++){
                flagStatesToAdd.add(new FlagState(undefined_flags.get(i).getFlag(), perm.get(i)));
            }
        }
        defined_flags.addAll(flagStatesToAdd);

        Collections.sort(defined_flags);

        return defined_flags;

    }

    public void checkCompletness(){
        tree.checkCorrect();
    }



    private static <T> List<List<T>> getPermutations(List<T> set, int k) {
        List<List<T>> result = new ArrayList<>();
        int n = set.size();
        getPermutationsImp(set, new ArrayList<>() {}, n, k, result);
        return result;
    }

    private static <T> void getPermutationsImp(List<T> set, Collection<T> prefix, int n, int k, List<List<T>> result) {
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
            getPermutationsImp(set, prefix, n, k - 1, result);

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

        assert flagStates.get(0).isStateDefined();


        if(flagStates.isEmpty()) {return null;}

        childs.put(flagStates.get(0),new FlagTree(this, flagStates.get(0)));
        var newChild = childs.get(flagStates.get(0));

        newChild.addChildren(flagStates.subList(1, flagStates.size()));

        return newChild;
    }




    private boolean existsOpposite(){
        if(isChecked) return true;
        if(parent == null) return true;
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

            var message = "There needs to be a flag combination that covers the combination { ";
            for(var flag : flags){
                message+=flag.getInputName();
            }
            message+=" }";
            throw new RuntimeException(message);
            //return false;
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

