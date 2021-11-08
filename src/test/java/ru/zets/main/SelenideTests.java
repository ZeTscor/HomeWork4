package ru.zets.main;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.*;


public class SelenideTests {
    @Test
    void SoftAssertion() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(byText("Show 2 more pages…")).click();
        $(byClassName("wiki-rightbar")).$(byLinkText("SoftAssertions")).shouldBe(Condition.visible).click();
        $("#wiki-body").$(byText("Using JUnit5 extend test class:")).shouldBe(Condition.visible);
    }

    @Test
    void ActionsDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement elementA = $(byText("A"));
        actions().dragAndDropBy(elementA, 50, 0).perform();
        $("#content").$("#column-a").$(byText("B")).shouldBe(Condition.visible);
    }

    @Test
    void ElementDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(byText("A")).dragAndDropTo($(byText("B")));
        $("#content").$("#column-a").$(byText("B")).shouldBe(Condition.visible);
    }
}
