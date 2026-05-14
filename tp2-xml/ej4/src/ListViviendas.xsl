<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" indent="yes"/>

    <xsl:template match="vivienda">
        <p style="color: #D8CBC7; background-color: #011936; border-radius: 10px; padding: 10px; font-family: helvetica">
          Vivienda: <xsl:value-of select="id"/><br/>
          <br/>
          Calle: <xsl:value-of select="calle"/><br/>
          Número: <xsl:value-of select="nro"/><br/>
          Titular: <xsl:value-of select="titular"/><br/>
          Habitantes: <xsl:value-of select="habitantes"/><br/>
          Barrio: <xsl:value-of select="barrio_id"/><br/>
        </p>
    </xsl:template>
  
</xsl:stylesheet>