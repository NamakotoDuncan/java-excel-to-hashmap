/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mdist.reader.excelreader;

import org.mdist.reader.utils.ExcelInfo;
import org.mdist.reader.utils.ExcelReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author paul
 */
public class Main {

    public static final String SAMPLE_XLSX_FILE_PATH = "UB-section-table.xlsx";
    public static final String FILE_PATH = "ub.xls";

    public static void main(String[] args) throws Exception {
        HashMap<Integer, String[]> hmap1 = excelDocumentMap(SAMPLE_XLSX_FILE_PATH);
        HashMap<Integer, String[]> hmap2 = excelDocumentMap(FILE_PATH);

        for (Map.Entry<Integer, String[]> entry : hmap1.entrySet()) {
            Integer key = entry.getKey();
            String[] value = entry.getValue();
            System.out.println(key);
            System.out.println(Arrays.toString(value));
        }

        /*for (Map.Entry<Integer, String[]> entry : hmap2.entrySet()) {
            Integer key = entry.getKey();
            String[] value = entry.getValue();
            System.out.println(key);
            System.out.println(Arrays.toString(value));
        }*/
    }

    private static HashMap<Integer, String[]> excelDocumentMap(String Filename) throws Exception {
        HashMap<Integer, String[]> hmap = new HashMap<Integer, String[]>();
        ExcelReader excelReader = new ExcelReader();
        ExcelInfo info = excelReader.readExcel(Filename, 1);
        for (int i = 0; i < info.getResultSet().size(); i++) {
            int row = i + 1;
            String[] values = new String [info.getResultSet().get(i).getRow().size()];
            for (int j = 0; j < info.getResultSet().get(i).getRow().size(); j++) {
                //  int cell = j + 1;
                //values[j] = (info.getResultSet().get(i).getRow().get(j));
                values[j] = (info.getResultSet().get(i).getRow().get(j));
            }
            hmap.put(row, values);
        }

        return hmap;
    }
}
