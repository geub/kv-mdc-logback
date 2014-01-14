kv-mdc-logback [![Build Status](https://travis-ci.org/geub/kv-mdc-logback.png?branch=master)](https://travis-ci.org/geub/kv-mdc-logback)
====================

KeyValue Mapped Diagnostic Context converter for logback.
* Display log string variables mapped in MDC like `key="value"`;
* Allows to include a default value in case the value of the MDC is empty;
* Remove the key if the value is empty.

Configuration example
--------------------
**Simple**

logback.xml:

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender"> 
        <layout class="com.github.geub.kv.mdc.logback.KeyValuePatternLayout">
            <Pattern>%KV{first} %KV{last} - %m%n</Pattern>
        </layout> 
    </appender>

Output for first (Tim) and last (Maia):

    first="Tim" last="Maia" - msg

**With blank value**

logback.xml:

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender"> 
        <layout class="com.github.geub.kv.mdc.logback.KeyValuePatternLayout">
            <Pattern>%KV{first} %KV{last} - %m%n</Pattern>
        </layout> 
    </appender>

Output for first (Tim) and last ():

    first="Tim" - msg
    
**With blank value and default value**

logback.xml:

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender"> 
        <layout class="com.github.geub.kv.mdc.logback.KeyValuePatternLayout">
            <Pattern>%KV{first} %KV{last, Maia} - %m%n</Pattern>
        </layout> 
    </appender>

Output for first (Tim) and last ():

    first="Tim" last="Maia" - msg

More
--------------------
* Mapped Diagnostic Context: <http://logback.qos.ch/manual/mdc.html>,

Release
-------

* 1.0.0
    - Initial project.
* 1.0.1
    - Changed the way double spaces are replaced.
* 1.0.2
    - Changed the project name.
* 1.0.3-SNAPSHOT
    - Included travis.

