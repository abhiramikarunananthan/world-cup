module no.abhiramikarunananthan.worldcup {
    requires javafx.controls;
    requires javafx.fxml;


    opens no.abhiramikarunananthan.worldcup to javafx.fxml;
    exports no.abhiramikarunananthan.worldcup;
}