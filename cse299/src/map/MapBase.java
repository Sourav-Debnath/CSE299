package map;

import controller.ControllerBase;
import javafx.scene.web.WebView;

public class MapBase extends ControllerBase {

    protected boolean isMarkerSet(WebView webView){
        return !(webView.getEngine().executeScript("getLat()") == null && webView.getEngine().executeScript("getLng()") == null);
    }

    protected Object getLat(WebView webView){
        return webView.getEngine().executeScript("getLat()");
    }

    protected Object getLng(WebView webView){
        return webView.getEngine().executeScript("getLng()");
    }
}
