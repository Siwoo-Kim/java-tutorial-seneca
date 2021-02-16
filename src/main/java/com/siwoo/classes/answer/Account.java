package com.siwoo.classes.answer;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class Account {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
    public static final int MAX_ADDRESSES = 2;
    private String name;
    private String email;
    private String password;
    private Cash cash;
    //max num of addresses = 2
    private final Address[] addresses = new Address[MAX_ADDRESSES]; 
    private int numOfAddress;
    private AccountType type;

    public Account(String name, String email, String password, Cash cash) {
        setEmail(email);
        setName(name);
        setPassword(password);
        setCash(cash);
        type = AccountType.valueOf(cash);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    public boolean verify(String password) {
        return this.password.equals(password);
    }

    private void setPassword(String password) {
        if (password == null)
            throw new IllegalArgumentException();
        this.password = password;
    }
    
    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException();
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null 
                || !EMAIL_PATTERN.matcher(email).matches())
            throw new IllegalArgumentException();
        this.email = email;
    }

    private void setCash(Cash cash) {
        if (cash == null) throw new IllegalArgumentException();
        this.cash = cash;
    }

//    public static void main(String[] args) {
////        Account acc = new Account("test", "test", "test", new Cash());
//        Account acc = new Account("test", "test@email.com", "test", new Cash());
//    }
    
    public void addAddress(Address address) {
        if (containsAddress(address)) return;
        if (numOfAddress == MAX_ADDRESSES) return;
        addresses[numOfAddress++] = address;
    }

//    public static void main(String[] args) {
//        Account acc = new Account("test", "test@email.com", "test", new Cash());
//        Address a1 = new Address("M5A 0N5", "Toronto", "Dundas ST", "4612", "HOUSE");
//        Address a2 = new Address("M5A 0N9", "Toronto", "Church ST", "11", "HOUSE");
//        acc.addAddress(a1);
//        acc.addAddress(a1);
//        System.out.println(acc);
//        acc.addAddress(a2);
//        System.out.println(acc);
//        Address a3 = new Address("T5A 0N9", "Toronto", "Paris ST", "444", "CONDO");
//        acc.addAddress(a3);
//        System.out.println(acc);
//    }

    private boolean containsAddress(Address address) {
        if (address == null) throw new IllegalArgumentException();
        for (int i=0; i<numOfAddress; i++)
            if (addresses[i].equals(address))
                return true;
        return false;
    }

    public void removeAddress(Address address) {
        if (!containsAddress(address)) return;
        for (int i=0; i<numOfAddress; i++)
            if (addresses[i].equals(address))
                addresses[i] = null;
        if (addresses[0] == null)
            swap(0, 1, addresses);
        numOfAddress--;
    }

//    public static void main(String[] args) {
//        Account acc = new Account("test", "test@email.com", "test", new Cash());
//        Address a1 = new Address("M5A 0N5", "Toronto", "Dundas ST", "4612", "HOUSE");
//        Address a2 = new Address("M5A 0N9", "Toronto", "Church ST", "11", "HOUSE");
//        acc.addAddress(a1);
//        acc.addAddress(a2);
//        acc.removeAddress(a2);
//        System.out.println(acc);
//        acc.addAddress(a2);
//        acc.removeAddress(a1);
//        System.out.println(acc);
//        acc.removeAddress(a2);
//        acc.removeAddress(a2);
//        acc.removeAddress(a1);
//        System.out.println(acc);
//        System.out.println(acc.numOfAddress);
//    }
    
    private void swap(int i, int j, Address[] addresses) {
        Address tmp = addresses[i];
        addresses[i] = addresses[j];
        addresses[j] = tmp;
    }
    
    public void sendMoney(Account toAccount, int amount) {
        if (toAccount == null) throw new IllegalArgumentException();
        if (!cash.hasEnoughMoney(amount)) throw new IllegalArgumentException();
        if (!type.canSend()) throw new IllegalArgumentException();
        withdraw(amount);
        toAccount.deposit(amount);
    }

    private void deposit(int amount) {
        cash.deposit(amount);
        type = AccountType.valueOf(cash);
    }

    private void withdraw(int amount) {
        cash.withdraw(amount);
        type = AccountType.valueOf(cash);
    }

//    public static void main(String[] args) {
////        Account from = new Account("test", "test@email.com", "test", new Cash(5));
////        Account to = new Account("test", "test@email.com", "test", new Cash(100));
////        from.sendMoney(to, 5); //should fail - not enough precedence
//
////        Account from = new Account("test", "test@email.com", "test", new Cash(10));
////        Account to = new Account("test", "test@email.com", "test", new Cash(100));
////        from.sendMoney(to, 15); //should fail - not enough money
//
//        Account from = new Account("test", "test@email.com", "test", new Cash(990));
//        Account to = new Account("test", "test@email.com", "test", new Cash(100));
//        from.sendMoney(to, 980); 
//        System.out.println(from);   // GOLD -> BRONZE
//        System.out.println(to);     // SILVER -> GOLD
//    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cash=" + cash +
                ", type=" + type +
                '}';
    }
}

enum AccountType {
    BRONZE(3, 0), 
    SILVER(2, 100), 
    GOLD(1, 1000);
    private final int SEND_PRECEDENCE = 2;
    // less precedence will have more precedence
    private final int precedence;
    private final int cashThreshold;

    AccountType(int precedence, int cashThreshold) {
        this.precedence = precedence;
        this.cashThreshold = cashThreshold;
    }
    
    public static AccountType valueOf(Cash cash) {
        if (cash == null) throw new IllegalArgumentException();
        if (GOLD.cashThreshold <= cash.amount())
            return GOLD;
        if (SILVER.cashThreshold <= cash.amount())
            return SILVER;
        else
            return BRONZE;
    }

    public boolean canSend() {
        return this.precedence <= SEND_PRECEDENCE;
    }
}

class Address {
    enum Type {
        HOUSE, CONDO
    }
    private final String postalCode;
    private final String city;
    private final String street;
    private final String unit;
    private final Type type;

    public Address(String postalCode, String city, String street, String unit, String type) {
        for (String arg: Arrays.asList(postalCode, city, street, unit, type))
            if (arg == null)
                throw new IllegalArgumentException();
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.unit = unit;
        this.type = Type.valueOf(type);
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getUnit() {
        return unit;
    }

    public String getType() {
        return type.toString();
    }
    
    public boolean isHouse() {
        return Type.HOUSE == type;
    }
    
    public boolean isCondo() {
        return Type.CONDO == type;
    }

    public boolean isSameCity(Address address) {
        if (address == null) throw new IllegalArgumentException();
        return this.city.equals(address.city);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(unit, address.unit) &&
                Objects.equals(type, address.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, city, street, unit, type);
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", unit='" + unit + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class Cash {
    private int amount;

    public Cash(int amount) {
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    public boolean hasEnoughMoney(int amount) {
        return this.amount >= amount;
    }

    public void deposit(int amount) {
        if (amount < 0) throw new IllegalArgumentException();
        this.amount += amount;
    }

    public void withdraw(int amount) {
        if (amount < 0) throw new IllegalArgumentException();
        if (this.amount < amount) throw new IllegalArgumentException();
        this.amount -= amount;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "amount=" + amount +
                '}';
    }
}
