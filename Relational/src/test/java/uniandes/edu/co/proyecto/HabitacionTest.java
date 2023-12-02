package uniandes.edu.co.proyecto;

import uniandes.edu.co.proyecto.model.Habitacion;
import uniandes.edu.co.proyecto.model.TipoHabitacion;
import uniandes.edu.co.proyecto.model.Hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HabitacionTest {

    private Habitacion habitacion;

    @BeforeEach
    public void setUp() {
        TipoHabitacion mockTipo = new TipoHabitacion();
        Hotel mockHotel = new Hotel();
        habitacion = new Habitacion(101, mockTipo, true, true, false, 5, mockHotel);
    }

    @Test
    public void testConstructor() {
        assertEquals(101, habitacion.getNumero());
        assertNotNull(habitacion.getTipohabitacion());
        assertTrue(habitacion.getTelevision());
        assertTrue(habitacion.getMinibar());
        assertFalse(habitacion.getCafetera());
        assertEquals(5, habitacion.getDiasestadia());
        assertNotNull(habitacion.getHotel());
    }

    @Test
    public void testSettersAndGetters() {
        habitacion.setNumero(102);
        assertEquals(102, habitacion.getNumero());

        TipoHabitacion anotherTipo = new TipoHabitacion();
        habitacion.setTipohabitacion(anotherTipo);
        assertEquals(anotherTipo, habitacion.getTipohabitacion());

        habitacion.setTelevision(false);
        assertFalse(habitacion.getTelevision());

        habitacion.setMinibar(false);
        assertFalse(habitacion.getMinibar());

        habitacion.setCafetera(true);
        assertTrue(habitacion.getCafetera());

        habitacion.setDiasestadia(7);
        assertEquals(7, habitacion.getDiasestadia());

        Hotel anotherHotel = new Hotel();
        habitacion.setHotel(anotherHotel);
        assertEquals(anotherHotel, habitacion.getHotel());
    }

}
