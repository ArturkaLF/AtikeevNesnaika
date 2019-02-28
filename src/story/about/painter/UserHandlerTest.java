package story.about.painter;

import story.about.painter.commands.AddCommand;

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

            String[] finalS = s;

            switch (s[0]){

                case "super":


                case "remove_lower":
                    navigator.setCommand(()->{
                        try{
                            girlsHashSet.remove_lower(finalS[1]);
                        }catch (ArrayIndexOutOfBoundsException e1){
                            girlsHashSet.remove("");
                        }
                    });
                    navigator.go();
                    break;

                case "sort":
                    navigator.setCommand(()->{
                        System.out.println(girlsHashSet.sortedList());
                    });
                    navigator.go();
                    break;

                case "info":
                    navigator.setCommand(()->{
                        System.out.println(girlsHashSet.info());
                    });
                    navigator.go();
                    break;

                case "show":
                    navigator.setCommand(()->{
                        System.out.println(girlsHashSet.show());
                    });
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
                    navigator.setCommand();
                    navigator.go();
                    break;

                case "exite":
                    link = false;

            }

        }







    //        if(s[0].equals("save")){
    //            girlsHashSet.save();
    //        }
    //        else if(s[0].equals("sort")){
    //            System.out.println(girlsHashSet.sortedList());
    //        }
    //        else if(s[0].equals("info")){
    //            System.out.println(girlsHashSet.info());
    //        }
    //        else if(s[0].equals("remove_lower")){
    //            try{
    //                girlsHashSet.remove_lower(s[1]);
    //            }catch (ArrayIndexOutOfBoundsException e1){
    //                girlsHashSet.remove("");
    //            }
    //        }
    //        else if(s[0].equals("show")){
    //            System.out.println(girlsHashSet.show());
    //        }
    //        else if(s[0].equals("help")){
    //            System.out.println(help);
    //        }
    //        else if(s[0].equals("import")){
    //            try{
    //
    //
    //                girlsHashSet.import_file(s[1]);
    //            }catch (ArrayIndexOutOfBoundsException e1){
    //                girlsHashSet.import_file("test.csv");
    //            }
    //        }
    //        else if(s[0].equals("remove")){
    //            girlsHashSet.remove(s[1]);
    //        }
    //        else if(s[0].equals("start")){
    //            System.out.println("----------------------------------------\n");
    //            UserHandler.startMainProgram(girlsHashSet);
    //            System.out.println("----------------------------------------\n");
    //        }
    //        else if(s[0].equals("exit")){
    //            System.out.println("Конец сеанса!!!");
    //            System.out.println("Данные сохранены в Out.json");
    //            return false;
    //        }
    //        return true;
    }

}