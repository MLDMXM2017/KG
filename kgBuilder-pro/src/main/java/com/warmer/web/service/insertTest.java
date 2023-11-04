package com.warmer.web.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
//引入batchinsert包
public class insertTest {
    public void batchInsertByCsvWithBatchImport(String domain, String csvUrl) {
        // CSV文件在容器内的路径
        String containerCsvPath = "/import"; // 这是你在docker-compose.yml中挂载的路径
        String nodesACsvPath = containerCsvPath + "/nodes_A.csv";
        String nodesBCsvPath = containerCsvPath + "/nodes_B.csv";
        String relationshipsCsvPath = containerCsvPath + "/relationships.csv";

        // 创建导入命令
        String cmd = "docker exec neo4j_container neo4j-admin import --database=" + domain +
                " --nodes=" + nodesACsvPath +
                " --nodes=" + nodesBCsvPath +
                " --relationships=" + relationshipsCsvPath;

        // 记录开始时间
        long startTime = System.currentTimeMillis();

        // 执行命令
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 记录结束时间
        long endTime = System.currentTimeMillis();

        // 计算时间差
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }


    public static void main(String[] args) {
        insertTest test = new insertTest();
        String domain = "test";
        String csvUrl = "C:\\Users\\208\\PycharmProjects\\pythonProject";
        test.batchInsertByCsvWithBatchImport(domain, csvUrl);
    }

}
