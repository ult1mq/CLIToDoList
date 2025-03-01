package com.ult1ma;

import java.io.File;

public class CLITaskManager {
    public static void main(String[] args) {
        TaskService.initialize();
        CommandLineHandler.run(args);
    }
}