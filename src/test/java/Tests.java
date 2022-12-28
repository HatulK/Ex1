import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility

    private GroupAdmin group = new GroupAdmin();
    private ConcreteMember member = new ConcreteMember();

    @Test
    public void JVMTest(){
        logger.info(JvmUtilities::jvmInfo);
        logger.info(()->JvmUtilities.objectFootprint(group));
        logger.info(()->JvmUtilities.objectFootprint(member));
        logger.info(()->JvmUtilities.objectTotalSize(group,member));
        group.register(member);
        logger.info(()->JvmUtilities.objectFootprint(group));
    }
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
        Assertions.assertEquals(group.toString(), concreteMember.toString());
        group.append(null);
        Assertions.assertEquals(group.toString(), concreteMember.toString());
    }
}
