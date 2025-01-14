package scenario2.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Todo_Page extends PageObject {

    @FindBy(css = "input.new-todo")
    WebElement todoInputField;

    public void addItems() {
    todoInputField.sendKeys("Buy Milk");
    }

    public static Target Add_TO_Items_Field = Target.the("Text field").locatedBy(".new-todo");
    public static Target TODO_LIST_ITEMS = Target.the("Todo list items")
            .locatedBy("ul.todo-list li");
    public static Target TOTAL_TASK_COUNT  = Target.the("Task Numbers")
            .locatedBy("//strong");
    public static Target TASK_CHECKBOX(String taskName) {
        return Target.the("Checkbox for task: " + taskName)
                .locatedBy("//label[text()='{0}']/preceding-sibling::input[@type='checkbox']")
                .of(taskName);
    }
}
