# MrFreeze Settings API
This is an API for storing, retrieving and altering settings for the Penposium Discord server's
bot [MrFreeze](https://github.com/terminalnode/mrfreeze). Currently the bot doesn't use any kind
of authentication and as such is meant to run only as a local server accessible to a bot running
locally.

## Running the application
To run the application you only need a functional Postgres server with a database called
`mrfreeze_settings` and a user with the name and password `mrfreeze`. Then you just run the app
with `gradle bootRun`. If you don't have Gradle installed it also comes with gradle wrapper
scripts, `gradlew` for reasonable operating systems and `gradlew.bat` for Windows.

If you want to change the database name, user or password used these values are set in
`src/main/resources/application.properties`. You can also change which database it's using, but
if you intend to contribute to the projects you have to test your changes against a postgres
database to make sure it's working properly.

## Why does this need to exist?
The primary reason for anything that has to do with MrFreeze is that it's fun, and that goes for
this as well. It's a fine excuse for writing a springboot project in Kotlin and that's as good a
reason as any.

But there are also a bunch of practical reasons:
- It may allow us to build a website for managing settings at some point in the future.
- It allows us to remove a lot of low quality code from the bot.
- It allows us to use JPA/Hibernate, which is way nicer than SQL Alchemy or whatever.
- It makes transitioning to a more sophisticated database (from current SQLite) very smooth.
- Since the bot code is reduced it makes any changes much easier.

Basically the main reason is that I really want a good ORM system for all data stored that's
stored in the bot. I'm somewhat familiar and comfortable with JPA/Hibernate, but I'm not at all
comfortable with SQL Alchemy or the other Python ORM libraries. So a "microservice" seems like a
good idea... maybe?

## Development/Testing/Staging API on Heroku
As mentioned the API is currently meant to run locally on the same machine as the bot, because
there is no authentication enabled yet. Running it on a public server would give anyone access to
do anything they want - not good. However, because the API (once the bot starts using it) is
enabled it will be required for developing the bot.

With this is mind I've set it up for automatic deployments on every push
[on Heroku](https://mrfreeze-settings-api.herokuapp.com/), meaning that a version of the API
should always be available on this URL. It's a free heroku account and will thus go to sleep
every now and then. To ensure that it's awake you can visit the
[testing site](https://mrfreeze-settings-api.herokuapp.com/test) in your browser, which should
present you with a simple web page.

Waking the server up isn't always necessary, ideally the bot should be built in such a way that it
has strategies for handling an unresponsive API as well, but it makes things a bit more predictable
and allows you to verify that it is working.
