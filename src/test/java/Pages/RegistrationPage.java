package Pages;

import Pages.components.CalendarComponent;
import Pages.components.RegistrationResultsModal;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal  = new RegistrationResultsModal();


    private final String titleText ="Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            dateOfBirthInput = $("#dateOfBirthInput");


    public RegistrationPage openPage(){
        open ("/automation-practice-form");
        $(".text-center").shouldHave(text(titleText));
        //executeJavaScript("$('#fixedban').remove()");
        //executeJavaScript("$('footer').remove()");

        return this;

    }

    public RegistrationPage setFirstName(String value){
        firstNameInput .setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        $("#userEmail").setValue(value); // доработать

        return this;
    }

    public RegistrationPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click(); // доработать

        return this;
    }

    public RegistrationPage setPhone(String value){
        $("#userNumber").setValue(value);// доработать

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }


    public RegistrationPage verifyResultsModalAppear(){
        RegistrationResultsModal.verifyModalAppears();// доработать

        return this;
    }


    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}
