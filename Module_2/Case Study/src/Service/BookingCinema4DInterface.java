package Service;

import models.Customer;

import java.util.Queue;

public interface BookingCinema4DInterface {

    void addBookingCinema(Customer customer);

    Queue<Customer> getAllBookingCinema();

}
