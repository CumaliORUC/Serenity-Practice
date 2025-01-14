package scenario2.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import scenario2.pages.Todo_Page;

public class todoSteps {
    private Todo_Page todo_page;

    @Step
    public void isOnTodoPage(){
        todo_page.open();
    }

    @Step
    public void addItemsToDoList(){
        todo_page.addItems();
    }

}
