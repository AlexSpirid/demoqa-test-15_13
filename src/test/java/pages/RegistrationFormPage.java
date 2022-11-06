package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.AddressComponent;
import pages.components.CalendarComponent;
import pages.components.SubmittingFormComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private final static String TITLE_TEXT = "Student Registration Form";
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final SubmittingFormComponent resultsModal = new SubmittingFormComponent();
    private final AddressComponent adressComponent = new AddressComponent();
    private final SelenideElement
            firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.shouldBe(visible).setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.shouldBe(visible).setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.shouldBe(visible).setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).shouldBe(visible).click();
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").shouldBe(visible).setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").shouldBe(visible).click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        $("#subjectsInput").shouldBe(visible).setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).shouldBe(visible).click();
        return this;
    }

    public RegistrationFormPage setPicture(String value) {
        $("#uploadPicture").shouldBe(visible).uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setAddress(String address, String state, String city) {
        adressComponent.setDate(address, state, city);
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        $("#submit").shouldBe(visible).click();
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);
        return this;
    }
}
