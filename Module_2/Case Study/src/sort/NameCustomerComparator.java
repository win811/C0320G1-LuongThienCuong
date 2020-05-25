package sort;

import models.Customer;

import java.util.Comparator;

public class NameCustomerComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        String fullNameCustomer1 = o1.getNameCustomer();
        String lastNameCustomer1 = "";
        String fullNameCustomer2 = o2.getNameCustomer();
        String lastNameCustomer2 = "";
        for (int i = fullNameCustomer1.length() - 1 ; i > 0; i--) {
            if (fullNameCustomer1.charAt(i) == ' ') {
                break;
            }
            lastNameCustomer1 += fullNameCustomer1.charAt(i);
        }
        for (int j = fullNameCustomer2.length() - 1 ; j > 0; j--) {
            if (fullNameCustomer2.charAt(j) == ' ') {
                break;
            }
            lastNameCustomer2 += fullNameCustomer2.charAt(j);
        }
        String resultNameCustomer1 = new StringBuffer(lastNameCustomer1).reverse().toString();
        String resultNameCustomer2 = new StringBuffer(lastNameCustomer2).reverse().toString();
        if( resultNameCustomer1.compareTo(resultNameCustomer2) == 0) {
            return o1.getAge().compareTo(o2.getAge());
        }
        return resultNameCustomer1.compareTo(resultNameCustomer2);
    }
}
