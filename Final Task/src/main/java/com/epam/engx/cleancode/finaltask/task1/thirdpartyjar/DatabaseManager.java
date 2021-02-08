package com.epam.engx.cleancode.finaltask.task1.thirdpartyjar;

import java.util.List;

public interface DatabaseManager {


    List<DataSet> getTableData(String tableName);

}