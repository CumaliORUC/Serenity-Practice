package scenario2.tests;


import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import scenario2.pages.Todo_Page;

import scenario2.steps.DesiredSteps;
import scenario2.steps.todoSteps;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestTodoList {
/*
    @CastMember //doğrudan setuplama yapar
    Actor ali;

 */


    @Managed
    WebDriver browser;
    Actor ali= Actor.named("Ali");

    @BeforeEach
    public void setUp(){
        ali.can(BrowseTheWeb.with(browser));  //burada ali'ye ability kazandırdık. Böylece
                                              //webdirver ile etkileşime girebildi.
    }



    @Steps
    todoSteps todosteps;

    @Test
    public void testList(){
        todosteps.isOnTodoPage();
        todosteps.addItemsToDoList();
    }

    @Test
    public void testWithActors(){
        //ali.attemptsTo(Open.browserOn().the(Todo_Page.class)); //bu da sayfaya gider.
        ali.attemptsTo(DesiredSteps.goTotheTodoPage(), //sayfaya gider
                Enter.theValue("BuySomeMilk") //target ile ekleme yapar.
                        .into(Todo_Page.Add_TO_Items_Field).thenHit(Keys.ENTER));
    }

    @Test
    public void testWithActors2(){
        //ali doğrudan steps sayfasında oluşturduğumuz methodları kullanır.
        ali.attemptsTo(DesiredSteps.goTotheTodoPage(),
                DesiredSteps.addItems("Buy eggs"));
    }
}
