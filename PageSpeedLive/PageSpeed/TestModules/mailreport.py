# # libraries to be imported
import smtplib
from datetime import date
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders


#
def mail_send(file_name):
    # cc = ['ritu@singleinterface.com','deepika.sheoran@singleinterface.com','priyanka.rautela@singleinterface.com','bhaskar.vishwakarma@singleinterface.com']
    fromaddr = "automationscripts@singleinterface.com"
    toaddr = "ritu@singleinterface.com"
    filename = file_name
    passwordfrom = "ZZH3=uAe1"
    print("Now, Sending Mail ....")
    try:
        msg = MIMEMultipart()
        msg['From'] = fromaddr
        toaddrs = [toaddr]
        print(toaddrs)
        msg['To'] = ", ".join(toaddrs)
        today = date.today()
        msg['Subject'] = "Sanity Report Of Website Page speed " + str(today)
        body = "Hi Team, \nPlease find the attached of Page Speed of SI website Report.\n\n **Red Cells have Speed Performance<80 || Accessibility < 95 || SEO < 95.\n **Green Cells have greter spped than last Month."
        msg.attach(MIMEText(body, 'plain'))
        attachment = open(filename, "rb")
        p = MIMEBase('application', 'octet-stream')
        p.set_payload((attachment).read())
        encoders.encode_base64(p)

        p.add_header('Content-Disposition', "attachment; filename= %s" % filename)
        msg.attach(p)
        s = smtplib.SMTP('smtp.gmail.com', 587)

        s.starttls()

        s.login(fromaddr, passwordfrom)
        text = msg.as_string()
        s.sendmail(fromaddr, toaddrs, text)
        s.quit()
        print('Mail sent successfully.')
    except Exception as e:
        print(e)

