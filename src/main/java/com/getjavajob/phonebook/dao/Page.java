package com.getjavajob.phonebook.dao;

import java.util.List;

public class Page<T> {

    private int page;
    private int size;
    private long totalPages;
    private List<T> records;
    private long totalRecords;

    public Page(long totalRecords, List<T> records, int size) {
        this.totalPages = totalRecords / size;
        if (totalPages % size > 0) {
            totalPages++;
        }

        this.records = records;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
