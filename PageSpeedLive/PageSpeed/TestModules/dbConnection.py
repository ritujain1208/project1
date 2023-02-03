from datetime import date

import mysql
import mysql.connector


class dbConnection():
    def dbconn(typeofdevice,page_Name,urls,Performance,Accessibility,SEO,Best_Practice):

        mydb = mysql.connector.connect(
            host="127.0.0.1",
            user="root",
            password="cool",
            database="pagespeed_sco"
        )

        mycursor = mydb.cursor()
        today = date.today()
        print("ritu")
        sql = "INSERT INTO pagespeedsi (typeofdevice, page_Name,urls,Performance,Accessibility,SEO,Best_Practice,date) VALUES (%s, %s,%s,%s,%s,%s,%s,%s)"
        val = (typeofdevice, page_Name, urls,Performance,Accessibility,SEO, Best_Practice,today)
        mycursor.execute(sql, val)

        mydb.commit()

        print(mycursor.rowcount, "record inserted.")



