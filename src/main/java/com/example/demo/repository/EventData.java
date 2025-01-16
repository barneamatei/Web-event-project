package com.example.demo.repository;

import com.example.demo.model.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    private static final Map<Integer, Event> events = new HashMap<>();
    private static int nextId = 1; // Mutăm gestionarea ID-ului aici

    public static Collection<Event> getAll() {
        return events.values();
    }

    public static Event getById(int id) {
        return events.get(id);
    }


    public static void remove(int id) {
        events.remove(id);
    }
}
