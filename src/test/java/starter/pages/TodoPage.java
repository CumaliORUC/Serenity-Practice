package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class TodoPage extends PageObject {
    public static final Target TODO_INPUT = Target.the("todo input field")
            .locatedBy(".new-todo");

    public static final Target TODO_LIST = Target.the("todo list")
            .locatedBy(".todo-list");
}
