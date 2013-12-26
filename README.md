kv-converter-logback
====================

KeyValue Mapped Diagnostic Context converter for logback.
* Display MDC like `key="value"`;
* Allows to include a default value in case the value of the MDC is empty;
* Remove the key if the value is empty.

Configuration example
--------------------
**Simple**

logback.xml:

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender"> 
        <layout>
            <Pattern>%KV{first} %KV{last} - %m%n</Pattern>
        </layout> 
    </appender>

Output for first (Tim) and last (Maia):

    first="Tim" last="Maia" - msg

**With blank value**

logback.xml:

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender"> 
        <layout>
            <Pattern>%KV{first} %KV{last} - %m%n</Pattern>
        </layout> 
    </appender>

Output for first (Tim) and last ():

    first="Tim" - msg
    
**With blank value and default value**

logback.xml:

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender"> 
        <layout>
            <Pattern>%KV{first} %KV{last, Maia} - %m%n</Pattern>
        </layout> 
    </appender>

Output for first (Tim) and last ():

    first="Tim" last="Maia" - msg

More
--------------------
* Mapped Diagnostic Context: <http://logback.qos.ch/manual/mdc.html>,
