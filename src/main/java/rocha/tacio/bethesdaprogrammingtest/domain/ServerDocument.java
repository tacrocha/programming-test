package rocha.tacio.bethesdaprogrammingtest.domain;

public class ServerDocument extends Document {

    private String pathToFile;

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ServerDocument that = (ServerDocument) o;

        return pathToFile.equals(that.pathToFile);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + pathToFile.hashCode();
        return result;
    }
}
