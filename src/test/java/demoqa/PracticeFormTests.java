package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillPracticeFormTest(){

        open ("/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Вася");
        $("#lastName").setValue("Васечкин");
        $("#userEmail").setValue("vasia@vasia.com");
        // $("#gender-radio-1").click(); WRONG
        $("#gender-radio-1").parent().click(); //GOOD
        $(byText("Other")).parent().click(); //not very good
        $("label[for=gender-radio-2]").click(); //GOOD
        $("#genterWrapper").$(byText("Male")).click(); //BEST
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();//?????????????не нашла, списала
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Address 123");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();



        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Вася"), text("Васечкин"),
                text("vasia@vasia.com"), text("1234567890"));

    }






}
