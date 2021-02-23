package com.epam.engx.cleancode.finaltask.task1;



import com.epam.engx.cleancode.finaltask.task1.thirdpartyjar.Command;
import com.epam.engx.cleancode.finaltask.task1.thirdpartyjar.DataSet;
import com.epam.engx.cleancode.finaltask.task1.thirdpartyjar.View;
import com.epam.engx.cleancode.finaltask.task1.thirdpartyjar.DatabaseManager;

import java.util.List;


public class Print implements Command {

    private View view;
    private DatabaseManager manager;
    private String tableName;

    public Print(View view, DatabaseManager manager) {
        this.view = view;
        this.manager = manager;
    }

    public boolean canProcess(String command) {
        return command.startsWith("print ");
    }

    public void process(String input) {
        String[] command = input.split(" ");
        if (command.length != 2) {
            throw new IllegalArgumentException("incorrect number of parameters. Expected 1, but is " + (command.length - 1));
        }
        tableName = command[1];
        List<DataSet> data = manager.getTableData(tableName);
        view.write(getTableString(data));
    }

    private String getTableString(List<DataSet> data) {
        int maxColumnSize;
        maxColumnSize = getMaxColumnSize(data);
        if (maxColumnSize == 0) {
            return getEmptyTable(tableName);
        } else {
            return getHeaderOfTheTable(data) + getStringTableData(data);
        }
    }

    private String getEmptyTable(String tableName) {
        String textEmptyTable = "║ Table '" + tableName + "' is empty or does not exist ║";
        StringBuilder result = new StringBuilder("╔");
        
        addEqualSign(result, textEmptyTable);
        
        result.append("╗\n").append(textEmptyTable).append("\n ╚");

        addEqualSign(result, textEmptyTable);
        
        result.append("╝\n");
        return result.toString();
    }
    
    private void addEqualSign(StringBuilder result, String textEmptyTable) {
        for (int i = 0; i < textEmptyTable.length() - 2; i++) {
            result.append("═");
        }
    }

    private int getMaxColumnSize(List<DataSet> dataSets) {
        int maxLength = 0;
        if (dataSets.size() > 0) {
            maxLength = getMaxColumnNameLength(dataSets);
        
        for (DataSet dataSet : dataSets) {
                List<Object> values = dataSet.getValues();
                for (Object value : values) {

                	if (String.valueOf(value).length() > maxLength) {
                            maxLength = String.valueOf(value).length();
                        }
                }
            }
          
        }
        return maxLength;
    }
    
    private int getMaxColumnNameLength(List<DataSet> dataSets) {
    	int maxLength = 0;
    	List<String> columnNames = dataSets.get(0).getColumnNames();
        for (String columnName : columnNames) {
            if (columnName.length() > maxLength) {
                maxLength = columnName.length();
            }
        }
        return maxLength;
    }

    

    private String getStringTableData(List<DataSet> dataSets) {
        int rowsCount;
        String blankSpace = " ";
        rowsCount = dataSets.size();
        int maxColumnSize = calculateMaxColumnSize(getMaxColumnSize(dataSets));
        String result = "";
       
        int columnCount = getColumnCount(dataSets);
        
        for (int row = 0; row < rowsCount; row++) {
            List<Object> values = dataSets.get(row).getValues();
        
            result += "║";
            for (int column = 0; column < columnCount; column++) {
                int valuesLength = String.valueOf(values.get(column)).length();
                if (valuesLength % 2 == 0) {
                	
					result += blankSpace.repeat((maxColumnSize - valuesLength) / 2);
                	/*
					 * for (int j = 0; j < (maxColumnSize - valuesLength) / 2; j++) { result += " ";
					 * }
					 */
                    result += String.valueOf(values.get(column));
                    result += blankSpace.repeat((maxColumnSize - valuesLength) / 2);
                    /*
					 * for (int j = 0; j < (maxColumnSize - valuesLength) / 2; j++) { result += " ";
					 * }
					 */
                    result += "║";
                } else {
                    for (int j = 0; j < (maxColumnSize - valuesLength) / 2; j++) {
                        result += " ";
                    }
                    result += String.valueOf(values.get(column));
                    for (int j = 0; j <= (maxColumnSize - valuesLength) / 2; j++) {
                        result += " ";
                    }
                    result += "║";
                }
            }
            result += "\n";
            if (row < rowsCount - 1) {
                result += "╠";
                for (int j = 1; j < columnCount; j++) {
                    for (int i = 0; i < maxColumnSize; i++) {
                        result += "═";
                    }
                    result += "╬";
                }
                for (int i = 0; i < maxColumnSize; i++) {
                    result += "═";
                }
                result += "╣\n";
            }
        }
        result += "╚";
        for (int j = 1; j < columnCount; j++) {
            for (int i = 0; i < maxColumnSize; i++) {
                result += "═";
            }
            result += "╩";
        }
        for (int i = 0; i < maxColumnSize; i++) {
            result += "═";
        }
        result += "╝\n";
        return result;
    }

    private int getColumnCount(List<DataSet> dataSets) {
        int result = 0;
        if (dataSets.size() > 0) {
            return dataSets.get(0).getColumnNames().size();
        }
        return result;
    }

    private String getHeaderOfTheTable(List<DataSet> dataSets) {
        int maxColumnSize = calculateMaxColumnSize(getMaxColumnSize(dataSets);
        String result = "";
        int columnCount = getColumnCount(dataSets);

        result += "╔";
        for (int j = 1; j < columnCount; j++) {
            for (int i = 0; i < maxColumnSize; i++) {
                result += "═";
            }
            result += "╦";
        }
        for (int i = 0; i < maxColumnSize; i++) {
            result += "═";
        }
        result += "╗\n";
        List<String> columnNames = dataSets.get(0).getColumnNames();
        for (int column = 0; column < columnCount; column++) {
            result += "║";
            int columnNamesLength = columnNames.get(column).length();
            if (columnNamesLength % 2 == 0) {
                for (int j = 0; j < (maxColumnSize - columnNamesLength) / 2; j++) {
                    result += " ";
                }
                result += columnNames.get(column);
                for (int j = 0; j < (maxColumnSize - columnNamesLength) / 2; j++) {
                    result += " ";
                }
            } else {
                for (int j = 0; j < (maxColumnSize - columnNamesLength) / 2; j++) {
                    result += " ";
                }
                result += columnNames.get(column);
                for (int j = 0; j <= (maxColumnSize - columnNamesLength) / 2; j++) {
                    result += " ";
                }
            }
        }
        result += "║\n";

        //last string of the header
        if (dataSets.size() > 0) {
            result += "╠";
            for (int j = 1; j < columnCount; j++) {
                for (int i = 0; i < maxColumnSize; i++) {
                    result += "═";
                }
                result += "╬";
            }
            for (int i = 0; i < maxColumnSize; i++) {
                result += "═";
            }
            result += "╣\n";
        } else {
            result += "╚";
            for (int j = 1; j < columnCount; j++) {
                for (int i = 0; i < maxColumnSize; i++) {
                    result += "═";
                }
                result += "╩";
            }
            for (int i = 0; i < maxColumnSize; i++) {
                result += "═";
            }
            result += "╝\n";
        }
        return result;
    }
    
    private int calculateMaxColumnSize(int maxColumnSize) {
    	if (maxColumnSize % 2 == 0) {
            maxColumnSize += 2;
        	} else {
            maxColumnSize += 3;
        	}
    	return maxColumnsize;
    }
    
}