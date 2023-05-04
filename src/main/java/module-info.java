module Stormbird {
    requires hanyaeger;
    requires java.sql;
    requires mssql.jdbc;
    requires io.github.cdimascio.dotenv.java;

    exports nl.camorobot.stormbird;
    exports nl.camorobot.stormbird.birds;

    opens audio;
    opens backgrounds;
    opens sprites;
}