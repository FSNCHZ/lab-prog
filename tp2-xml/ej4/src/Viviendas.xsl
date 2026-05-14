<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <!-- Modularizo la lista de viviendas -->
    <xsl:include href="./ListViviendas.xsl"/>

    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html lang="en">
        <head>
            <meta charset="UTF-8"/>
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
            <title>Gestión de Viviendas</title>
        </head>
        <body style="padding: 0; margin: 0; background-color: #2D7DD2">
            <div style="height: 100vh">
                <div align="center" style="display:flex; justify-content: center; height: 10%; color: #D7DAE5; font-family: arial; font-style: italic">
                    <h2 style="font-weight: 300">Gestión de viviendas</h2>
                </div>
                <div style="height: 90%; padding: 1% 35% 0 35%">
                    <!-- Aplico el template de ListViviendas para cada vivienda-->
                    <xsl:apply-templates select="./viviendas/vivienda"/>
                </div>       
            </div>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>