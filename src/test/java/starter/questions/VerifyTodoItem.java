package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static starter.pages.TodoPage.TODO_LIST;

public class VerifyTodoItem implements Question<Boolean> {

    private final String item;

    public VerifyTodoItem(String item) {
        this.item = item;
    }

    public static VerifyTodoItem isDisplayed(String item) {
        return new VerifyTodoItem(item);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(TODO_LIST).answeredBy(actor).contains(item);
    }
}
