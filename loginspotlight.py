import urllib.request
import smtplib
#import pandas as pd
import urllib.request
import smtplib
import time

from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.service import Service
#from webdriver_manager.chrome import ChromeDriverManager
import urllib.request
import smtplib

import xlsxwriter

# open excel file
#wb = xlsxwriter.Workbook('C:/Users/Admin/Downloads/checklogintestcase.xlsx')
wb = xlsxwriter.Workbook('C:/riddhi/checklogintestcase.xlsx')
worksheet = wb.add_worksheet()
worksheet.write(0, 0, 'Valid Id Valid Password')
worksheet.write(1, 0, 'Valid Id Invalid Password')
worksheet.write(2, 0, 'Invalid Id Valid Password')
worksheet.write(3, 0, 'Invalid Id Invalid Password')
worksheet.write(4, 0, 'Blank')

# Chrome driver
# s = Service('C:/Users/Admin/chromedriver.exe')
#driver = webdriver.Chrome('C:/Users/Admin/Downloads/chromedriver_win32/chromedriver')

# driver = webdriver.Chrome()
#driver = webdriver.Chrome(executable_path = r"C:\Users\Admin\PycharmProjects\leadform\singleinterface\driver\chromedriver.exe")
driver = webdriver.Chrome('D:\DDWorkspace\Preprod\ChromeDriver\chromedriver.exe')

# login URL
driver.get("https://test.myspotlight.co/login")

driver.maximize_window()
# Test Case 1


# Login credentials
username = "myragoel25@gmail.com"
password = "e@6#LzSFW;"

# Credentials
# driver.find_element_by_id("users-email").send_keys(username)
#driver.find_element(By.ID,"users-email").send_keys(username)
driver.find_element_by_id("users-email").send_keys(username)
driver.find_element_by_id("users-password").send_keys(password)

# login button
driver.find_element_by_id("login-submit").click()

time.sleep(10)

# current URL
Current = driver.current_url
print(Current)

if (Current != "https://test.myspotlight.co/login"):
    worksheet.write(0, 1, 'Pass')
else:
    worksheet.write(0, 1, 'Fail')

driver.close()

# Test Case 2 (right id and wrong password)
#driver = webdriver.Chrome('C:/Users/Admin/Downloads/chromedriver_win32/chromedriver')
# login URL
#driver = webdriver.Chrome(executable_path = r"C:\Users\Admin\PycharmProjects\leadform\singleinterface\driver\chromedriver.exe")
driver = webdriver.Chrome('D:\DDWorkspace\Preprod\ChromeDriver\chromedriver.exe')
driver.get("https://test.myspotlight.co/login")

driver.maximize_window()

# Login credentials
username2 = "myragoel25@gmail.com"
password2 = "e@6#LzShhsdFW;"

# Credentials

driver.find_element_by_id("users-email").send_keys(username2)
driver.find_element_by_id("users-password").send_keys(password2)

# login button
driver.find_element_by_id("login-submit").click()

time.sleep(10)

# current URL
Current = driver.current_url

if (Current == "https://test.myspotlight.co/login"):
    worksheet.write(1, 1, 'Pass')
else:
    worksheet.write(1, 1, 'Fail')

driver.close()

# Test Case 3 (Wrong id and right password)
#driver = webdriver.Chrome('C:/Users/Admin/Downloads/chromedriver_win32/chromedriver')
# login URL
#driver = webdriver.Chrome(executable_path = r"C:\Users\Admin\PycharmProjects\leadform\singleinterface\driver\chromedriver.exe")
driver = webdriver.Chrome('D:\DDWorkspace\Preprod\ChromeDriver\chromedriver.exe')
driver.get("https://test.myspotlight.co/login")

driver.maximize_window()

# Login credentials
username3 = "myragoel200@gmail.com"
password3 = "e@6#LzSFW;"

# Credentials

driver.find_element_by_id("users-email").send_keys(username3)
driver.find_element_by_id("users-password").send_keys(password3)

# login button
driver.find_element_by_id("login-submit").click()

time.sleep(10)

# current URL
Current = driver.current_url

if (Current == "https://test.myspotlight.co/login"):
    worksheet.write(2, 1, 'Pass')
