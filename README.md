# MrFreeze Settings API
This is an API for storing, retrieving and altering settings for the Penposium Discord server's
bot [MrFreeze](https://github.com/terminalnode/mrfreeze). Currently the bot doesn't use any kind
of authentication and as such is meant to run only as a local server accessible to a bot running
locally.

## Uhm... why?
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

## Test API
As of yet there's no publically available version of this API for development, since it's not
ready for use in the bot yet anyway. At some point I plan to throw it up on Heroku or something
though so developers of the bot won't have to run their own instance of it.
