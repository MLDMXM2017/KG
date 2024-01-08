package com.warmer.web.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class CommandHelper {

    public static String executeCommand(List<String> commands) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        StringBuilder output = new StringBuilder();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            Process process = processBuilder.start();

            // 处理标准输出流
            StreamGobbler outputStreamGobbler = new StreamGobbler(process.getInputStream(), line -> {
                System.out.println(line);
                output.append(line).append("\n");
            });

            // 处理错误流
            StreamGobbler errorStreamGobbler = new StreamGobbler(process.getErrorStream(), System.err::println);

            executor.submit(outputStreamGobbler);
            executor.submit(errorStreamGobbler);

            int exitCode = process.waitFor();
            executor.shutdown();

            if (exitCode != 0) {
                output.append("Command exited with error code: ").append(exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error executing command: " + e.getMessage();
        }

        return output.toString();
    }

    private static class StreamGobbler implements Runnable {
        private InputStreamReader inputStreamReader;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStreamReader = new InputStreamReader(inputStream);
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(inputStreamReader).lines().forEach(consumer);
        }
    }
}
