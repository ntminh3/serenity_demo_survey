package pageObject;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.util.Objects;

public class SurveyPage extends PageObject {

    public void chooseAnswer(String answer) {
        WebElementFacade btnAnswer =
                $(By.xpath("//span[contains(text(), '" + answer + "')]"));
        btnAnswer.waitUntilVisible().click();
    }

    public void clickOnNextButton() {
        WebElementFacade btnNext = $(By.xpath("//button[@type='submit' and contains(text(), 'Next')]"));
        btnNext.click();
    }

    public String verifyMessage(String message) {
        WebElementFacade lblMessage = $(By.xpath("//div[@role='heading' and contains(@class, 'h3 page-subtitle')]/div"));
        Assert.assertEquals(lblMessage.waitUntilVisible().getText(), message);
        return lblMessage.waitUntilVisible().getText();
    }

    public String verifyButtonStatus(String answer) {
        WebElementFacade radioButton = $(By.xpath("//span[contains(text(), '"+ answer +"')]//..//preceding-sibling::input"));
        String status = radioButton.getAttribute("aria-checked");
        if (Objects.equals(status, "true"))
            return "Answer "+ answer +" is chosen";
        else return "Answer "+ answer +" is not chosen";
    }

    public void clickOnPrevButton() {
        WebElementFacade btnPrev = $(By.xpath("//button[@type='submit' and contains(text(), 'Prev')]"));
        btnPrev.click();
    }
}
