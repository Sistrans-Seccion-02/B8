package uniandes.edu.co.proyecto;

import uniandes.edu.co.proyecto.model.Servicio;
import uniandes.edu.co.proyecto.model.Hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioTest {

    private Servicio servicio;
    private Hotel mockHotel;

    @BeforeEach
    public void setUp() {
        mockHotel = new Hotel(1, "Hotel Prueba", "123 Calle de Test", "Ciudad Test", "País Test");
        servicio = new Servicio(50.0f, 100.0f, "Spa", mockHotel);
    }

    @Test
    public void testConstructor() {
        assertEquals(50.0f, servicio.getCapacidad());
        assertEquals(100.0f, servicio.getCostoDanios());
        assertEquals("Spa", servicio.getNombre());
        assertEquals(mockHotel, servicio.getHotel());
    }

    @Test
    public void testSettersAndGetters() {
        servicio.setCapacidad(60.0f);
        assertEquals(60.0f, servicio.getCapacidad());

        servicio.setCostoDanios(110.0f);
        assertEquals(110.0f, servicio.getCostoDanios());

        servicio.setNombre("Piscina");
        assertEquals("Piscina", servicio.getNombre());

        Hotel anotherHotel = new Hotel(2, "Hotel Dos", "456 Calle Dos", "Ciudad Dos", "País Dos");
        servicio.setHotel(anotherHotel);
        assertEquals(anotherHotel, servicio.getHotel());
    }
}
