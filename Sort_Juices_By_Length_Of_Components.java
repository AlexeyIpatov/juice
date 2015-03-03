/**
 * Created by Pro on 01.03.2015.
 */
import java.util.Comparator;


public class Sort_Juices_By_Length_Of_Components implements Comparator<Juices> {
    @Override
    public int compare(Juices o1, Juices o2) {
        return o1.getFruits().size() - o2.getFruits().size();
     //   return  o1.getName().compareTo(o2.getName());
    }
}
