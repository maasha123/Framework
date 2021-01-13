package test;

import static org.assertj.core.api.Assertions.*;

import model.User;
import org.testng.annotations.Test;
import page.AccountPage;
import page.LoginPage;
import service.UserCreator;

public class LoginTest extends CommonConditions{
    @Test
    public void userAccessTest(){
        logger.info("userAccessTest");
        User testUser= UserCreator.withAllProperty();
        LoginPage loginPage= new LoginPage(driver)
                .openPage()
                .inputUserLogin(testUser.getEmail())
                .inputUserPassword(testUser.getPassword());

        String currentUrl=loginPage.getCurrentUrl();
        loginPage.clickSubmitButton();

        assertThat(loginPage.getCurrentUrl()).isNotEqualTo(currentUrl);

        AccountPage accountPage= loginPage.clickGoToAccountPageButton();
        assertThat(accountPage.getUserLastName()).isEqualTo(testUser.getLastName());
        assertThat(accountPage.getUserEmail()).isEqualTo(testUser.getEmail());
        
    }

    @Test 
    public void checkRegistrationWithIncorrectData(){
        logger.info("checkRegistrationWithIncorrectData");
        LoginPage loginPage= new LoginPage(driver)
                  .openPage()
                  .inputEmailRegistration()
                  .inputPasswordRegistration()
                  .createAccount();

        assertThat(loginPage.getErrorEmailSpan()).isEqualTo("Пожалуйста, введите корректный адрес электронной почты");
        assertThat(loginPage.getErrorPasswordSpan()).isEqualTo("Пожалуйста, заполните поле");
    }
}
