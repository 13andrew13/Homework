package my.prog.web;

public enum Methods {
    GET{
        @Override
        public String toString () {
            return "GET";
        }
    },
    POST{
        @Override
        public String toString () {
            return "POST";
        }
    }
}
