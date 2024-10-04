<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    
    <xsl:template match="/artGallery">
        <html>
            <head>
                <title>Art Gallery</title>
            </head>
            <body>
                <h1>Art Gallery</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Artist Name</th>
                        <th>Description</th>
                        <th>Gallery Description</th>
                        <th>Art Style</th>
                        <th>Year Created</th>
                        <th>Rating</th>
                    </tr>
                    <xsl:for-each select="artPiece">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="artistName"/></td>
                            <td><xsl:value-of select="artistDescription"/></td>
                            <td><xsl:value-of select="galleryDescription"/></td>
                            <td><xsl:value-of select="artStyle"/></td>
                            <td><xsl:value-of select="yearCreated"/></td>
                            <td><xsl:value-of select="rating"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
