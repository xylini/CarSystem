package agh.cs.lab2;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {
    @Test
    public void nextTest(){
        assertEquals(agh.cs.lab2.MapDirection.North.next(), agh.cs.lab2.MapDirection.East);
    }
}