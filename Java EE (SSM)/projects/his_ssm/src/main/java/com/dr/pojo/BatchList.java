package com.dr.pojo;

import java.util.List;

public class BatchList {
    private List<Long> list;

    public BatchList(List<Long> list) {
        this.list = list;
    }

    public BatchList() {
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BatchList{" +
                "list=" + list +
                '}';
    }
}
