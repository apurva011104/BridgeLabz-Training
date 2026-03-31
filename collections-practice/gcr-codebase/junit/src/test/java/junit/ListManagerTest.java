package junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    @Test
    void addElementTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 16; i += 2) {
            list.add(i);
        }

        boolean actualResult = ListManager.addElement(list, 17);
        boolean expectedResult = true;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeElementTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 16; i += 2) {
            list.add(i);
        }

        boolean actualResult = ListManager.removeElement(list, 17);
        boolean expectedResult = true;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getSizeTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 16; i += 2) {
            list.add(i);
        }

        int actualResult = ListManager.getSize(list);
        int expectedResult = list.size();

        assertEquals(expectedResult, actualResult);
    }
}
