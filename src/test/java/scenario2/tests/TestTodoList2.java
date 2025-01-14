package scenario2.tests;


import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import scenario2.steps.DesiredSteps;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestTodoList2 {

    @CastMember //doğrudan setuplama yapar
    Actor ali;

    @BeforeEach
    public void setup(){
    ali.attemptsTo(DesiredSteps.goTotheTodoPage());
    }

    String[] items = {"buy milk", "buy egg", "mix egg and milk", "make omlet"};
    @Test
    public void testWithAli(){
        //ali doğrudan steps sayfasında oluşturduğumuz methodları kullanır.
        for (String item : items) {
            ali.attemptsTo(DesiredSteps.addItems(item));
        }

        for (String item : items) {
            //ali.should(seeThat(VerifyTodoItem.isDisplayed(task), is(true)));
            ali.attemptsTo(DesiredSteps.verifyItemIsAdded(item));
        }

        ali.attemptsTo(DesiredSteps.verifyTotalTaskCount());

    }
}
