package me.mkweb.techtalk.util;

import me.mkweb.techtalk.util.internal.*;
import me.mkweb.techtalk.util.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Mario Kunz
 */
public final class Mock {
    private static final Repository<Company> COMPANY_REPOSITORY = CompanyRepository.INSTANCE;
    private static final Repository<Customer> CUSTOMER_REPOSITORY = CustomerRepository.INSTANCE;
    private static final Repository<Employee> EMPLOYEE_REPOSITORY = EmployeeRepository.INSTANCE;
    private static final Repository<Order> ORDER_REPOSITORY = OrderRepository.INSTANCE;
    public static final Repository<Address> ADDRESS_REPOSITORY = AddressRepository.INSTANCE;

    // region Addresses
    public static final Address LAKE_ZURICH = new Address("Cherry Road", 19, "Lake Zurich", "Illinois", 60047, "USA");
    public static final Address NEW_BERN = new Address("Trent Road", 35, "New Bern", "North Carolina", 28562, "USA");
    public static final Address NEW_BERN_2 = new Address("Fox Horn Road", 12, "New Bern", "North Carolina", 28562, "USA");
    public static final Address FAYETTEVILLE = new Address("Glensford Drive", 34, "Fayetteville", "North Carolina", 28301, "USA");
    public static final Address FAYETTEVILLE_2 = new Address("Glensford Drive", 33, "Fayetteville", "North Carolina", 28301, "USA");
    public static final Address NEW_YORK = new Address("Wall Street", 6, "New York", "New York", 10005, "USA");
    // endregion

    // region Customers
    public static final Customer FRANK = new Customer("Francis", "Underwood", NEW_BERN, 54, new ArrayList<>());
    public static final Customer FINCH = new Customer("Harold", "Finch", NEW_BERN_2, 62, new ArrayList<>());
    public static final Customer JOHN = new Customer("John", "Reese", LAKE_ZURICH, 39, new ArrayList<>());
    public static final Customer REMY = new Customer("Remy", "Danton", FAYETTEVILLE, 39, new ArrayList<>());
    public static final Customer GARRET = new Customer("Garret", "Walker", FAYETTEVILLE_2, 48, new ArrayList<>());
    public static final Customer GREER = new Customer("John", "Greer", NEW_YORK, 75, new ArrayList<>());
    // endregion

    // region Employees
    public static final Employee RAYMOND = new Employee("Raymond", "Tusk", NEW_BERN, 63, 1000000);
    public static final Employee PATRICK = new Employee("Patrick", "Lloyd", NEW_BERN, 53, 245242);
    public static final Employee NESTOR = new Employee("Nestor", "Lozano", NEW_BERN, 27, 12000);
    // endregion

    // region Companies
    public static final Company CLAYTON_WEST = new Company("Clayton West", asList(RAYMOND), asList(GARRET));
    public static final Company BROWNING_REED = new Company("Browning Reed", asList(PATRICK, NESTOR), asList());
    // endregion

    public static final Order CHICKEN = new Order(FRANK, RAYMOND, "100kg of Chicken");
    public static final Order BROCOLI = new Order(REMY, RAYMOND, "1 piece of Brocoli");
    public static final Order THE_MACHINE = new Order(FINCH, PATRICK, "The machine of POI");
    public static final Order SAMARITAN = new Order(GREER, NESTOR, "Samaritan");

    public static void init() {
        CUSTOMER_REPOSITORY.save(getFieldsByType(Customer.class));
        EMPLOYEE_REPOSITORY.save(getFieldsByType(Employee.class));
        COMPANY_REPOSITORY.save(getFieldsByType(Company.class));
        ORDER_REPOSITORY.save(getFieldsByType(Order.class));
        ADDRESS_REPOSITORY.save(getFieldsByType(Address.class));
    }

    private static <T> List<T> getFieldsByType(Class<T> clazz) {
        return Arrays.stream(Mock.class.getDeclaredFields())
                .filter(field -> field.getType().equals(clazz))
                .map(field -> {
                    try {
                        return (T) field.get(null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
