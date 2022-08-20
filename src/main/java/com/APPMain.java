package com;

import src.afsql.db.AfSimpleDB;

import java.util.List;
import java.util.Map;

public class APPMain {
    public static void main(String[] args) throws Exception {
        String sql = "select AVG(Sid) from student";
        List<Map> query = AfSimpleDB.query(sql, 0);
        for (Map map : query) {
            System.out.println(map.toString());
        }
    }
}
