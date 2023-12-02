package uniandes.edu.co.proyecto;

import uniandes.edu.co.proyecto.model.Hotel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

    private Hotel hotel;

    @BeforeEach
    public void setUp() {
        hotel = new Hotel(1, "Hotel Luna", "123 Calle Sol", "Bogota", "Colombia");
    }

    @Test
    public void testConstructor() {
        assertEquals(1, hotel.getId());
        assertEquals("Hotel Luna", hotel.getNombre());
        assertEquals("123 Calle Sol", hotel.getDireccion());
        assertEquals("Bogota", hotel.getCiudad());
        assertEquals("Colombia", hotel.getPais());
    }

    @Test
    public void testSettersAndGetters() {
        hotel.setId(2);
        assertEquals(2, hotel.getId());

        hotel.setNombre("Hotel Sol");
        assertEquals("Hotel Sol", hotel.getNombre());

        hotel.setDireccion("456 Calle Luna");
        assertEquals("456 Calle Luna", hotel.getDireccion());

        hotel.setCiudad("Medellin");
        assertEquals("Medellin", hotel.getCiudad());

        hotel.setPais("Argentina");
        assertEquals("Argentina", hotel.getPais());
    }

}
