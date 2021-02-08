package com.epam.engx.cleancode.finaltask.task1.thirdpartyjar;

import java.util.*;

public class DataSetImpl implements DataSet {

    static class Data{

        private String columnName;
        private Object value;

        public Data(String columnName, Object value){
            this.columnName = columnName;
            this.value = value;
        }


        public String getColumnName() {
            return columnName;
        }

        public Object getValue() {
            return value;
        }
    }

    List<Data> data = new LinkedList<>();

    @Override
    public void put(String columnName, Object value) {
        data.add(new Data(columnName, value));
    }

    @Override
    public List<String> getColumnNames(){
        List<String> result = new LinkedList<>();
        for (Data d : data) {
            result.add(d.getColumnName()) ;
        }
        return result;
    }

    @Override
    public List<Object> getValues(){
        List<Object> result = new LinkedList<>();
        for (Data d : data) {
            result.add(d.getValue());
        }
        return result;
    }

    @Override
    public String toString(){
        return "DataStr{\n" +
                "columnNames: " + getColumnNames().toString() + "\n" +
                "value: " + getValues().toString() +"\n" + "}";
    }

}