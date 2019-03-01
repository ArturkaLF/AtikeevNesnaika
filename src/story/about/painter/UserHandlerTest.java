package story.about.painter;

import story.about.painter.commands.*;

import java.util.Scanner;

public class UserHandlerTest {

    public static void getChoice(String text, GirlsHashSet girlsHashSet, String help){

        boolean link = true;

        while(link){
            Scanner in = new Scanner(System.in);
            System.out.print(text);
            String[] s = in.nextLine().replaceAll("[\\s]{2,}", " ").split(" ");
            while (    (!s[0].equalsIgnoreCase("save"))
                    && (!s[0].equalsIgnoreCase("sort"))
                    && (!s[0].equalsIgnoreCase("info"))
                    && (!s[0].equalsIgnoreCase("add"))
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

            Navigator navigator = new Navigator();

            switch (s[0]){

                case "remove":
                    Command remove;
                    try{
                        remove = new RemoveCommand(girlsHashSet,s[1]);
                        navigator.setCommand(remove);
                        navigator.go();
                        System.out.println("Элемент удален");
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Нет элемента с таким именем");
                    }
                    break;

                case "start":
                    Command start = new StartCommand(girlsHashSet);
                    navigator.setCommand(start);
                    navigator.go();
                    break;

                case "save":
                    Command save = new SaveCommand(girlsHashSet);
                    navigator.setCommand(save);
                    navigator.go();
                    break;

                case "import":
                    Command importFile;
                    try{
                        importFile = new ImportCommand(girlsHashSet,s[1]);
                        System.out.println("Файл импортирован из файла " + s[1]);
                    }catch (ArrayIndexOutOfBoundsException e1){
                        System.out.println("Файл с этим именем не найден");
                        System.out.println("Коллекция импортирована из файла test.csv");
                        importFile = new ImportCommand(girlsHashSet, "test.csv");
                    }
                    navigator.setCommand(importFile);
                    navigator.go();
                    break;

                case "help":
                    System.out.println(help);
                    break;

                case "remove_lower":
                    Command remove_lower;
                    try{
                        remove_lower = new RemoveLowerCommand(girlsHashSet,s[1]);
                    }catch (ArrayIndexOutOfBoundsException e){
                        remove_lower = new RemoveLowerCommand(girlsHashSet,"");
                    }
                    navigator.setCommand(remove_lower);
                    navigator.go();
                    break;

                case "sort":
                    Command sort = new SortCommand(girlsHashSet);
                    navigator.setCommand(sort);
                    navigator.go();
                    break;

                case "info":
                    Command info = new InfoCoomad(girlsHashSet);
                    navigator.setCommand(info);
                    navigator.go();
                    break;

                case "show":
                    Command show = new ShowCommand(girlsHashSet);
                    navigator.setCommand(show);
                    navigator.go();
                    break;

                case "add":
                    Command add;
                    try{
                        System.out.println("Элемент добавлен");
                        add = new AddCommand(girlsHashSet, s[1], s[2]);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Не было введено фразы");
                        System.out.println("Была установлена фраза: Привет");
                        try{
                            add = new AddCommand(girlsHashSet, s[1], "Привет");
                        }catch (ArrayIndexOutOfBoundsException e1){
                            add = new AddCommand(girlsHashSet, "Рома", "Привет");
                            System.out.println("Не было введено имени");
                            System.out.println("Была установлено имя: Рома");
                             }
                        }
                    navigator.setCommand(add);
                    navigator.go();
                    break;

                case "exite":
                    link = false;

            }

        }








    }

}
