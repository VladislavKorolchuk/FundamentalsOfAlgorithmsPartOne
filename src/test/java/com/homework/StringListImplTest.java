package com.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringListImplTest {
    StringListImpl stringListImpl = new StringListImpl();

    @BeforeEach
    void setUp() {
        stringListImpl.add("Привет!");
        stringListImpl.add("Hello!");
    }

    @Test
    void add() {
        stringListImpl.add("Проверка");
        assertEquals(stringListImpl.size(), 3);

    }

    @Test
    void testAdd() {
        assertEquals(stringListImpl.get(1), "Hello!");
        stringListImpl.add(1, "Привет всем!");
        assertEquals(stringListImpl.get(1), "Привет всем!");
    }

    @Test
    void set() {
        assertEquals(stringListImpl.get(1), "Hello!");
        stringListImpl.add(1, "Привет всем!");
        assertEquals(stringListImpl.get(1), "Привет всем!");
    }

    @Test
    void remove() {
        assertEquals(stringListImpl.size(), 2);
        stringListImpl.remove("Hello!");
        assertEquals(stringListImpl.size(), 1);
    }

    @Test
    void testRemove() {
        assertEquals(stringListImpl.size(), 2);
        stringListImpl.remove(0);
        assertEquals(stringListImpl.size(), 1);
    }


    @Test
    void contains() {
        assertEquals(stringListImpl.contains("Hello!"), true);
    }

    @Test
    void indexOf() {
        assertEquals(stringListImpl.indexOf("Hello!"), 1);
    }

    @Test
    void lastIndexOf() {
        assertEquals(stringListImpl.indexOf("Привет!"), 0);
    }

    @Test
    void get() {
        assertEquals(stringListImpl.get(0), "Привет!");
    }

    @Test
    void testEquals() {
        assertEquals(stringListImpl.equals(new StringListImpl()),false);
        assertEquals(stringListImpl.equals(stringListImpl),true);
    }

    @Test
    void size() {
        assertEquals(stringListImpl.size(), 2);
    }

    @Test
    void isEmpty() {
        assertEquals(stringListImpl.isEmpty(), false);
    }

    @Test
    void clear() {
        assertEquals(stringListImpl.size(), 2);
        stringListImpl.clear();
        assertEquals(stringListImpl.size(), 0);
    }

    @Test
    void toArray() {
        assertEquals (stringListImpl.toArray().length,2);
    }
}