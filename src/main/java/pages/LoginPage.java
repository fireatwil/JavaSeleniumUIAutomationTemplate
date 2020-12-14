package pages;

import maps.LoginMap;
import support.BaseCommands;

public class LoginPage {

    LoginMap loginMap = new LoginMap();
    BaseCommands baseCommands = new BaseCommands();

    public void switchToIFrame() {
        baseCommands.switchToFrame(loginMap.IFRAME);
    }

    public void enterUsername(String username) {
        switchToIFrame();
        baseCommands.clickOnElement(loginMap.USERNAME);
        baseCommands.clearAndEnterText(loginMap.USERNAME, username);
    }

    public void enterPassword(String password) {
        baseCommands.clickOnElement(loginMap.PASSWORD);
        baseCommands.clearAndEnterText(loginMap.PASSWORD, password);
    }

    public void clickOnLoginButton() {
        baseCommands.clickOnElement(loginMap.LOGIN_BUTTON);
    }

}
