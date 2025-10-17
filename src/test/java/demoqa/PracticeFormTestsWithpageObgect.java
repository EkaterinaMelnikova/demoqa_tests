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
        String userEmail1 = "vasia@vasia.com";
        String userGender = "Male";
        String userPhone = "1234567890";
        String birthYear = "2011";
        String birthMonth = "July";
        String birthDay = "07";
        String birthDate = birthDay + " " + birthMonth + "," + birthYear;
        String userSubject = "Math";
        String userHobbie = "Reading";
        String img = "img/1.png";
        String userAddress = "Address 123";
        String userState = "NCR";
        String userCity = "Delhi";


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userlastName)
                .setEmail(userEmail1)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(birthDay,birthMonth,birthYear)
                .setSubject(userSubject)
                .setHobbie(userHobbie)
                .setPicture(img)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .submit();



        registrationPage.verifyResultsModalAppear()
                .verifyResult("Student Name", userName + userlastName)
                .verifyResult("Student Email", userEmail1)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", birthDate);


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




