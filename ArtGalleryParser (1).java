import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class ArtGalleryParser {
    public static void main(String[] args) {
        try {
            // Create a SAXParserFactory instance
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Define a handler for parsing the XML content
            DefaultHandler handler = new Defaum ltHandler() {
                boolean isArtPiece = false;
                StringBuilder artistName = new StringBuilder();
                StringBuilder artistDescription = new StringBuilder();
                StringBuilder galleryDescription = new StringBuilder();
                StringBuilder artStyle = new StringBuilder();
                StringBuilder yearCreated = new StringBuilder();
                StringBuilder rating = new StringBuilder();

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("artPiece")) {
                        isArtPiece = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (isArtPiece) {
                        // Collect data based on the current context
                        String content = new String(ch, start, length).trim();
                        if (artistName.length() == 0) {
                            artistName.append(content);
                        } else if (artistDescription.length() == 0) {
                            artistDescription.append(content);
                        } else if (galleryDescription.length() == 0) {
                            galleryDescription.append(content);
                        } else if (artStyle.length() == 0) {
                            artStyle.append(content);
                        } else if (yearCreated.length() == 0) {
                            yearCreated.append(content);
                        } else if (rating.length() == 0) {
                            rating.append(content);
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("artPiece")) {
                        // Print collected data for the art piece
                        System.out.println("Artist Name: " + artistName.toString().trim());
                        System.out.println("Artist Description: " + artistDescription.toString().trim());
                        System.out.println("Gallery Description: " + galleryDescription.toString().trim());
                        System.out.println("Art Style: " + artStyle.toString().trim());
                        System.out.println("Year Created: " + yearCreated.toString().trim());
                        System.out.println("Rating: " + rating.toString().trim());
                        
                        // Reset for the next art piece
                        isArtPiece = false;
                        artistName.setLength(0);
                        artistDescription.setLength(0);
                        galleryDescription.setLength(0);
                        artStyle.setLength(0);
                        yearCreated.setLength(0);
                        rating.setLength(0);
                    }
                }
            };

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

            // Parse the XML input
            saxParser.parse(new java.io.ByteArrayInputStream(xmlInput.getBytes()), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
