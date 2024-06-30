package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import com.keyin.cli.api.models.Booking;
public class BookingTest {

    @Test
    public void testConstructorAndGetters() {
        long bookingId = 1;
        long flightId = 101;
        long passengerId = 201;
        int seatRow = 10;
        int seatColumn = 5;

        Booking booking = new Booking(bookingId, flightId, passengerId, seatRow, seatColumn);

        assertEquals(bookingId, booking.getBooking_ID());
        assertEquals(flightId, booking.getFlight_ID());
        assertEquals(passengerId, booking.getPassenger_ID());
        assertEquals(seatRow, booking.getSeatRow());
        assertEquals(seatColumn, booking.getSeatColumn());
    }

    @Test
    public void testSetters() {
        Booking booking = new Booking();

        long bookingId = 2;
        long flightId = 102;
        long passengerId = 202;
        int seatRow = 20;
        int seatColumn = 10;

        booking.setBooking_ID(bookingId);
        booking.setFlight_ID(flightId);
        booking.setPassenger_ID(passengerId);
        booking.setSeatRow(seatRow);
        booking.setSeatColumn(seatColumn);

        assertEquals(bookingId, booking.getBooking_ID());
        assertEquals(flightId, booking.getFlight_ID());
        assertEquals(passengerId, booking.getPassenger_ID());
        assertEquals(seatRow, booking.getSeatRow());
        assertEquals(seatColumn, booking.getSeatColumn());
    }

    @Test
    public void testToString() {
        long bookingId = 3;
        long flightId = 103;
        long passengerId = 203;
        int seatRow = 15;
        int seatColumn = 6;

        Booking booking = new Booking(bookingId, flightId, passengerId, seatRow, seatColumn);

        String expectedToString = "Bookings - ID: 3, Flight ID: 103, Passenger ID: 203, Seat Row: 15, Seat Column: 6.";
        String actualToString = booking.toString();

        assertNotNull(actualToString);
        assertEquals(expectedToString, actualToString);
    }

    @Test
    public void testMockitoExample() {
        // Mocking an object using Mockito
        Booking mockBooking = mock(Booking.class);

        // Setting up behavior
        when(mockBooking.getBooking_ID()).thenReturn(10L);
        when(mockBooking.getFlight_ID()).thenReturn(100L);

        // Verification
        assertEquals(10L, mockBooking.getBooking_ID());
        assertEquals(100L, mockBooking.getFlight_ID());
    }
}
