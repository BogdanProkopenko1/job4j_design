package ru.job4j.isp;

import org.junit.Test;
import ru.job4j.kiss.MaxMin;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void search() {
        Menu menu = new Menu();
        menu.addParagraph(null, new Menu.Node(1, "First 1", null));
        menu.addParagraph("First 1", new Menu.Node(1, "---Second 1", menu.search("First 1")));
        menu.addParagraph(null, new Menu.Node(1, "First 2", null));
        menu.addParagraph("---Second 1", new Menu.Node(1, "------Third 1", menu.search("---Second 1")));
        menu.addParagraph(null, new Menu.Node(1, "First 3", null));
        menu.addParagraph(null, new Menu.Node(1, "First 4", null));
        menu.addParagraph("First 2", new Menu.Node(1, "---Second 1.1", menu.search("First 2")));
        menu.addParagraph("---Second 1.1", new Menu.Node(1, "------Third 1.1", menu.search("---Second 1.1")));
        menu.addParagraph("First 2", new Menu.Node(1, "---Second 2.1", menu.search("First 2")));
        menu.addParagraph("First 1", new Menu.Node(1, "---Second 2", menu.search("First 1")));
        menu.addParagraph("---Second 2", new Menu.Node(1, "------Third 2", menu.search("---Second 2")));
        menu.addParagraph("------Third 2", new Menu.Node(1, "---------Fourth 1", menu.search("------Third 2")));
        menu.addParagraph("---------Fourth 1", new Menu.Node(1, "------------Fiver 1", menu.search("---------Fourth 1")));
        menu.addParagraph("------Third 1.1", new Menu.Node(1, "---------Fourth 1.1", menu.search("------Third 1.1")));
        menu.addParagraph("------Third 1.1", new Menu.Node(1, "---------Fourth 1.2", menu.search("------Third 1.1")));
        menu.addParagraph("---Second 2.1", new Menu.Node(1, "---------Fourth 2.1", menu.search("---Second 2.1")));
        menu.addParagraph("------Third 1", new Menu.Node(1, "---------Fourth 1", menu.search("------Third 1")));
        Menu.Node node = new Menu.Node(1, "---------------Six 1", menu.search("------------Fiver 1"));
        menu.addParagraph("------------Fiver 1", node);
        assertThat(menu.search("---------------Six 1"), is(node));
    }
}