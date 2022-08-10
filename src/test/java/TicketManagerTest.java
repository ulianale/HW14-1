import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 40, "SVO", "CDG", 4);
    Ticket ticket2 = new Ticket(2, 200, "SVO", "LAX", 11);
    Ticket ticket3 = new Ticket(3, 160, "DME", "JFK", 10);
    Ticket ticket4 = new Ticket(4, 180, "SVO", "LAX", 12);
    Ticket ticket5 = new Ticket(5, 175, "DME", "LAX", 12);
    Ticket ticket6 = new Ticket(6, 220, "SVO", "LAX", 11);
    Ticket ticket7 = new Ticket(7, 150, "LED", "LAX", 9);
    Ticket ticket8 = new Ticket(8, 190, "LAX", "SVO", 9);
    Ticket ticket9 = new Ticket(9, 27, "LED", "CDG", 3);
    Ticket ticket10 = new Ticket(10, 195, "SVO", "LAX", 9);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
    }

    @Test
    public void test1() {
        Ticket[] expected = {ticket4, ticket10, ticket2, ticket6};
        Ticket[] actual = manager.findAll("SVO", "LAX");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LED", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        repo.removeById(1);
        Ticket[] expected = {ticket9, ticket7, ticket3, ticket5, ticket4, ticket8, ticket10, ticket2, ticket6};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

}
