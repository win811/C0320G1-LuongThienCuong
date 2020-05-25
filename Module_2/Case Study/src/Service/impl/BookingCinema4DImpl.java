package Service.impl;

import Service.BookingCinema4DInterface;
import models.Customer;

import java.util.LinkedList;
import java.util.Queue;

public class BookingCinema4DImpl implements BookingCinema4DInterface {

    private static Queue<Customer> bookingCinemaList = new LinkedList<>();

    @Override
    public void addBookingCinema(Customer customer) {
        bookingCinemaList.add(customer);
    }

    @Override
    public Queue<Customer> getAllBookingCinema() {
        return bookingCinemaList;
    }
}
