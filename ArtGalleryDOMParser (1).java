import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.Scanner;

public class ArtGalleryDOMParser {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Embedded XML string (replace this with your actual XML content)
            String xmlInput = "<artGallery>"
                                + "<artPiece id=\"1\">"
                                + "<artistName>Frida Kahlo (1907-1954)</artistName>"
                                + "<artistDescription>Mexican painter known for her self-portraits and works inspired by nature, identity, and post-colonialism.</artistDescription>"
                                + "<galleryDescription>A vivid exploration of personal and cultural identity through powerful self-portraits.</galleryDescription>"
                                + "<artStyle>Surrealism</artStyle>"
                                + "<yearCreated>1940</yearCreated>"
                                + "<rating>4.8</rating>"
                                + "</artPiece>"
                                + "<artPiece id=\"2\">"
                                + "<artistName>Roy Lichtenstein (1923-1997)</artistName>"
                                + "<artistDescription>Pop artist famous for his comic strip-style paintings, using bold colors and patterns in popular culture.</artistDescription>"
                                + "<galleryDescription>Iconic pop art depicting commercial and comic book imagery with a distinctive style.</galleryDescription>"
                                + "<artStyle>Pop Art</artStyle>"
                                + "<yearCreated>1964</yearCreated>"
                                + "<rating>4.7</rating>"
                                + "</artPiece>"
                                + "</artGallery>";

            // Parse the XML input from a ByteArrayInputStream
            Document doc = builder.parse(new java.io.ByteArrayInputStream(xmlInput.getBytes()));

            // Normalize the XML structure
            doc.getDocumentElement().normalize();

            // Get user input for the art piece id
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the art piece id: ");
            String inputId = scanner.nextLine();

            // Get all artPiece elements
            NodeList artPieces = doc.getElementsByTagName("artPiece");

            // Loop through each artPiece to find the matching id
            boolean found = false;
            for (int i = 0; i < artPieces.getLength(); i++) {
                Element artPiece = (Element) artPieces.item(i);

                // Check if the id matches the user input
                if (artPiece.getAttribute("id").equals(inputId)) {
                    found = true;
                    // Extract artist details
                    String artistName = artPiece.getElementsByTagName("artistName").item(0).getTextContent();
                    String artistDescription = artPiece.getElementsByTagName("artistDescription").item(0).getTextContent();
                    String artStyle = artPiece.getElementsByTagName("artStyle").item(0).getTextContent();
                    String yearCreated = artPiece.getElementsByTagName("yearCreated").item(0).getTextContent();
                    String rating = artPiece.getElementsByTagName("rating").item(0).getTextContent();

                    // Print collected data for the art piece
                    System.out.println("Artist Name: " + artistName);
                    System.out.println("Artist Description: " + artistDescription);
                    System.out.println("Art Style: " + artStyle);
                    System.out.println("Year Created: " + yearCreated);
                    System.out.println("Rating: " + rating);
                    break;
                }
            }

            if (!found) {
                System.out.println("No art piece found with id: " + inputId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
