package demoqa;

import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTestsWithpageObgect extends TestBase{

    @Test
    void fillPracticeFormTest() {
        String userName = "Вася";
        String userlastName = "Васечкин";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userlastName)
                .setEmail("vasia@vasia.com")
                .setGender("Male")
                .setPhone("1234567890")
                .setBirthDate("30","July","2008");



        $("#subjectsInput").setValue("Math").pressEnter();//?????????????не нашла, списала
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Address 123");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        registrationPage.verifyResultsModalAppear()
                .verifyResult("Student Name", userName + userlastName)
                .verifyResult("Student Email", "vasia@vasia.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "30 July 2008");



        $(".table-responsive").shouldHave(text("Вася"), text("Васечкин"),
                text("vasia@vasia.com"), text("1234567890"));

    }


    @Test
    void fillPracticeFormTest2() {
        String userName = "Вася";
        String userlastName = "Васечкин";

        registrationPage.openPage();

        registrationPage.setFirstName(userName);
        registrationPage.setLastName(userlastName);
        registrationPage.setEmail("vasia@vasia.com");
        registrationPage.setGender("Male");
        registrationPage.setPhone("1234567890");

        $("#dateOfBirthInput").click();

        //..

    }


}




