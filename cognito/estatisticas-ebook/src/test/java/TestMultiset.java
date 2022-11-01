import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Assert;
import org.junit.Test;

public class TestMultiset {
    @Test
    public void testCountWords_1(){
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("Arthur");
        multiset.add("Arthur");
        multiset.add("Arthur");
        Assert.assertEquals(3, multiset.count("Arthur"));
    }

    @Test
    public void testCountWords_2(){
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("Arthur");
        multiset.add("Arthur");
        multiset.remove("Arthur");
        Assert.assertEquals(1, multiset.count("Arthur"));
    }
}
