package me.mkweb.techtalk.model;

/**
 * @author Mario Kunz
 */
public final class Mock {
    public static final Address LAKE_ZURICH = new Address("Cherry Road", 19, "Lake Zurich", 60047, "USA");
    public static final Address NEW_BERN = new Address("Trent Road", 35, "New Bern", 28562, "USA");

    public static final Person FRANK = new Person("Francis", "Underwood", NEW_BERN, 54);
    public static final Person JOHN = new Person("John", "Reese", LAKE_ZURICH, 39);

    private Mock() {
    }
}
