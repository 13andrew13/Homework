package my.prog.web;

public class Request {
    private String uri;
    private String method;

    public Request () {
    }

    public Request (String s, String post) {
        uri = s;
        method = post;
    }

    public void setUri (String uri) {
        this.uri = uri;
    }

    public void setMethod (String method) {
        this.method = method;
    }

    public String getUri () {

        return uri;
    }

    public String getMethod () {
        return method;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;

        Request request = (Request) o;

        if (uri != null ? !uri.equals (request.uri) : request.uri != null) return false;
        return method != null ? method.equals (request.method) : request.method == null;
    }

    @Override
    public int hashCode () {
        int result = uri != null ? uri.hashCode () : 0;
        result = 31 * result + (method != null ? method.hashCode () : 0);
        return result;
    }
}
