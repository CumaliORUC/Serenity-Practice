package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import org.openqa.selenium.Keys;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static starter.pages.TodoPage.TODO_INPUT;

public class AddTodoItem implements Task {

    private final String item;

    public AddTodoItem(String item) {
        this.item = item;
    }

    public static AddTodoItem called(String item) {
        return instrumented(AddTodoItem.class, item);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(item).into(TODO_INPUT).thenHit(Keys.ENTER)
        );
    }
/*
    public <T extends Actor> void checkTodoItemsAndValidateCount(T actor, List<String> items) {
        actor.attemptsTo(
                forEach(items, (item, index) -> {
                    actor.attemptsTo(
                            Check.whether(TodoAppPage.CHECKBOX.at(index)).isChecked()
                    );
                    // Doğrulama: Kalan öğe sayısı
                    actor.should(
                            seeThat(Text.of(TodoAppPage.REMAINING_ITEMS_COUNT), equalTo(String.valueOf(items.size() - index - 1)))
                    );
                })
        );
    }

 */
}
