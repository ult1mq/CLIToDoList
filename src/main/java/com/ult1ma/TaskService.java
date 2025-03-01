package com.ult1ma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskService {
    public static final String FILE_PATH = "./src/main/java/com/ult1ma/tasks/";
    static int cntId = 0;
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void createTask(String description) {
        Task task = new Task();
        task.setId(cntId++);
        task.setDescription(description);
        task.setStatus(TaskStatus.todo);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(task.getCreatedAt());
        try {
            mapper.writeValue(new File(FILE_PATH + task.getId() + ".json"), task);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTask(int id) {
        File file = new File(FILE_PATH + id + ".json");
        file.delete();
    }

    public static void updateTask(int id, String description) {
        try {
            Task task = mapper.readValue(new File(FILE_PATH + id + ".json"), Task.class);
            task.setDescription(description);
            task.setUpdatedAt(LocalDateTime.now());
            mapper.writeValue(new File(FILE_PATH + id + ".json"), task);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateTaskStatus(int id, TaskStatus status) {
        try {
            Task task = mapper.readValue(new File(FILE_PATH + id + ".json"), Task.class);
            task.setStatus(status);
            mapper.writeValue(new File(FILE_PATH + id + ".json"), task);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printAllTasks() {
        File folder = new File(FILE_PATH);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    Task task = mapper.readValue(file, Task.class);
                    System.out.println("|| TaskId: " + task.getId() + " || TaskDescription: " + task.getDescription() + " || TaskStatus" + task.getStatus() + " || TaskCreatedAt " + formatter.format(task.getCreatedAt()) + " || TaskUpdatedAt " + task.getUpdatedAt() + " ||");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void printTasksByStatus(TaskStatus taskStatus) {
        File folder = new File(FILE_PATH);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    Task task = mapper.readValue(file, Task.class);
                    if (task.getStatus().equals(taskStatus)) {
                        System.out.println("|| TaskId: " + task.getId() + " || TaskDescription: " + task.getDescription() + " || TaskStatus" + task.getStatus() + " || TaskCreatedAt " + formatter.format(task.getCreatedAt()) + " || TaskUpdatedAt " + task.getUpdatedAt() + " ||");

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void initialize() {
        File folder = new File(FILE_PATH);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    Task task = mapper.readValue(file, Task.class);
                    if (task.getId() >= cntId) {
                        cntId = task.getId() + 1;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public static void deleteAllTasks() {
//        System.out.println("Are you sure you want to delete all tasks? (yes/no)");
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            String answer = reader.readLine();
//            if (answer.equals("yes")) {
//                File folder = new File(FILE_PATH);
//                File[] listOfFiles = folder.listFiles();
//                for (File file : listOfFiles) {
//                    if (file.isFile()) {
//                        file.delete();
//                    }
//                }
//            }
//            else {
//                System.out.println("Operation cancelled.");
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//
//
//        File folder = new File(FILE_PATH);
//        File[] listOfFiles = folder.listFiles();
//        for (File file : listOfFiles) {
//            if (file.isFile()) {
//                file.delete();
//            }
//        }
//    }
}
