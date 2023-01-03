module com.fg.footballgames {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.fg.footballgames.Admin to javafx.fxml;
    exports com.fg.footballgames.Admin;

    opens com.fg.footballgames.Admin.Controllers to javafx.fxml;
    exports com.fg.footballgames.Admin.Controllers;

    opens com.fg.footballgames.User to javafx.fxml;
    exports com.fg.footballgames.User;

    opens com.fg.footballgames.User.Controllers to javafx.fxml;
    exports com.fg.footballgames.User.Controllers;


}