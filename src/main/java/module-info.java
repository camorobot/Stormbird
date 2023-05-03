module Stormbird {
    requires hanyaeger;
    requires java.sql;
    requires mssql.jdbc;

    exports nl.camorobot.stormbird;
    exports nl.camorobot.stormbird.birds;

    opens audio;
    opens backgrounds;
    opens sprites;
}