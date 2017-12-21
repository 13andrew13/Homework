package my.prog.web;

import java.util.HashMap;
import java.util.Map;

public class ViewModel {

    private final String PREFIX = "/WEB-INF/";
    private final String SUFIX = ".jsp";

    private Map<String,Object> argumentsMap = new HashMap<> ();
    private String view;

    public ViewModel (String view) {
        this.view = view;
    }

    public ViewModel (Map<String, Object> argumentsMap, String view) {
        this.argumentsMap = argumentsMap;
        this.view = view;
    }

    public Map<String, Object> getArgumentsMap () {
        return argumentsMap;
    }

    public void setArgument(String argname,Object arg) {
        this.argumentsMap.put (argname,arg);
    }

    public String getView () {
        return String.format ("%s%s%s",PREFIX, view, SUFIX);
    }

    public void setView (String view) {
        this.view = view;
    }
}
