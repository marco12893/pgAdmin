module com.example.bd_pgadmin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.bd_pgadmin to javafx.fxml;
    exports com.example.bd_pgadmin;
}