package story.about.painter;

import story.about.painter.commands.Command;
import story.about.painter.commands.ImportCommand;
import story.about.painter.commands.Navigator;
import story.about.painter.commands.SaveCommand;
import story.about.painter.mp.LittleGirl;

public class Main {
    public static void main(String[] args) {

        // история вывода команд

        final String HELP = "           Команды для интерактивного управления коллекцией \n" +
                "add {element phrase}:   |добавить новый элемент в коллекцию.\n" +
                "show:                   |вывести в стандартный поток вывода все элементы коллекции в строковом представлении.\n" +
                "import {path}:          |добавить в коллекцию все данные из файла.\n" +
                "save:                   |сохранить коллекцию в файл.\n" +
                "sort:                   |вывод итсортированного список элементов коллекции.\n" +
                "info:                   |вывести в стандартный поток вывода основную информацию о коллекции.\n" +
                "remove {element}:       |удалить элемент из коллекции по его значению.\n" +
                "remove_lower {element}: |удалить из коллекции все элементы, меньшие, чем заданный.\n" +
                "start:                  |запустить основную программу для настроенной коллекции.\n" +
                "exit:                   |выход из программы (сохранение текущей коллекции в файл)\n" +
                "help:                   |вывод списка доступных команд.\n";

        Navigator navigator = new Navigator();

        GirlsHashSet<LittleGirl> girlGirlsHashSet = new GirlsHashSet<>();

        Command importFile;
        try {
            importFile = new ImportCommand(girlGirlsHashSet,args[0]);
        }catch (ArrayIndexOutOfBoundsException e){
            importFile = new ImportCommand(girlGirlsHashSet,"test.csv");
        }
        navigator.setCommand(importFile);

        System.out.println(HELP);
        UserHandler.getChoice("Введите команду управления коллекцией: ", girlGirlsHashSet, HELP);

        Command save = new SaveCommand(girlGirlsHashSet);
        navigator.setCommand(save);

    }
}