import org.apache.jena.rdf.model.*;

public class JenaRDF extends Object{
    public static void main(String[] args) {
        String personUri = "http://somewhere/person#john";
        String genidURI = "genid:A30163";
        String batmanURI = "http://somewhere/person#Batman";

        String nameSpace = "http://somewhere/person#";

        String givenName = "John";
        String familyName = "Smith";
        String nickName = "JS";
        String fullName = givenName + " " + familyName;

        Model model = ModelFactory.createDefaultModel();

        Property nsName = model.createProperty(nameSpace + "Name");
        Property nsGiven = model.createProperty(nameSpace + "Given");
        Property nsFamily = model.createProperty(nameSpace + "Family");
        Property nsNickName = model.createProperty(nameSpace + "NickName");
        Property nsFullName = model.createProperty(nameSpace + "FullName");
        Property nsWatchMovie = model.createProperty(nameSpace + "WatchMovie");
        Property nsMovieTitle = model.createProperty(nameSpace + "MovieTitle");

        Resource johnSmith = model.createResource(personUri)
                                .addProperty(nsFullName, fullName)
                                .addProperty(nsNickName, nickName)
                                .addProperty(nsName,
                                        model.createResource(genidURI)
                                                .addProperty(nsGiven, givenName)
                                                .addProperty(nsFamily, familyName)
                                )
                                .addProperty(nsWatchMovie,
                                        model.createResource(batmanURI)
                                                .addProperty(nsMovieTitle, "The Dark Knight")
                                );

        model.write(System.out, "TURTLE");
    }
}
