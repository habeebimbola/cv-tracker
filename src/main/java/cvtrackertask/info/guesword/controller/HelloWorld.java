package cvtrackertask.info.guesword.controller;

import cvtrackertask.info.guesword.domain.Word;

import java.util.Comparator;
import java.util.function.Predicate;

public class HelloWorld<W> extends MyClass implements Predicate<Word>, Comparator<Word>
{
    @Override
    public  boolean test(Word word) {
        return word.getContent().matches("^\\w+$");
    }

    @Override
    public int compare(Word o1, Word o2) {
        return o1.getLength().compareTo(o2.getLength());
    }

    public int sort(Word word, Word word2){
        return this.compare(word, word2);
    }

    public static void show()
    {
        System.out.println("In MyClass");
    }

}