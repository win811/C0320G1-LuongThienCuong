package Service.impl;

import Service.BookingCinema4DInterface;
import models.Customer;

import java.util.LinkedList;
import java.util.Queue;

public class BookingCinema4DImpl implements BookingCinema4DInterface {

    private static Queue<Customer> bookingCinemaQueue = new LinkedList<>();

    @Override
    public void addBookingCinema(Customer customer) {
        bookingCinemaQueue.add(customer);
    }

    @Override
    public Queue<Customer> getAllBookingCinema() {
        return bookingCinemaQueue;
    }
}
