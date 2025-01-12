package starter.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.tasks.AddTodoItem;
import starter.questions.VerifyTodoItem;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SerenityJUnit5Extension.class)
public class TodoListTest {
    Actor user = Actor.named("User");
    WebDriver driver = new ChromeDriver();

    @Test
    public void userCanAddItemsToTodoList() {

        user.can(BrowseTheWeb.with(driver));

        user.attemptsTo(
                Open.url("https://todo-app.serenity-js.org/#/")
        );

        String[] tasks = {"buy milk", "buy egg", "mix egg and milk", "make omlet"};

        for (String task : tasks) {
            user.attemptsTo(AddTodoItem.called(task));
        }

        for (String task : tasks) {
            user.should(seeThat(VerifyTodoItem.isDisplayed(task), is(true)));
        }
    }

    @Test
    public void userCanCheckItemsToTodoList() {



        String[] tasks2 = {"buy milk", "buy egg", "mix egg and milk", "make omlet"};

        for (String task : tasks2) {
            user.attemptsTo(AddTodoItem.called(task));
        }

        for (String task : tasks2) {
            user.should(seeThat(VerifyTodoItem.isDisplayed(task), is(true)));
        }
    }
}
