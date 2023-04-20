module Stormbird {
    requires hanyaeger;
    requires java.sql;
    requires mssql.jdbc;

    exports nl.camorobot.stormbird;

    opens audio;
    opens backgrounds;
    opens sprites;
}