else:
    worksheet.write(2, 1, 'Fail')

driver.close()

# Test Case 4 (Wrong id and wrong password)
#driver = webdriver.Chrome('C:/Users/Admin/Downloads/chromedriver_win32/chromedriver')
# login URL
#driver = webdriver.Chrome(executable_path = r"C:\Users\Admin\PycharmProjects\leadform\singleinterface\driver\chromedriver.exe")
driver = webdriver.Chrome('D:\DDWorkspace\Preprod\ChromeDriver\chromedriver.exe')
driver.get("https://test.myspotlight.co/login")

driver.maximize_window()

# Login credentials
username4 = "myragoel2hghg5@gmail.com"
password4 = "e@6#LzSFdbsdW;"

# Credentials

driver.find_element_by_id("users-email").send_keys(username4)
driver.find_element_by_id("users-password").send_keys(password4)

# login button
driver.find_element_by_id("login-submit").click()

time.sleep(10)

# current URL
Current = driver.current_url

if (Current == "https://test.myspotlight.co/login"):
    worksheet.write(3, 1, 'Pass')
else:
    worksheet.write(3, 1, 'Fail')

driver.close()

# Test Case 5 (blank id and blank password)
#driver = webdriver.Chrome('C:/Users/Admin/Downloads/chromedriver_win32/chromedriver')
# login URL
#driver = webdriver.Chrome(executable_path = r"C:\Users\Admin\PycharmProjects\leadform\singleinterface\driver\chromedriver.exe")
driver = webdriver.Chrome('D:\DDWorkspace\Preprod\ChromeDriver\chromedriver.exe')
driver.get("https://test.myspotlight.co/login")

driver.maximize_window()

# Login credentials
username5 = " "
password5 = " "

driver.find_element_by_id("login-submit").click()

time.sleep(10)

# current URL
Current = driver.current_url

if (Current == "https://test.myspotlight.co/login"):
    worksheet.write(4, 1, 'Pass')
else:
    worksheet.write(4, 1, 'Fail')

driver.close()

wb.close()

# Python code to illustrate Sending mail with attachments
# from your Gmail account

# libraries to be imported
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders

fromaddr = "testspotlight101@gmail.com"
# toaddr = "gyandeep.sharma@singleinterface.com,deepika.sheoran@singleinterface.com,riddhi.garg@singleinterface.com"
toaddr = "riddhi.garg@singleinterface.com"
cc = ['vishvendra.singh@singleinterface.com','gyandeep.sharma@singleinterface.com','shivam.awasthi@singleinterface.com','aijaz@singleinterface.com']

toaddrs = [toaddr] + cc
#toaddrs = [toaddr]

# instance of MIMEMultipart
msg = MIMEMultipart()

# storing the senders email address
msg['From'] = fromaddr

# storing the receivers email address
# msg['To'] = toaddr
msg['To'] = ", ".join(toaddr)

# storing the subject
msg['Subject'] = "Login Page Test Cases Update"

# string to store the body of the mail
body = "Hi Team, Please check attached sheet for login testcase report Thanks"

# attach the body with the msg instance
msg.attach(MIMEText(body, 'plain'))

# open the file to be sent
filename = "checklogintestcase.xlsx"
#attachment = open("C:/Users/Admin/Downloads/checklogintestcase.xlsx", "rb")
attachment = open("C:/riddhi/checklogintestcase.xlsx", "rb")

# instance of MIMEBase and named as p
p = MIMEBase('application', 'octet-stream')

# To change the payload into encoded form
p.set_payload((attachment).read())

# encode into base64
encoders.encode_base64(p)

p.add_header('Content-Disposition', "attachment; filename= %s" % filename)

# attach the instance 'p' to instance 'msg'
msg.attach(p)

# creates SMTP session
s = smtplib.SMTP('smtp.gmail.com', 587)

# start TLS for security
s.starttls()

# Authentication
s.login(fromaddr, "Spotlight@123")

# Converts the Multipart msg into a string
text = msg.as_string()

# sending the mail
s.sendmail(fromaddr, toaddrs, text)

# terminating the session
s.quit()
