<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html lang="en">
        <head>
            <meta charset="UTF-8"/>
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
            <title><xsl:value-of select="./calificaciones/@fecha"/></title>
        </head>
        <body>
            <h2>Calificaciones <xsl:value-of select="./calificaciones/@fecha"/></h2>

            <table>
                <tr>
                    <th>Nombre</th>
                    <th>Materia</th>
                    <th>Nota</th>
                </tr>
                <xsl:for-each select="calificaciones/alumno">
                    <xsl:sort select="nota" order="descending"/>
                    <tr>
                        <td>
                            <xsl:value-of select="nombre"/>
                            <xsl:if test="@tipo='recursante'">
                                *
                            </xsl:if>
                        </td>
                        <td>
                        <xsl:value-of select="materia"/>    
                        </td>
                        <td>
                            <xsl:attribute name="style">
                                <xsl:choose>
                                    <xsl:when test="nota &gt; 70">
                                        background-color: green;
                                    </xsl:when>
                                    <xsl:when test="nota &gt;= 40">
                                        background-color: yellow;
                                    </xsl:when>
                                    <xsl:otherwise>
                                    background-color: red;
                                    </xsl:otherwise>
                                </xsl:choose>
                            </xsl:attribute>
                            <xsl:value-of select="nota"/>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
            <p>* El alumno es recursante</p>
            <p>
                Total alumnos: <xsl:value-of select="count(calificaciones/alumno)"/>
            </p>
            <p>
                Total aprobados: <xsl:value-of select="count(calificaciones/alumno[nota &gt; 70])"/>
            </p>
            <p>
                Total desaprobados: <xsl:value-of select="count(calificaciones/alumno[nota &lt; 70])"/>
            </p>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>