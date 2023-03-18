package utils;

import static aquality.appium.mobile.application.AqualityServices.getApplication;
import static aquality.appium.mobile.application.AqualityServices.getTouchActions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.elements.actions.ElementTouchActions;
import aquality.appium.mobile.elements.interfaces.IElement;

public class SwipeUtils {

    public static void makeSwipe(IElement element, SwipeDirection swipeDirection) {
        ElementTouchActions elementTouchActions = new ElementTouchActions(element);
        elementTouchActions.scrollToElement(swipeDirection);
    }

    public static void swipeWithDirection(SwipeDirection direction) {
        Dimension size = getApplication().getDriver().manage().window().getSize();
        int startX;
        int endX;
        int startY;
        int endY;
        switch (direction) {
            case UP:
                startX = size.width / 2;
                endX = startX;
                startY = (int) (size.height * 0.8);
                endY = (int) (size.height * 0.2);
                break;
            case DOWN:
                startX = size.width / 2;
                endX = startX;
                startY = (int) (size.height * 0.2);
                endY = (int) (size.height * 0.8);
                break;
            case LEFT:
                startY = size.height / 2;
                endY = startY;
                startX = (int) (size.width * 0.8);
                endX = (int) (size.width * 0.2);
                break;
            case RIGHT:
                startY = size.height / 2;
                endY = startY;
                startX = (int) (size.width * 0.9);
                endX = (int) (size.width * 0.2);
                break;
            default:
                throw new IllegalArgumentException("Invalid swipe direction specified: " + direction);
        }
        Point startPoint = new Point(startX, startY);
        Point endPoint = new Point(endX, endY);
        getTouchActions().swipeWithLongPress(startPoint, endPoint);
    }
}
