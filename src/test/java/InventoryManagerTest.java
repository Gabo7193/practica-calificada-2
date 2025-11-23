import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    InventoryManager manager = new InventoryManager();

    @Test
    void testNullItem() {
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem(null, 10));
    }

    @Test
    void testEmptyItem() {
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem(" ", 5));
    }

    @Test
    void testInvalidNameLength() {
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("A", 5));
    }

    @Test
    void testNegativeQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("Agua", -1));
    }

    @Test
    void testValidAdd() {
        manager.addItem("Agua", 10);
        assertEquals(10, manager.getStock("Agua"));
    }

    @Test
    void testAddTwice() {
        manager.addItem("Pan", 3);
        manager.addItem("Pan", 2);
        assertEquals(5, manager.getStock("Pan"));
    }
}
