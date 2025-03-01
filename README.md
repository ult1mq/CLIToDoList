ProjectURL - https://github.com/ult1mq/CLIToDoList
# CLIToDoList
[RU]
CLITaskManager
Документация проекта: CLITaskManager
Обзор
TaskTrackerCLI - это приложение командной строки (CLI) для управления задачами. Оно позволяет пользователям создавать, обновлять, удалять и перечислять задачи с различными статусами.  
Требования
Java 21
Maven
Настройка
Клонируйте репозиторий:  
git clone <repository-url>
cd TaskTrackerCLI
Соберите проект:  
mvn clean install
Запуск приложения
Для запуска приложения выполните следующую команду:
mvn exec:java -Dexec.mainClass='com.ult1ma.CLITaskManager'

Доступные команды:
/add <описание>: Добавляет новую задачу с указанным описанием.
/delete <id>: Удаляет задачу с указанным идентификатором.
/update <id> <новое описание>: Обновляет задачу с указанным идентификатором, задавая новое описание.
/list-all: Перечисляет все задачи.
/mark-done <id>: Помечает задачу с указанным идентификатором как выполненную.
/mark-todo <id>: Помечает задачу с указанным идентификатором как "в процессе".
/mark-inprogress <id>: Помечает задачу с указанным идентификатором как "в работе".
/list-todo: Перечисляет все задачи со статусом "в процессе".
/list-inprogress: Перечисляет все задачи со статусом "в работе".
/list-done: Перечисляет все задачи со статусом "выполнено".
/help: Отображает список доступных команд.
/exit: Выход из приложения.
Пример использования
Добавить новую задачу:  
/add Завершить документацию проекта
Перечислить все задачи:  
/list-all
Обновить задачу:  
/update 1 Обновить документацию проекта
Пометить задачу как выполненную:  
/mark-done 1
Удалить задачу:  
/delete 1
Структура проекта
src/main/java/com/ult1ma/CLITaskManager.java: Главный класс для запуска приложения.
src/main/java/com/ult1ma/CommandLineHandler.java: Обрабатывает ввод и команды пользователя.
src/main/java/com/ult1ma/TaskService.java: Содержит методы для операций с задачами (создание, обновление, удаление, перечисление).
src/main/java/com/ult1ma/Task.java: Класс модели задачи.
src/main/java/com/ult1ma/TaskStatus.java: Перечисление для статусов задач.
Зависимости
Проект использует следующие зависимости:  
jackson-databind: Для сериализации и десериализации JSON.
jackson-datatype-jsr310: Для обработки типов даты/времени Java 8.
Эти зависимости указаны в файле pom.xml.
Примечания
Убедитесь, что FILE_PATH в TaskService правильно установлен в директорию, где будут храниться файлы задач.
Приложение использует JSON файлы для хранения данных задач. Каждая задача сохраняется как отдельный JSON файл в указанной директории.


[ENG]
Overview
TaskTrackerCLI is a command-line interface (CLI) application for managing tasks. It allows users to create, update, delete, and list tasks with different statuses.  
Prerequisites
Java 21
Maven
Setup
Clone the repository:  
git clone <repository-url>
cd TaskTrackerCLI
Build the project:  
mvn clean install
Running the Application
To start the application, run the following command:
mvn exec:java -Dexec.mainClass="com.ult1ma.CLITaskManager"

Available Commands
/add <description>: Adds a new task with the given description.
/delete <id>: Deletes the task with the specified ID.
/update <id> <new description>: Updates the task with the specified ID to have the new description.
/list-all: Lists all tasks.
/mark-done <id>: Marks the task with the specified ID as done.
/mark-todo <id>: Marks the task with the specified ID as todo.
/mark-inprogress <id>: Marks the task with the specified ID as in progress.
/list-todo: Lists all tasks with the status "todo".
/list-inprogress: Lists all tasks with the status "in progress".
/list-done: Lists all tasks with the status "done".
/help: Displays the list of available commands.
/exit: Exits the application.
Example Usage
Add a new task: 
/add Finish the project documentation
List all tasks:  
/list-all
Update a task:  
/update 1 Update the project documentation
Mark a task as done:  
/mark-done 1
Delete a task:  
/delete 1
Project Structure
src/main/java/com/ult1ma/CLITaskManager.java: Main class to start the application.
src/main/java/com/ult1ma/CommandLineHandler.java: Handles user input and commands.
src/main/java/com/ult1ma/TaskService.java: Contains methods for task operations (create, update, delete, list).
src/main/java/com/ult1ma/Task.java: Task model class.
src/main/java/com/ult1ma/TaskStatus.java: Enum for task statuses.
Dependencies
The project uses the following dependencies:  
jackson-databind: For JSON serialization and deserialization.
jackson-datatype-jsr310: For handling Java 8 date/time types.
These dependencies are specified in the pom.xml file.
Notes
Ensure that the FILE_PATH in TaskService is correctly set to the directory where task files will be stored.
The application uses JSON files to store task data. Each task is saved as a separate JSON file in the specified directory.
