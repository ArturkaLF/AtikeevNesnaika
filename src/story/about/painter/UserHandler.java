package story.about.painter;

import story.about.painter.commands.*;
import story.about.painter.mp.LittleGirl;
import story.about.painter.mp.Message;

import java.util.Scanner;

/**
 * Класс-обработчик запросов пользователя
 *
 * @author Атикеев Роман
 * @version 1.2
 */


public class UserHandler {

    public static void getChoice(String text, GirlsHashSet girlsHashSet, String help){

        boolean link = true;

        Navigator navigator = new Navigator();

        while(link){
            Scanner in = new Scanner(System.in);
            System.out.print(text);
            String[] s = in.nextLine().replaceAll("[\\s]{2,}", " ").split(" ");
            while (    (!s[0].equalsIgnoreCase("save"))
                    && (!s[0].equalsIgnoreCase("sort"))
                    && (!s[0].equalsIgnoreCase("info"))
                    && (!s[0].equalsIgnoreCase("add"))
                    && (!s[0].equalsIgnoreCase("superInfo"))
                    && (!s[0].equalsIgnoreCase("import"))
                    && (!s[0].equalsIgnoreCase("help"))
                    && (!s[0].equalsIgnoreCase("show"))
                    && (!s[0].equalsIgnoreCase("exit"))
                    && (!s[0].equalsIgnoreCase("remove"))
                    && (!s[0].equalsIgnoreCase("remove_lower"))
                    && (!s[0].equalsIgnoreCase("start"))){
                System.out.println("Ошибка! Такой команды нет");
                System.out.print("Введите команду управления коллекцией: ");
                s = in.nextLine().replaceAll("[\\s]{2,}", " ").split(" ");
            }

            try{
                s[1] = s[1].replace("}","").replace("{","");
            }catch (ArrayIndexOutOfBoundsException ignored){}

            try {
                s[2] = s[2].replace("}","").replace("{","");
            }catch (ArrayIndexOutOfBoundsException ignored){}

            switch (s[0]){
                //паттерн позволяет нам реализовать небольшой макрос из имеющихся команд
                case "superInfo":

                    navigator.addCommand(new InfoCoomad(girlsHashSet));
                    navigator.addCommand(new ShowCommand(girlsHashSet));
                    navigator.addCommand(new SortCommand(girlsHashSet));
                    navigator.runListCommands();
                    break;

                case "remove":
                    Command remove;
                    try{
                        remove = new RemoveCommand(girlsHashSet,s[1]);
                        navigator.setCommand(remove);
                        System.out.println("Элемент удален");
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Нет элемента с таким именем");
                    }
                    break;

                case "start":
                    navigator.setCommand(new StartCommand(girlsHashSet));
                    break;

                case "save":
                    navigator.setCommand(new SaveCommand(girlsHashSet));
                    break;

                case "import":
                    try{
                        navigator.setCommand(new ImportCommand(girlsHashSet,s[1]));
                        System.out.println("Файл импортирован из файла " + s[1]);
                    }catch (ArrayIndexOutOfBoundsException e1){
                        System.out.println("Файл с этим именем не найден");
                        System.out.println("Коллекция импортирована из файла test.csv");
                        navigator.setCommand(new ImportCommand(girlsHashSet,"test.csv"));
                    }
                    break;

                case "help":
                    System.out.println(help);
                    break;

                case "remove_lower":
                    LittleGirl littleGirl;
                    try{
                        littleGirl = new LittleGirl(s[1], new Message("Hello"));
                        navigator.setCommand(new RemoveLowerCommand(girlsHashSet,littleGirl));
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Такого эдемента нет в коллекции");
                    }
                    break;

                case "sort":
                    navigator.setCommand(new SortCommand(girlsHashSet));
                    break;

                case "info":
                    Command info = new InfoCoomad(girlsHashSet);
                    navigator.setCommand(info);
                    break;

                case "show":
                    navigator.setCommand(new ShowCommand(girlsHashSet));
                    break;

                case "add":
                    try{
                        System.out.println("Элемент добавлен");
                        navigator.setCommand(new AddCommand(girlsHashSet,s[1],s[2]));
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Не было введено фразы");
                        System.out.println("Была установлена фраза: Привет");
                        try{
                            navigator.setCommand(new AddCommand(girlsHashSet,s[1],"Привет"));
                        }catch (ArrayIndexOutOfBoundsException e1){
                            navigator.setCommand(new AddCommand(girlsHashSet,"Рома","Привет"));
                            System.out.println("Не было введено имени");
                            System.out.println("Была установлено имя: Рома");
                        }
                    }
                    break;

                case "exit":
                    link = false;

            }

        }


    }

}
