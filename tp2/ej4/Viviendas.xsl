<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <html lang="en">
        <head>
            <meta charset="UTF-8"/>
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
            <title>Gestión de Viviendas</title>
        </head>
        <body>
            <div>
                <h2>Gestión de viviendas</h2>
            </div>
            <div>
                <xsl:for-each select="./viviendas/vivienda">
                    <p>
                        <xsl:value-of select="calle"/>
                        <xsl:value-of select="nro"/>
                        <xsl:value-of select="titular"/>
                        <xsl:value-of select="habitantes"/>
                    </p>
                </xsl:for-each>
            </div>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>