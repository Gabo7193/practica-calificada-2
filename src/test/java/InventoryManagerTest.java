import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    @Test
    void testAddNewItem() {
        InventoryManager inv = new InventoryManager();
        inv.addItem("Laptop", 5);
        assertEquals(5, inv.getStock("Laptop"));
    }

    @Test
    void testNegativeQuantity() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> inv.addItem("Mouse", -1));
    }

    @Test
    void testZeroQuantity() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> inv.addItem("Teclado", 0));
    }

    @Test
    void testEmptyName() {
        InventoryManager inv = new InventoryManager();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> inv.addItem("", 5));
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    void testSpacesOnlyName() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> inv.addItem("   ", 5));
    }

    @Test
    void testNameTooShort() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> inv.addItem("A", 5));
    }

    @Test
    void testNameTooLong() {
        InventoryManager inv = new InventoryManager();
        String name = "A".repeat(51);
        assertThrows(IllegalArgumentException.class, () -> inv.addItem(name, 5));
    }

    @Test
    void testQuantityTooLarge() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> inv.addItem("Monitor", 5000));
    }

    @Test
    void testAddExistingItem() {
        InventoryManager inv = new InventoryManager();
        inv.addItem("Mouse", 2);
        inv.addItem("Mouse", 3);
        assertEquals(5, inv.getStock("Mouse"));
    }

    @Test
    void testMinimumValidQuantity() {
        InventoryManager inv = new InventoryManager();
        inv.addItem("USB", 1);
        assertEquals(1, inv.getStock("USB"));
    }
    @Test
    void testNullItemName() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> inv.addItem(null, 5));
    }

}
