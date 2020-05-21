package Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class HeadOffice {

    LinkedList<Branch> branches=new LinkedList<>();

    public Branch createBranch(){
        if(branches.isEmpty())
            return new Branch(0);
        return new Branch(branches.getLast().branchId+1);
    }

    public Branch getBranchById(int branchId){
        for(Branch branch:branches){
            if(branch.getBranchId()==branchId)
                return branch;
        }
        return null;
    }
    public List<Branch> getAllBranches(){
        return branches;
    }
}
