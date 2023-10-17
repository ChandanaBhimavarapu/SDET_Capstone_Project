import time
import pytest
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.implicitly_wait(60)
browser = "https://www.saucedemo.com/"
driver.implicitly_wait(90)
driver.get(browser)
driver.maximize_window()
driver.find_element_by_id("user-name").sendkeys('standard_user')
driver.find_element_by_id("password").sendkeys('secret_sauce')
demo = driver.find_element_by_id("login-button").click

# Function to add an item to the cart
def test_add_to_cart(setup):
    driver = setup
    add_to_cart_button = driver.find_element(By.XPATH, "//button[text()='ADD TO CART']")
    add_to_cart_button.click()

    # Verify item is added to the cart by checking the cart icon
    cart_icon = driver.find_element(By.XPATH, "//span[@class='shopping_cart_badge']")
    assert cart_icon.text == "1"


# Function to click on the right corner of the cart icon
def test_click_right_corner(setup):
    driver = setup
    cart_icon = driver.find_element(By.XPATH, "//div[@id='shopping_cart_container']")

    # Use ActionChains to click on the right corner of the cart icon
    actions = ActionChains(driver)
    actions.move_to_element(cart_icon).move_by_offset(10, 0).click().perform()

    # Verify that the cart page is displayed
    assert "Your Cart" in driver.title


# Function to click on the left corner of the cart icon and logout
def test_click_left_corner_and_logout(setup):
    driver = setup
    cart_icon = driver.find_element(By.XPATH, "//div[@id='shopping_cart_container']")

    # Use ActionChains to click on the left corner of the cart icon
    actions = ActionChains(driver)
    actions.move_to_element(cart_icon).move_by_offset(-10, 0).click().perform()

    # Click on the LOGOUT button
    logout_button = driver.find_element(By.XPATH, "//a[text()='LOGOUT']")
    logout_button.click()

    # Verify that the user is logged out by checking the login page
    assert "Swag Labs" in driver.title

