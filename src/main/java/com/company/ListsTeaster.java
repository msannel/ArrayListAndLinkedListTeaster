package com.company;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;



/**
 * Tester of speed of working of add, remove and get methods  for List
 */
class ListsTester {
    private List<String> list;
    private Instant start,end;
    private int NumberOfElements;
    private String value;

    /**
     * Constructor with parameters
     * @param _list tested List
     * @param _NumberOfElements Number of elements
     * @param _value used value for insertion
     */
    ListsTester(List<String> _list, int _NumberOfElements, String _value) {
        this.list = _list;
        this.NumberOfElements = _NumberOfElements;
        this.value = _value;
    }

    /**
     * Measurement of the time required
     * to add 'NumberOfElements' items to the end of the list.
     * @return Time spent
     */
    public long testAdd(){
        list.clear();
        if (list instanceof ArrayList)
            ((ArrayList<String>) list).trimToSize();

        start = Instant.now();
        for (int i = 0; i < NumberOfElements; i++)
            list.add(value);
        end = Instant.now();

        return Duration.between(start,end).toNanos()/1000;
    }

    /**
     * Measurement of the time required
     * to add 'NumberOfElements' items to the determined index of the list.
     * (Used for test add in the beginning).
     * @param index - index of insertion
     * @return Time spent
     */
    public long testAdd(int index){
        list.clear();
        if (list instanceof ArrayList)
            ((ArrayList<String>) list).trimToSize();

        start = Instant.now();
        for (int i = 0; i < NumberOfElements; i++)
            list.add(index, value);
        end = Instant.now();

        return Duration.between(start,end).toNanos()/1000;
    }

    /**
     * Measurement of the time required
     * to add 'NumberOfElements' items to the middle of the list.
     * @return Time spent
     */
    public long testAddMiddle(){
        list.clear();
        if (list instanceof ArrayList)
            ((ArrayList<String>) list).trimToSize();

        start = Instant.now();
        for (int i = 0; i < NumberOfElements; i++)
            list.add(i/2,value);
        end = Instant.now();

        return Duration.between(start,end).toNanos()/1000;
    }

    /**
     * Fills list with the 'NumberOfElements' number of elements
     */
    public void fill(){
        while (list.size() < NumberOfElements)
            list.add(value);
    }

    /**
     * Measurement of the time required
     * to get 'NumberOfElements' items to the determined index of the list.
     * @param index - index of insertion
     * @return Time spent
     */
    public long testGetByIndex(int index){
        if (list.size() < NumberOfElements)
            fill();

        start = Instant.now();
        for (int i = 0; i < NumberOfElements; i++)
            list.get(index);
        end = Instant.now();

        return Duration.between(start,end).toNanos()/1000;
    }

    /**
     * Measurement of the time required
     * to get 'NumberOfElements' items to the middle of the list.
     * @return Time spent
     */
    public long testGetMiddle(){
        if (list.size() < NumberOfElements)
            fill();

        start = Instant.now();
        for (int i = 0; i < NumberOfElements; i++)
            list.get(i/2);
        end = Instant.now();

        return Duration.between(start,end).toNanos()/1000;
    }

    /**
     * Measurement of the time required
     * to remove 'NumberOfElements' items to the end of the list.
     * @return Time spent
     */
    public long testRemove(){

        if (list.size() < NumberOfElements)
            fill();
        int numberOfTests = this.NumberOfElements - 1;
        start = Instant.now();
        do {
            list.remove(numberOfTests);
        } while (--numberOfTests > 0);
        end = Instant.now();

        return Duration.between(start,end).toNanos()/1000;
    }

    /**
     * Measurement of the time required
     * to remove 'NumberOfElements' items to the determined index of the list.
     * (Used for test remove in the beginning).
     * @param index - index of insertion
     * @return Time spent
     */
    public long testRemove(int index){
        if (list.size() < NumberOfElements)
            fill();

        start = Instant.now();
        for (int i = 0; i < NumberOfElements; i++)
            list.remove(index);
        end = Instant.now();

        return Duration.between(start,end).toNanos()/1000;
    }

    /**
     * Measurement of the time required
     * to remove 'NumberOfElements' items to the middle of the list.
     * @return Time spent
     */
    public long testRemoveMiddle( ){
        if (list.size() < NumberOfElements)
            fill();

        start = Instant.now();
        for (int i = NumberOfElements -1; i > 0; i--)
            list.remove(i/2);
        end = Instant.now();

        return Duration.between(start,end).toNanos()/1000;
    }
}
