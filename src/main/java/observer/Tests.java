package observer;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.List;
//@RunWith(value = BlockJUnit4ClassRunner.class)
public class Tests {

    private GroupAdmin group = new GroupAdmin();
    private ConcreteMember member = new ConcreteMember();

    @Test
    public void registerTest(){
        int x = group.getList().size();
        group.register(member);
        Assertions.assertEquals(group.getList().size(),x+1);
        group.register(null);
        Assertions.assertEquals(group.getList().size(),x+1);
    }

    @Test
    public void unregisterTest(){
        group.register(member);
        int x = group.getList().size();
        group.unregister(member);
        Assertions.assertEquals(group.getList().size(),x-1);
        group.unregister(null);
        Assertions.assertEquals(group.getList().size(),x-1);
    }

    @Test
    public void updateTest(){
        group.register(member);
        group.append("Hey");
        Assertions.assertEquals("Hey", group.toString());
        ConcreteMember concreteMember = (ConcreteMember) group.getList().get(0);
        Assertions.assertEquals(group.toString(), concreteMember.undostring.toString());
        group.append(null);
        Assertions.assertEquals(group.toString(), concreteMember.undostring.toString());
    }
}
