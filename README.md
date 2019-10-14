# bot
steps for running:

1: clone repo

git clone -b master git@github.com:vifelso/bot.git

2: install maven

https://maven.apache.org/install.html

3: run this script from project folder

mvn clean spring-boot:run

It's all. Now project is running.

###########################
Username bot and password bot:

Bot name and it's token are located in application.properties

telegram.username=hryharenka_bot
telegram.token=846887603:AAHaT4vMBDUDKBtHwm3qdAmNvowI8pT5lvk

Also I use H2 database.

username and pass for db are:
spring.datasource.username=sa
spring.datasource.password=password