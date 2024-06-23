package com.keyin.rest.aircraft;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private long aircraft_ID;
    private String model;
    private String airline;
    private int capacity;
    private int rows;
    private int columns;
    private int numAisles;

    public Aircraft(long aircraft_ID, String model, String airline, int capacity, int rows, int columns, int numAisles) {
        this.aircraft_ID = aircraft_ID;
        this.model = model;
        this.airline = airline;
        this.capacity = capacity;
        this.rows = rows;
        this.columns = columns;
        this.numAisles = numAisles;

    }

    public long getAircraft_ID() {
        return aircraft_ID;
    }

    public void setAircraft_ID(long aircraft_ID) {
        this.aircraft_ID = aircraft_ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getNumAisles() {
        return numAisles;
    }

    public void setNumAisles(int numAisles) {
        this.numAisles = numAisles;
    }


    public List<String> emptySeatingChart() {
        List<String> chart = new ArrayList<>();

        // Total seats per section between aisles
        int sections = numAisles + 1;
        int seatsPerSection = columns / sections;
        int extraSeats = columns % sections;

        // Header row indicating seat labels
        StringBuilder header = new StringBuilder(" ");
        char seatLabel = 'A';
        for (int j = 0; j < sections; j++) {
            for (int k = 0; k < seatsPerSection; k++) {
                header.append(seatLabel++);
            }
            if (extraSeats > 0) {
                header.append(seatLabel++);
                extraSeats--;
            }
            if (j < numAisles) {
                header.append(" "); // Adding aisle
            }
        }
        chart.add(header.toString());

        // Reset extraSeats for row construction
        extraSeats = columns % sections;

        for (int i = 0; i < rows; i++) {
            StringBuilder row = new StringBuilder((i + 1) + ": ");
            seatLabel = 'A';
            for (int j = 0; j < sections; j++) {
                for (int k = 0; k < seatsPerSection; k++) {
                    row.append('o');
                    seatLabel++;
                }
                if (extraSeats > 0) {
                    row.append('o');
                    seatLabel++;
                    extraSeats--;
                }
                if (j < numAisles) {
                    row.append(" "); // Adding aisle
                }
            }
            chart.add(row.toString());
        }

        return chart;
    }

    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft(1, "Boeing 737", "Airline X", 150, 30, 6, 1);
        List<String> chart = aircraft.emptySeatingChart();
        for (String row : chart) {
            System.out.println(row);
        }
    }
}