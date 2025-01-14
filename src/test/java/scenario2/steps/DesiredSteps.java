package scenario2.steps;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;
import org.openqa.selenium.Keys;
import scenario2.pages.Todo_Page;

public class DesiredSteps {
    public static Performable goTotheTodoPage() {
        return Task.where("{0} opens the TodoList home page",
                Open.browserOn().the(Todo_Page.class));
    }

    public static Performable addItems(String item) {
        return Task.where( "{0} Enter the items to do List",Enter.theValue(item).into(Todo_Page.Add_TO_Items_Field)
                        .thenHit(Keys.ENTER)
        );
    }

    public static Performable verifyItemIsAdded(String item) {
        return Ensure.that(Todo_Page.TODO_LIST_ITEMS)
                .textValues().contains(item);
    }

    public static Performable verifyTotalTaskCount() {
        return Task.where("{0} verifies total task count matches the list size",
                actor -> {
                    // Get the number of tasks in the list
                    int listSize = Todo_Page.TODO_LIST_ITEMS.resolveAllFor(actor).size();

                    // Get the displayed total task count
                    String displayedCountText = TextContent.of(Todo_Page.TOTAL_TASK_COUNT).answeredBy(actor);
                    int displayedCount = Integer.parseInt(displayedCountText);

                    // Assert they match
                    Ensure.that(listSize).isEqualTo(displayedCount).performAs(actor);
                }
        );
    }

    public static Performable checkTaskAsCompleted(String taskName) {
        return Task.where("{0} checks the task '" + taskName + "' as completed",
                Click.on(Todo_Page.TASK_CHECKBOX(taskName))
        );
}

}
