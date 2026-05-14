<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <aprobados>
            <xsl:for-each select="calificaciones/alumno[nota &gt; 70]">
                <alumno>
                    <nombre> <xsl:value-of select="nombre"/> </nombre>
                    <materia> <xsl:value-of select="materia"/> </materia>
                    <carrera> <xsl:value-of select="carrera"/> </carrera>
                    <nota> <xsl:value-of select="nota"/> </nota>
                </alumno>
            </xsl:for-each>
        </aprobados>
    </xsl:template>
</xsl:stylesheet>